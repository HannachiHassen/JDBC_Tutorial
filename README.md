## JDBC_Tutorial

## JDBC Architecture

<h5>JDBC Driver:</h5>

- Provider connection to a database
- Converts JDBC calls to for specific database
 
<h5>JDBC Driver implementations:</h5>
Provider by database vendor

## JDBC Driver Manager

- DriverManager helps to connect an application based on the database connection string
- In JDBC 4.0 the JDBC drivers are automatically loaded based on the classpath
- Legacy JDBC 3.0 Drivers have to be explicitly loaded with Class.forName(theDriverName)

## JDBC API

<h5>JDBC API is defined in the following packages</5>

- java.sql and javax.sql
  
<h5> Key class </h5>

 - java.sql.Connection
 - java.sql.DriverManager
 - java.sql.ResultSet
 - java.sql.DataSource (for connection pooling)
 - java.sql.Statement
 
## Development Process
 
 1. Get a connection to database
 2. Create a Statement
 3. Execute SQL query
 4. Process Result Set
 
## Step 1: Get a connection to a database
- In order to connect to a database need a connection string in form of JDBC URL
- Basic syntax:

```
jdbc:<driver protocol>:<driver connection detail>
```
  
 - Examples:
 
 ```
 . MS SQL Server: jdbc:odbc:DemoDSN
 . Oracle :       jdbc:oracle:thin@myserver:1521:demodb
 . Mysql :        jdbc:mysql://localhost:3306/demodb
 ```

## Step 2: Create a Statement object
 - The statement object is based on connection
 - it will be used later to execute SQL query
 
    import java.sql.*;
    ....
    String dbUrl = "jdbc:mysql://localhost:3306/demo";
    String user = "student";
    String pass = "student";
    
    Connection myConn= DriverManager.getConnection();
    Statement myStmt = myConn.createStatement();
    
## Step 3: Execute SQL Query
- Pass in your SQL query
     
    import java.sql.*;
    ....
    String dbUrl = "jdbc:mysql://localhost:3306/demo";
    String user = "student";
    String pass = "student";
    
    Connection myConn= DriverManager.getConnection();
    Statement myStmt = myConn.createStatement();
    ResultSet myRs = myStmt.executeQuery("SELECT * FROM employees");
    
## Step 4: Process the Result Set
-Result Set is initially placed before first row

-Method:ResultSet.next()
 - moves forward one row
 - returns true if there are more rows to process

-Looping through a result set

```
    ...
    myRs = myStmt.executeQuery("SELECT * FROM employees");
	 while (myRs.next()) {
		// read data from each row
	 }
```

-Collection of methods for reading data
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
  