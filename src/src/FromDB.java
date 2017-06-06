package src;

import java.sql.Connection;
import net.proteanit.sql.DbUtils;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FromDB {
	// JDBC driver name and database URL
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://localhost/tutorial";
	protected static final String selectInstructor = "SELECT id,name,dept_name from instructor ;";

	private static String SQLSTATEMENT = "select course.title, prereq.prereq_id, prereq.course_id from prereq "
			+ "join course on prereq.course_id =  course.course_id;";

	public void connection2(String sqlStatement, JTable table) {
		try {

			Class.forName(JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(DATABASE_URL, "root", "xxxx");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlStatement);
			table.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());

		}

	}

	public void deleteRecord(String sqlStatement) {

		try {

			Class.forName(JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(DATABASE_URL, "root", "xxxx");
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sqlStatement);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}

	}

	public String insertStudent(int ID, String name, String dept_name, int tot_cred) {

		final String insertStudent = "INSERT INTO student VALUES (" + ID + ",'" + name + "','" + dept_name + "',"
				+ tot_cred + ")";

		return insertStudent;
	}

	public String insertInstructor(int ID, String name, String dept_name, int salary) {

		final String insertInstructor = "INSERT INTO student VALUES (" + ID + ", '" + name + "',  '" + dept_name + "', "
				+ salary + ")";
		return insertInstructor;
	}

	public String delete(int ID, String tableName) {
		final String delete = "DELETE FROM " + tableName + " WHERE ID=" + "'" + ID + "'";
		return delete;
	}

	public String selectAll(String tableName) {
		final String selectAll = "SELECT * FROM " + tableName + " ORDER BY name";
		return selectAll;
	}

	public String selectSpecificStudent(int id) {
		String selectS = "SELECT * FROM  student WHERE ID=" + "'" + id + "'";
		return selectS;
	}

	public String selectStudentsAccordingtoDeptName(String deptName) {
		final String selectCompScienceStudent = "SELECT * FROM STUDENT WHERE dept_name=" +
	"'" + deptName + "'";
		return selectCompScienceStudent;
	}

	public String selectHighestSalary() {
		final String selectHighestSalary = "SELECT ID, name from instructor where"
				+ " salary= (select max(salary) from instructor)";
		return selectHighestSalary;
	}

	public String selectStudentsWithNames(String name) {
		String selectS = "SELECT * FROM  student WHERE name= " + "'" + name + "'";
		return selectS;
	}

	public String selectStudentsAccordingToTotalCredit(int totalCredit) {
		return "SELECT * FROM STUDENT WHERE tot_cred = " + "'" + totalCredit + "'";
	}

	public String cStatement(int year, String semester) {
		String cStmnt = "Select id,name, dept_name,course.title as CourseTitle,course.course_id, tot_cred,grade,semester,year from "
				+ "(SELECT distinct student.ID, student.name,course_id,tot_cred,grade," + "semester,year"
				+ " FROM student join takes on takes.id= student.id) as m "
				+ " join course on m.course_id = course.course_id where m.year=" + "'" + year + "'"
				+ " and m.semester = " + "'" + semester + "'";
		return cStmnt;
	}
	public String cStatementForAStudent(int id,int year, String semester) {
		String cStmnt = "Select id,name, dept_name,course.title as CourseTitle,course.course_id, tot_cred,grade,semester,year from "
				+ "(SELECT distinct student.ID, student.name,course_id,tot_cred,grade," + "semester,year"
				+ " FROM student join takes on takes.id= student.id) as m "
				+ " join course on m.course_id = course.course_id where m.year=" + "'" + year + "'"
				+ " and m.semester = " + "'" + semester + "'" + " and "+"m.id="+id;
		return cStmnt;
	}

	public void updateRecord(String sql) {

		try {
			Connection conn = DriverManager.getConnection(DATABASE_URL, "root", "xxxx");
			Statement stmt = conn.createStatement();
			int updateCount = stmt.executeUpdate(sql);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "There is no record as you specified");
		}

	}

	public void insertRecord(String sql) {
		try {
			Connection conn = DriverManager.getConnection(DATABASE_URL, "root", "xxxx");
			Statement stmt = conn.createStatement();

			// Execute the insert statement
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Inserting  Faulire happened ! ");
		}

	}

	public String selectInstructorAccordingToSalary(String salary) {
		final String selectHighestSalary = "SELECT ID, name from instructor where salary= " + "'" + salary + "'";
		return selectHighestSalary;
	}

	public String updateDepartment(int ID, String newDeptName) {
		final String updateDepartment = "UPDATE student set dept_name = '" + newDeptName + "' where ID=" + ID;
		return updateDepartment;
	}
	
	public String selectWithSections(int year, String semester, String section){
		
		String m = "Select id,name, dept_name,course.title as CourseTitle,course.course_id, tot_cred,grade,semester,sec_id,"+
				"year from (SELECT distinct student.ID, student.name,course_id,tot_cred,grade,semester,year,sec_id"+
						" FROM student join takes on takes.id= student.id) as m  join course on m.course_id = course.course_id "
						+ "WHERE year="+ year +" AND "+"semester = "+"'"+semester+"'"+" AND "+" sec_id ="+"'"+section+"'";
		return m;
		
	}
	public String selectInstructorWithID(int id){
		String selectStatement = "SELECT id,name,dept_name from instructor where id = "+id;
		return selectStatement;
	}
	
}
