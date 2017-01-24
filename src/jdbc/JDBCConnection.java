package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection {
	private static final String URL_CONNECTION = "jdbc:mysql://localhost:3306/revisaoocp";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "root";

	private JDBCConnection() {

	}

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver"); // Just in the cause of the
												// driver is below JDBC 4
		Connection con = DriverManager.getConnection(URL_CONNECTION, USER_NAME, PASSWORD);
		con.setAutoCommit(false);
		return con;
	}

	public static void closeStatement(Statement st) throws SQLException {
		if (st != null)
			st.close();
	}

	public static void closeStatement(Statement st, ResultSet rs) throws SQLException {
		if (rs != null)
			rs.close();
		closeStatement(st);
	}

	public static void closeConnection(Connection con) throws SQLException {
		if (con != null)
			con.close();
	}
}
