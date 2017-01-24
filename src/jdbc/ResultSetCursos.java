package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import static java.lang.System.out;

public class ResultSetCursos {
	public static void main(String[] args) throws Exception {
		Connection con = JDBCConnection.getConnection();
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
		JDBCConnection.closeConnection(con);
	}
}
