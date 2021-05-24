/**
 * 
 */
package module7.assignment;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Abhishek Bajpai
 *
 */
public class DatabaseStoredProcsAndFunctionsOps {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {

		/**
		 * Please first run this on the backend to create stored procedure- "insertIntoEmp"
		   
			CREATE OR REPLACE PROCEDURE EDUREKA.insertIntoEmp(IN name varchar2(10), IN sal int)
			BEGIN
				INSERT INTO emp values(name, sal);
			end
		 */
		
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "edureka", "Dost!234");
 		
		//CallableStatement to call database stored procedure
		String sql = "{call INSERTINTOEMP(?,?)}"; 
		CallableStatement callableStatement = connection.prepareCall(sql);
		DatabaseMetaData metadata = connection.getMetaData();
	    ResultSet result = metadata.getProcedures(null, "", "%");
	    while (result.next()) {
	      System.out.println("Database Metadata Info :: \n\tProcedure Category :" + result.getString("PROCEDURE_CAT") + "\n\tProcedure Scheme : "
	          + result.getString("PROCEDURE_SCHEM") + "\n\tProcedure Name : " + result.getString("PROCEDURE_NAME"));
	    }

		Scanner scanner= new Scanner(System.in);
		
 		System.out.println("Enter employee name : ");
		String name = scanner.next();
		System.out.println("Enter this employees salary : ");
		int sal = scanner.nextInt();
		callableStatement.setString(1, name);
		callableStatement.setInt(2, sal);
		
		callableStatement.execute();
 		scanner.close();
		connection.close();
		

	}

}
