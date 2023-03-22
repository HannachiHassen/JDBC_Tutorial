package com.JDBC;

import java.sql.*;

public final class JdbcUpdateDemo {

	public JdbcUpdateDemo() {}
    
	/**
     * 
     * @param args
     */
	public static void main(String[] args) {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		String dbUrl = "jdbc:mysql://localhost:3306/demo";
		String user = "student";
		String pass = "student";

		try {
			/**
			 *  Get a connection to database
			 */
			myConn = DriverManager.getConnection(dbUrl, user, pass);

			/**
			 * Create a statement
			 */
			myStmt = myConn.createStatement();

			/**
			 * Call helper method to display the employee's information
			 */
			System.out.println("BEFORE THE UPDATE...");
			displayEmployee(myConn, "John", "Doe");

			/**
			 * UPDATE the employee
			 */
			System.out.println("\nEXECUTING THE UPDATE FOR: John Doe\n");

			int rowsAffected = myStmt.executeUpdate(
					"update employees " +
			        "set email='john.doe@luv2code.com' " +
				    "where last_name='Doe' and first_name='John'");
			/**
			 * Call helper method to display the employee's information
			 */
			System.out.println("AFTER THE UPDATE...");
			displayEmployee(myConn, "John", "Doe");
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			close(myConn, myStmt, myRs);
		}
	}	
    
	/**
     * 
     * @param myConn
     * @param firstName
     * @param lastName
     */
	private static void displayEmployee(Connection myConn, String firstName, String lastName) {
		
	}

	private static void close(Connection myConn, Statement myStmt, ResultSet myRs) {
				
	}

}
