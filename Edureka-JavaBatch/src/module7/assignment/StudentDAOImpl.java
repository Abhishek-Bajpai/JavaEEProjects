package module7.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Abhishek Bajpai 16 May 2021
 *
 *         Write programs to create/insert/update/delete/select student table in
 *         the db. Student table will have the following fields: Student ID Name
 *         Class Marks
 */

public class StudentDAOImpl implements StudentDAO {
	private final String connectionURL = "jdbc:oracle:thin:@localhost:1521:XE";
	private final String dbUser = "edureka";
	private final String dbUserPwdString = "Dost!234";
	private String createSQL = "create table student(id number, name varchar2(30), class varchar2(30), marks number(5,3))";
	private String inputString = null;

	private Connection connection;
	private Statement statement;

	public Statement getStatement() {
		return statement;
	}

	public StudentDAOImpl() {
		try {
			connection = DriverManager.getConnection(connectionURL, dbUser, dbUserPwdString);
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Adding getConnection so it can be closed by the calling program once DB
	// processing is done
	public Connection getConnection() {
		return connection;
	}

	@Override
	public void create() throws SQLException {
		statement.execute(createSQL);
		System.out.println("Student table created !! ");
	}

	@Override
	public void insert(Student student) throws SQLException {
		inputString = "insert into student values(" + student.getId() + ",'" + student.getName() + "','"
				+ student.getClassStr() + "'," + student.getMarks() + ")";
		System.out.println("\t" + inputString);
		statement.executeUpdate(inputString);
		System.out.println("Record Inserted for " + student + "...!!! ");
	}

	@Override
	// update student set name='Abhishek Bajpai','Aviation and Aeronautical
	// Sciences',99.95 where id=1)

	public void update(Student student) throws SQLException {
		inputString = "update student set name='" + student.getName() + "', class='" + student.getClassStr()
				+ "', marks=" + student.getMarks() + " where id=" + student.getId();
		System.out.println("\t" + inputString);
		statement.executeUpdate(inputString);
		System.out.println("\n\nStudent record UPDATED for " + student + "..!! \n\n");
	}

	@Override
	public void delete(int studentID) throws SQLException {
		inputString = "delete from student where id = " + studentID;
		System.out.println(inputString);
		statement.execute(inputString);
		System.out.println("\n\nStudent record DELETED ..!! ");

	}

	@Override
	public void selectAll() throws SQLException {
		inputString = "select * from student";
		ResultSet resultSet = statement.executeQuery(inputString);
		System.out.println("\n\n");
		while (resultSet.next()) {
			int studentID = resultSet.getInt(1);
			String studentName = resultSet.getString(2);
			String studentClass = resultSet.getString(3);
			float studentMarks = resultSet.getFloat(4);
			System.out.println("StudentID : " + studentID + "\n\tStudent Name : " + studentName + "\n\tClass : "
					+ studentClass + "\n\tMarks : " + studentMarks);
			System.out.println("----------------------------------------------------------------------------------");
		}
	}

	@Override
	public void selectByStudentID(int studentID) throws SQLException {
		inputString = "select * from student where id=" + studentID;
		ResultSet resultSet = statement.executeQuery(inputString);
		System.out.println("\n\n");
		if (resultSet.next()) {
			String studentName = resultSet.getString(2);
			String studentClass = resultSet.getString(3);
			float studentMarks = resultSet.getFloat(4);
			System.out.println("StudentID : " + studentID + "\n\tStudent Name : " + studentName + "\n\tClass : "
					+ studentClass + "\n\tMarks : " + studentMarks);
			System.out.println("----------------------------------------------------------------------------------");
		}

	}

	@Override
	public void truncate() throws SQLException {
		statement.execute("truncate table student");
	}

}
