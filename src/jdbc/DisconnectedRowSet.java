package jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class DisconnectedRowSet {
	private static final String FIND_ALL = "select * from person";

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		try(Connection con = JDBCConnection.getConnection();
				CachedRowSet rowSet=RowSetProvider.newFactory().createCachedRowSet()){
			con.setAutoCommit(false);
			rowSet.setCommand(FIND_ALL);
			rowSet.execute(con);
			while(rowSet.next()){
				if(rowSet.getRow()%2==0){
					rowSet.updateString("name", rowSet.getString("name")+" is even");
					rowSet.updateRow();
				}
			}
			rowSet.acceptChanges();	
		}
	}
}
