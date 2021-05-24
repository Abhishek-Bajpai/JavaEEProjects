package module7.assignment;

import java.sql.SQLException;

public class DatabaseNormalOps {

	public static void main(String[] args) {

		StudentDAOImpl studentDAOImpl = new StudentDAOImpl();
		try {
			// create is test verified and can be commented so program can be repeat tested 
			// without running into exception since table is already created 
			//studentDAOImpl.create();
			
			studentDAOImpl.insert(new Student(11, "AbabA", "Aviation Industry", 95.65f));
			studentDAOImpl.insert(new Student(12, "GoabA", "Arts and Home Ministry", 96.9f));
			studentDAOImpl.insert(new Student(13, "AbabAJr", "Research and Development", 99.99f));
			studentDAOImpl.insert(new Student(14, "AmabA", "Health Ministry", 89.9f));
			studentDAOImpl.insert(new Student(15, "EvaBA", "Public Relations", 80.8f));
			
			studentDAOImpl.update(new Student(1, "Abhishek Bajpai", "Aeronautical Sciences", 99.95f));
			
			studentDAOImpl.delete(1);
			
			studentDAOImpl.selectAll();
			System.out.println("Filtered finding .. >>>>");
			studentDAOImpl.selectByStudentID(2);
			
			//truncate has been test verified and commented so data is retained
			//studentDAOImpl.truncate();
			
		} catch (SQLException e) {
			System.out.println("An exception occured !! ");
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
		}finally {
			try {
				studentDAOImpl.getConnection().close();
				System.out.println("DB Connection is CLOSED !!");
			} catch (SQLException e) {
				System.out.println(e.getErrorCode() + " : " + e.getMessage());
			}
		}

		
	}

}
