/**
 * 
 */
package module7.assignment;

import java.sql.SQLException;

/**
 * @author Abhishek Bajpai
 *
 */
//CRUD operations DAO = Create, Retrieve, Update, Delete
/**
 * Write programs to create/insert/update/delete/select student table in the db. 
 * Student table will have the following fields:
 * Student ID
 * Name
 * Class
 * Marks
 */

public interface StudentDAO {
	
void create() throws SQLException;
void insert(Student student) throws SQLException;
void update(Student student) throws SQLException;
void delete(int studentID) throws SQLException;
void selectAll() throws SQLException;
void selectByStudentID(int studentID) throws SQLException;
void truncate() throws SQLException ;

}
