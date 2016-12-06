package trycatchwithresources;

import java.io.IOException;
import java.sql.SQLException;

public class TryCatch {
	public static void main(String[] args) {
		try {
			new TryCatch().rethrow();
		} catch(SQLException |IOException e){
			
		}catch(Exception e){
			
		}
	}

	public void couldThrowAnException() throws IOException, SQLException {
	
	}

	public void rethrow() throws SQLException, IOException {
		try {
			couldThrowAnException();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
}
