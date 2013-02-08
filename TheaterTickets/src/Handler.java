import java.sql.*;

public class Handler {
	
	
		 public static Connection connect()
		 {
			 Connection connection = null;
			    try {
			        // Load the JDBC driver
			        String driverName = "com.mysql.jdbc.Driver"; // MySQL MM JDBC driver
			        Class.forName(driverName);
			    
			        // Create a connection to the database

			        String url = "jdbc:mysql://127.0.0.1:3306/TheaterDB";
			        String username = "root";
			        String password = "root";
			        connection = DriverManager.getConnection(url, username, password);
			    } catch (ClassNotFoundException e) {
			        // Could not find the database driver
			    } catch (SQLException e) {
			        // Could not connect to the database
			    }
			    return connection;
		 }
		 
		 public static ResultSet executeQuery(String query, Connection connection)
		 {
			 if (connect()!=null)
			 {
				 try {
					Statement statement = connection.createStatement();
					statement.execute(query);
					return statement.getResultSet();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
			 
			 return null;
		 }
		 
		 public static void disconnect(Connection connection)
		 {
			 if (connection !=null)
			 {
				 try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
		 }

}
