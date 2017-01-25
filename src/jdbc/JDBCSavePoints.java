package jdbc;

import java.sql.Connection;
import java.sql.Savepoint;
import java.sql.Statement;

public class JDBCSavePoints {
	public static void main(String[] args) throws Exception{
		final String insert1 = "insert into person (name,age) values('Person1',30)";
		final String insert2 = "insert into person (name,age) values('Person2',40)";
		
		try(Connection con = JDBCConnection.getConnection();Statement st = con.createStatement()){
			st.executeUpdate(insert1);
			Savepoint svp1 = con.setSavepoint();
			st.executeUpdate(insert2);
			con.rollback(svp1);
			con.commit();
		}
	}
}
