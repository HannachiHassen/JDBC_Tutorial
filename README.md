## JAVA Database Connection and MySQL Tutorial

## 1. JDBC Architecture

* JDBC Driver:
    - Provider connection to a database
    - Converts JDBC calls to for specific database
 
* JDBC Driver implementations:</h5>
    - Provider by database vendor

## 2. JDBC Driver Manager

- DriverManager helps to connect an application based on the database connection string
- In JDBC 4.0 the JDBC drivers are automatically loaded based on the classpath
- Legacy JDBC 3.0 Drivers have to be explicitly loaded with Class.forName(theDriverName)

## 3. JDBC API

* JDBC API is defined in the following packages</5>
    - java.sql and javax.sql
  
* Key class:
    - java.sql.DriverManager
    - java.sql.Connection
    - java.sql.Statement
    - java.sql.ResultSet
    - java.sql.DataSource (for connection pooling)

## 4. Development Process
 
 1. Get a connection to database
 2. Create a Statement
 3. Execute SQL query
 4. Process Result Set
 
##### Step 1: Get a connection to a database
* In order to connect to a database need a connection string in form of JDBC URL
* Basic syntax:

```
jdbc:<driver protocol>:<driver connection detail>
```
  
* Examples:
 
 ```
 . MS SQL Server: jdbc:odbc:DemoDSN
 . Oracle :       jdbc:oracle:thin@myserver:1521:demodb
 . Mysql :        jdbc:mysql://localhost:3306/demodb
 ```

##### Step 2: Create a Statement object
* The statement object is based on connection
* it will be used later to execute SQL query

```
    import java.sql.*;
    ....
    String dbUrl = "jdbc:mysql://localhost:3306/demo";
    String user = "student";
    String pass = "student";
    
    Connection myConn= DriverManager.getConnection();
    Statement myStmt = myConn.createStatement();
```
    
##### Step 3: Execute SQL Query
* Pass in your SQL query

```    
    import java.sql.*;
    ....
    String dbUrl = "jdbc:mysql://localhost:3306/demo";
    String user = "student";
    String pass = "student";
    
    Connection myConn= DriverManager.getConnection();
    Statement myStmt = myConn.createStatement();
    ResultSet myRs = myStmt.executeQuery("SELECT * FROM employees");
```
 
##### Step 4: Process the Result Set
* Result Set is initially placed before first row
* Method: ResultSet.next()
    - moves forward one row
    - returns true if there are more rows to process

* Looping through a result set

```
    ...
    myRs = myStmt.executeQuery("SELECT * FROM employees");
	 while (myRs.next()) {
		// read data from each row
	 }
```

* Collection of methods for reading data
    - getXXX(columnName)
    - getXX(columnIndex) one-based
 
```
   ...
    myRs = myStmt.executeQuery("SELECT * FROM employees");
	 while (myRs.next()) {
		System.out.println(myRs.getString("last_name"));
		System.out.println(myRs.getString("first_name"));
	 }
```
## 5. Prepared Statements

* A Prepared Statement is a precompiled SQL statement
* Prepared Statements provide the following benifits: 
    - Makes it easier to set SQL parameters values
    - Prevent against SQL dependency injection attacks
    - May improve application performance 
       * SQL Statement is precompiled
     
## 6. Stored Procedures
* A group of SQL statements that perform a particular task
* Normally created by the DBA (Database Administrator)
* Created in a SQL language supported by the native database
* Can have any combination of input, output, and input/output parameters
    - Parameters:
      - The JDBC API supports different parameters
         - IN
         - INOUT
         - OUT
* The stored procedure can also return result sets

## 7. Transactions
* A transaction is a unit of work
* One or more SQL statements executed together
    - Either all of the statements are executed - Commit
    - Or one of the statements are executed - Rollback
* By default, the database connection is to auto-commit
     - Need to explicitly turn off auto-commit
     
     myConn.setAutoCommit(false);    
* Developer controls commit or rollback

    myConn.commit();
    // or 
    myConn.rollback(); 
     
## Built With

* [Java](https://www.oracle.com/java/) - Java JDK
* [Eclipse](https://www.eclipse.org/) - Eclipse IDE
* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

For the versions available, see the [tags on this repository](https://github.com/HannachiHassen/project/tags). 

## Authors

* **Hassen Hannachi** - *Initial work* - [HassenHannachi](https://github.com/HannachiHassen)

## License

This project is not under any License - Open source 
  