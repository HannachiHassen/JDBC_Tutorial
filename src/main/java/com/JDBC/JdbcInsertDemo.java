package com.JDBC;

import java.sql.*;
/**
 * 
 * @author HASSEN
 *
 */
public final class JdbcInsertDemo {

	/**
	 * Constructor
	 */
	public JdbcInsertDemo() {}

	/**
	 * 
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		String dbUrl = "jdbc:mysql://localhost:3306/demo";
		String user = "student";
		String pass = "student";

		try {
			/**
			 * 1. Get a connection to database
			 */
			myConn = DriverManager.getConnection(dbUrl, user, pass);
			System.out.println("Database connection successful!\n");

			/**
			 * 2. Create a statement
			 */
			myStmt = myConn.createStatement();

			/**
			 * 3. Execute SQL query
			 */
			System.out.println("Inserting a new employee to database\n");
			
			int rowsAffected = myStmt.executeUpdate(
			"insert into employees " + 
			"(last_name, first_name, email, department, salary) " + 
			"values " + 
			"('Wright', 'Eric', 'eric.wright@foo.com', 'HR', 33000.00)");
			
			myRs=myStmt.executeQuery("SELECT * FROM employees ORDER BY last_name");

			/**
			 * 4. Process the result set
			 */
			while (myRs.next()) {
				System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name"));
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (myRs != null) {
				myRs.close();
			}

			if (myStmt != null) {
				myStmt.close();
			}

			if (myConn != null) {
				myConn.close();
			}
		}
	}
}
