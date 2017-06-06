package src;

import java.sql.Connection;
import java.sql.Statement;

import javax.activation.DataHandler;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class ConnectionToDB {

	// Connect to database
	private static String hostName = "????.database.windows.net";
	private static String dbName = "";
	private static String user = "";
	private static String password = "";
	private static String url = String.format(
			"jdbc:sqlserver://????.database.windows.net:1433;database=<DBNAME>;user=<user-name>@<server-name>;password={.....};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;",
			hostName, dbName, user, password);
	private static String selectSql= "select course.title, prereq.prereq_id, prereq.course_id from prereq join course on prereq.course_id =  course.course_id;";


	private static Connection connection = null;

	public static void main(String[] args) {
	// testing purpose
		getCourses();
	
		
		
		
	}
	
	
	
	
	
	
	
	
	public static void getCourses() {
		// TODO Auto-generated constructor stub

		try {
			connection = DriverManager.getConnection(url);
			
			
			
			
			//String schema = connection.getSchema();
			//System.out.println("Successful connection - Schema: " + schema);

			System.out.println("Query data example:");
			System.out.println("=========================================");
		
			// Create and execute a SELECT SQL statement.
			//selectSql = "select course.title, prereq.prereq_id, prereq.course_id from prereq join course on prereq.course_id =  course.course_id;";

			try (Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery(selectSql)) {
			
				ResultSetMetaData metaData = resultSet.getMetaData();
				int numberOfColoumns = metaData.getColumnCount();
				for (int i = 0; i <=numberOfColoumns; i++) {
					System.out.printf("%-8s\t",resultSet.getObject(i));
					System.out.println();
				}
		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}



}
