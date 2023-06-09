package com.JDBC;

import java.sql.*;

/**
 * 
 * @author HASSEN
 *
 */
public final class JdbcUpdateDemo {

	public JdbcUpdateDemo() {}
    
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
	 * @throws SQLException 
     */
	private static void displayEmployee(Connection myConn, String firstName, String lastName) throws SQLException {
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			/**
			 * Prepare statement
			 */
			myStmt = myConn.prepareStatement("SELECT last_name, first_name, email FROM employees WHERE last_name=? AND first_name=?");

			myStmt.setString(1, lastName);
			myStmt.setString(2, firstName);
			/**
			 * Execute SQL Query
			 */
			myRs = myStmt.executeQuery();
			/**
			 * Process Result set
			 */
			while(myRs.next()) {
				String theLastName = myRs.getString("last_name");
				String theFirstName = myRs.getString("first_name");
				String theEmail = myRs.getString("email");
				
				System.out.printf("%s %s, %s\n", theFirstName, theLastName, theEmail);
			}
		} 
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			close(myStmt, myRs);
		}		
	}

	/**
	 * 
	 * @param myConn
	 * @param myStmt
	 * @param myRs
	 * @throws SQLException
	 */
	private static void close(Connection myConn, Statement myStmt, ResultSet myRs) throws SQLException {
		if (myRs !=null) {
			myRs.close();
		}
		
		if (myStmt !=null) {
			myStmt.close();			
		}
		
		if (myConn !=null) {
			myConn.close();			
		}
	}
	
	/**
	 * 
	 * @param myStmt
	 * @param myRs
	 * @throws SQLException
	 */
	private static void close(PreparedStatement myStmt, ResultSet myRs) throws SQLException {
		close(null, myStmt, myRs);		
	}	
}
