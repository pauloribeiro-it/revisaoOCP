package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDCBConnection {
	private static final String URL_CONNECTION = "jdbc:mysql://localhost:3306/revisaoocp";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "root";

	private JDCBConnection() {

	}

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver"); // Just in the cause of the
												// driver is below JDBC 4
		Connection con = DriverManager.getConnection(URL_CONNECTION, USER_NAME, PASSWORD);
		return con;
	}

	public static void closeConnection(Connection con) throws SQLException {
		if (con != null)
			con.close();
	}
}
