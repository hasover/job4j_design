package ru.job4j.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrepareStatementDemo {
    private Connection connection;

    public PrepareStatementDemo() throws Exception {
        initConnection();
        createEmptyTable();
    }
    private void initConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/idea_db",
                "postgres",
                "password"
        );
    }
    private void createEmptyTable() {
        try(Statement statement = connection.createStatement()) {
            String sql = "drop table if exists cities;";
            statement.execute(sql);
            sql = "create table cities(id serial primary key, name text, population int);";
            statement.execute(sql);
        } catch (Exception ex) {

        }
    }
    public void insert(City city) {
        try(PreparedStatement statement =
                    connection.prepareStatement("insert into cities(name, population) values(?, ?)")) {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getPopulation());
            statement.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public boolean update (City city) {
        boolean result = false;
        try (PreparedStatement statement =
                connection.prepareStatement("update cities set name = ?, population = ? where id = ?")) {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getPopulation());
            statement.setInt(3, city.getId());
            result = statement.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    public boolean delete (City city) {
        boolean result = false;
        try (PreparedStatement statement =
                     connection.prepareStatement("delete from cities where id = ?")) {
            statement.setInt(1, city.getId());
            result = statement.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    public List<City> findAll() {
        List<City> cities = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("select * from cities")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    cities.add(new City(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("population")
                    ));
                }
            }
        } catch (Exception ex) {

        }
        return cities;
    }

    public static void main(String[] args) throws Exception {
        PrepareStatementDemo demo = new PrepareStatementDemo();
        demo.insert(new City(1, "Moscow", 1));
        demo.insert(new City(2, "Kazan", 2));
        demo.insert(new City(3, "Peter", 3));
        demo.update(new City(3, "Ekb", 4));
        demo.delete(new City(2, "Kazan", 2));
        for(City city : demo.findAll()) {
            System.out.println(city);
        }
    }
}
