import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("org.postgresql.Driver");
        String url, login, password;
        try(BufferedReader in = new BufferedReader(
                new FileReader("chapter_003 - Блок 3. Базы данных/jdbc/app.properties"))) {
            url = in.readLine().split("=")[1].trim();
            login = in.readLine().split("=")[1].trim();
            password = in.readLine().split("=")[1].trim();
        }
        try(Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}
