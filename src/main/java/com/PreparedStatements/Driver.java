package com.PreparedStatements;

import java.sql.*;
/**
 * 
 * @author HASSEN
 *
 */
public final class Driver {

	/**
	 * Constructor
	 */
	private Driver() {}

	/**
	 * 
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		/**
		 * 1. Get a connection to database
		 * 2. Prepare statement
		 * 3. Set the parameters
		 * 4. Execute SQL query
		 * 5. Display the result set
		 *  
		 * 6. Set the parameters
		 * 7. Execute SQL query
		 * 8. Display the result set
		 */
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student", "student");

			myStmt = myConn.prepareStatement("select * from employees where salary > ? and department=?");

			myStmt.setDouble(1, 80000);
			myStmt.setString(2, "Legal");

			myRs = myStmt.executeQuery();

			display(myRs);

			/**
			 * Reuse the prepared statement: salary > 25000, department = HR
			 */
			System.out.println("\n\nReuse the prepared statement:  salary > 25000,  department = HR");

			myStmt.setDouble(1, 25000);
			myStmt.setString(2, "HR");

			myRs = myStmt.executeQuery();

			display(myRs);

		} 
		catch (Exception exc) {
			exc.printStackTrace();
		} 
		finally {
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

	/**
	 * 
	 * @param myRs
	 * @throws SQLException 
	 */
	private static void display(ResultSet myRs) throws SQLException {
		while (myRs.next()) {
			String lastName = myRs.getString("last_name");
			String firstName = myRs.getString("first_name");
			double salary = myRs.getDouble("salary");
			String department = myRs.getString("department");
			
			System.out.printf("%s, %s, %.2f, %s\n", lastName, firstName, salary, department);
		}
	}
}
