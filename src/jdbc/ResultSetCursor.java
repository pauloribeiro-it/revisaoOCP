package jdbc;

import static java.lang.System.out;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetCursor {
	public static void main(String[] args) throws Exception {
		Connection con = JDBCConnection.getConnection();
		verifyResultSetCursor(con);
		moveResultSet(con);
		JDBCConnection.closeConnection(con);
	}
	
	public static void verifyResultSetCursor(Connection con) throws Exception{
		DatabaseMetaData dbmd = con.getMetaData();
		if (dbmd.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
			out.print("Supports TYPE_FORWARD_ONLY");
			if (dbmd.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
				out.println(" and supports CONCUR_UPDATABLE");
			}
		}
		if (dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
			out.print("Supports TYPE_SCROLL_INSENSITIVE");
			if (dbmd.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
				out.println(" and supports CONCUR_UPDATABLE");
			}
		}
		if (dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
			out.print("Supports TYPE_SCROLL_SENSITIVE");
			if (dbmd.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
				out.println("Supports CONCUR_UPDATABLE");
			}
		}
	}
	
	public static void moveResultSet(Connection con) throws Exception{
		try(Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from person")){
			rs.absolute(2);
			System.out.println("Second is: "+rs.getString("name"));
			rs.next();
			System.out.println("Third is: "+rs.getString("name"));
			rs.relative(-2);
			System.out.println("First is: "+rs.getString("name"));
			rs.last();
			System.out.println("Last is: "+rs.getString("name"));
		}
	}
}
