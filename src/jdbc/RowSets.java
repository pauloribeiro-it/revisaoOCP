package jdbc;

import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class RowSets {
	private static final String URL_CONNECTION = "jdbc:mysql://localhost:3306/revisaoocp";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "root";
	private static final String FIND_ALL = "select * from person";

	public static void main(String[] args) throws Exception {
		try (JdbcRowSet jrs = RowSetProvider.newFactory().createJdbcRowSet()) {
			jrs.setUrl(URL_CONNECTION);
			jrs.setUsername(USER_NAME);
			jrs.setPassword(PASSWORD);
			jrs.setCommand(FIND_ALL);
			jrs.addRowSetListener(new RowSetListenerExample());
			jrs.execute();
			while (jrs.next()) {
				System.out.println("Name: " + jrs.getString("name"));
			}
		}

	}
}

class RowSetListenerExample implements RowSetListener {

	@Override
	public void rowSetChanged(RowSetEvent event) {
		System.out.println("RowSet changed");
	}

	@Override
	public void rowChanged(RowSetEvent event) {
		if (event.getSource() instanceof RowSet) {
			try {
				((RowSet) event.getSource()).execute(); 
			} catch (SQLException se) {
				System.out.println("SQLException during execute");
			}
		}
	}

	@Override
	public void cursorMoved(RowSetEvent event) {
		if (event.getSource() instanceof RowSet) {
			try {
				System.out.println("Cursos moved to "+((RowSet) event.getSource()).getRow()+" row.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}