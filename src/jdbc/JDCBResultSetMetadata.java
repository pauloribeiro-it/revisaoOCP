package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


public class JDCBResultSetMetadata {
	private static final String SELECT_PERSON = "SELECT * FROM person";
	
	public static void main(String[] args) throws Exception{
		Connection con = JDBCConnection.getConnection();
		PreparedStatement st = con.prepareStatement(SELECT_PERSON);
		ResultSet rs = st.executeQuery();
		ResultSetMetaData resultSetMetadata = rs.getMetaData();
		System.out.println("Column count: "+resultSetMetadata.getColumnCount());
		System.out.println("Table name: "+resultSetMetadata.getTableName(1));
		System.out.println("First column size: "+resultSetMetadata.getColumnDisplaySize(1));
		System.out.println("Second column size: "+resultSetMetadata.getColumnDisplaySize(2));
		JDBCConnection.closeStatement(st, rs);
		JDBCConnection.closeConnection(con);	
	}
	
}
