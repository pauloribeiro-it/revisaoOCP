package jdbc;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class RowSets {
	private static final String URL_CONNECTION = "jdbc:mysql://localhost:3306/revisaoocp";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "root";
	private static final String FIND_ALL = "select * from person";
	public static void main(String[] args) throws Exception{
		try(JdbcRowSet jrs = RowSetProvider.newFactory().createJdbcRowSet()){
			jrs.setUrl(URL_CONNECTION);
			jrs.setUsername(USER_NAME);
			jrs.setPassword(PASSWORD);
			jrs.setCommand(FIND_ALL);
			jrs.execute();
			while(jrs.next()){
				System.out.println("Name: "+jrs.getString("name"));
			}
		}
		
	}
}
