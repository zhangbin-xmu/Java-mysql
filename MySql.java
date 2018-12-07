import java.sql.*;

public class MySql {

    private static final String JDBC_DRIVER_NEW = "com.mysql.cj.jdbc.Driver";
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mysql?serverTimezone=UTC";

    private static final String USER = "root";
    private static final String PASSWORD = "MYSQLlx&gw7!";

    public static void main(String[] args) {
        System.out.print("Hello, MySql!\n");

        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            statement = connection.createStatement();
            String sql = "SELECT user, host FROM user";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String user = resultSet.getString("user");
                String host = resultSet.getString("host");

                System.out.print("user: " + user + " host: " + host);
                System.out.print("\n");
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
