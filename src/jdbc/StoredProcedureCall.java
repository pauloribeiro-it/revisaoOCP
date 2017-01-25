package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;


public class StoredProcedureCall {
	public static void main(String[] args) throws Exception {
		Connection con = JDBCConnection.getConnection();
		storedProcedureCall(con);
		JDBCConnection.closeConnection(con);
	}

	public static void storedProcedureCall(Connection con) throws Exception {
		String callSP = "{call obtemPorRangeID(?,?,?)}";
		try(CallableStatement callableStatement = con.prepareCall(callSP)){
			callableStatement.registerOutParameter(1, java.sql.Types.INTEGER);
			callableStatement.setInt(2, 2);
			callableStatement.setInt(3, 4);
			ResultSet rs = callableStatement.executeQuery();
			System.out.println("Total: "+callableStatement.getInt(1));
			while(rs.next()){
				System.out.println("Name: "+rs.getString("name"));
			}
			rs.close();
		}
	}
}
