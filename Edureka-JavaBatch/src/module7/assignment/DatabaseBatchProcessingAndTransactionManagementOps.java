package module7.assignment;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author Abhishek Bajpai 
 * May 16 2021 
 * Write a program to perform Batch processing and 
 * Transaction management for Student table created in
 * Problem 1 i.e. DatabaseNormalOps.
 * 
 */
public class DatabaseBatchProcessingAndTransactionManagementOps {

	public static void main(String[] args) {

		StudentDAOImpl studentDAOImpl = new StudentDAOImpl();
		Statement statement = studentDAOImpl.getStatement();
		try {
			// studentDAOImpl.truncate();
			// batch processing ..should fail if SQL exception occurs
			//autoCommit if set to true will run updates but fail on inserts because id column is set to primary key
			studentDAOImpl.getConnection().setAutoCommit(false); 
			System.out.println("Default fetch size => " + studentDAOImpl.getConnection().createStatement().getFetchSize());

			statement.addBatch("update student set name='Julia' where id=1");
			statement.addBatch("update student set name='Silvia' where id=2");
			statement.addBatch("update student set name='Jennifer' where id=3");
			statement.addBatch("update student set name='Emma' where id=4");
			statement.addBatch("update student set name='Sophia' where id=5");
			statement.addBatch("insert into student values (6, 'Ava', 'Philosophy', 79.89f)");
			statement.addBatch("insert into student values (7, 'Charlotte', 'Psychology', 89.89f)");
			statement.addBatch("insert into student values (8, 'Olivia', 'Virology', 69.9f)");
			statement.addBatch("insert into student values (9, 'Avayah', 'Germology', 85.9f)");
			statement.addBatch("insert into student values (10, 'Gabriella', 'Philosophy', 90.5f)");

			statement.executeBatch();
			System.out.println("Batch executed !!");
			studentDAOImpl.getConnection().commit();
		} catch (SQLException e) {
			try {
				studentDAOImpl.getConnection().rollback();
				System.out.println("Batch processing ABORTED because of an exception");
				System.out.println(e.getErrorCode() + " : " + e.getMessage());
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
		} finally {
			try {
				studentDAOImpl.getConnection().close();
				System.out.println("DB Connection is CLOSED now !!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
