package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class JDBCDBMetadata {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection con = JDBCConnection.getConnection();
		DatabaseMetaData dbMetadata = con.getMetaData();
				System.out.println("DB Product Name: " + dbMetadata.getDatabaseProductName());
		System.out.println("Driver version: " + dbMetadata.getDriverVersion());
		System.out.println("JDCB version: " + dbMetadata.getJDBCMajorVersion());
		JDBCConnection.closeConnection(con);
	}
}
