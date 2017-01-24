package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ResultSetTests {
	
	private static final String UPDATE_PAULO = "update person set name=? where name=?";
	private static final String SELECT_PERSON = "SELECT * FROM person";
	
	public static void main(String[] args) throws Exception{
		Connection con = JDBCConnection.getConnection();
		updatePauloName(con);
		showRows(con);
		JDBCConnection.closeConnection(con);
	}
	
	private static void updatePauloName(Connection con)throws Exception{
		PreparedStatement st = con.prepareStatement(UPDATE_PAULO);
		st.setString(1, "Paulo Ribeiro");
		st.setString(2, "paulo");
		if(!st.execute()){
			System.out.println(st.getUpdateCount()+" rows updated.");
		}
		con.commit();
		JDBCConnection.closeStatement(st);
	}
	
	private static void showRows(Connection con) throws Exception{
		PreparedStatement st = con.prepareStatement(SELECT_PERSON);
		ResultSet rs = null;
		if(st.execute()){
			rs = st.getResultSet();
			while(rs.next()){
				Person p = new Person(rs.getString("name"),rs.getInt("age"));
				System.out.println("Name: "+p.getName()+"\tAge:"+p.getAge()+" years old.");
			}
		}
		JDBCConnection.closeStatement(st, rs);
	}
}
