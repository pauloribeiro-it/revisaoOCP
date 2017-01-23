package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCMetadata {
	private static final String URL_CONNECTION = "jdbc:mysql://localhost:3306/revisaoocp";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "root";
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL_CONNECTION,USER_NAME,PASSWORD);
		
	}
}
