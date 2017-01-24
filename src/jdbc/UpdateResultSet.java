package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateResultSet {
	public static void main(String[] args) throws Exception {
		Connection con = JDBCConnection.getConnection();
//		updateResultSet(con);
		deleteLastRow(con);
		JDBCConnection.closeConnection(con);
	}

	public static void updateResultSet(Connection con) throws Exception {
		try (Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = st.executeQuery("select * from person")) {
			while (rs.next()) {
				String name = rs.getString("name");
				if (name.startsWith("i")) {
					rs.updateString("name", "I" + name.substring(1, name.length()));
					rs.updateRow();
					System.out.println(name + " updated.");
				}
			}
			con.commit();
		}
	}

	public static void deleteLastRow(Connection con) throws Exception {
		try (Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = st.executeQuery("select * from person")) {
			if (rs.last()) {
				rs.deleteRow();
				System.out.println("Last row deleted");
			}
			con.commit();
		}
	}
}
