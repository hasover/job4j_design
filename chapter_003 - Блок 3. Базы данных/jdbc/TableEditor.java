import java.io.FileReader;
import java.sql.*;
import java.util.Properties;

public class TableEditor implements AutoCloseable {
    private Connection connection;
    private Properties properties;

    public TableEditor(Properties properties) throws Exception {
        this.properties = properties;
        this.properties.load(new FileReader("chapter_003 - Блок 3. Базы данных/jdbc/app.properties"));
        initConnection();
    }

    private void initConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        connection =  DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("login"),
                properties.getProperty("password"));
    }

    public void createTable(String tableName) throws SQLException {
        Statement statement = connection.createStatement();
            String sql = String.format("create table if not exists %s();", tableName);
            statement.execute(sql);
    }

    public void dropTable(String table) throws SQLException {
        Statement statement = connection.createStatement();
            String sql = String.format("drop table if exists %s;", table);
            statement.execute(sql);

    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        Statement statement = connection.createStatement();
            String sql = String.format("alter table %s add %s %s;",
                    tableName,
                    columnName,
                    type);
        statement.execute(sql);

    }

    public void dropColumn(String tableName, String columnName) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = String.format("alter table if exists %s drop column %s;",
                tableName,
                columnName);
        statement.execute(sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = String.format("alter table if exists %s rename column %s to %s;",
                tableName,
                columnName,
                newColumnName);
        statement.execute(sql);
    }

    public String getScheme(String tableName) throws SQLException {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while(columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }

    @Override
    public void close() throws Exception {
            connection.close();
    }

    public static void main(String[] args) throws Exception {
        TableEditor editor = new TableEditor(new Properties());
        editor.dropTable("table_1");
        editor.createTable("table_1");
        editor.addColumn("table_1", "id", "int");
        editor.addColumn("table_1", "name", "varchar(255)");
        System.out.println(editor.getScheme("table_1"));
        editor.dropColumn("table_1", "name");
        editor.renameColumn("table_1", "id", "id_new");
        System.out.println(editor.getScheme("table_1"));

        /*
        TableEditor editor = new TableEditor(new Properties());
        editor.dropTable("Table_1");
        editor.createTable("Table_1");
        editor.addColumn("Table_1", "id", "int");
        editor.addColumn("Table_1", "name", "varchar(255)");
        System.out.println(editor.getScheme("Table_1"));
         */
    }
}
