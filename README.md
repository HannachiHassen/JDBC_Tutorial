# JDBC_Tutorial

# JDBC Architecture

<h5>JDBC Driver:</h5>

- Provider connection to a database
- Converts JDBC calls to for specific database
 
<h5>JDBC Driver implementations:</h5>
Provider by database vendor

# JDBC Driver Manager

- DriverManager helps to connect an application based on the database connection string
- In JDBC 4.0 the JDBC drivers are automatically loaded based on the classpath
- Legacy JDBC 3.0 Drivers have to be explicitly loaded with Class.forName(theDriverName)

# JDBC API
<h5>JDBC API is defined in the following packages</5>

- java.sql and javax.sql
  
<h5> Key class </h5>

 - java.sql.Connection
 - java.sql.DriverManager
 - java.sql.ResultSet
 - java.sql.DataSource (for connection pooling)
 - java.sql.Statement
 
# Development Process
 
 1. Get a connection to database
 2. Create a Statement
 3. Execute SQL query
 4. Process Result Set
 
# Step 1: Get a connection to a database
- In order to connect to a database need a connection string in form of JDBC URL
- Basic syntax:
  
    . jdbc:<driver protocol>:<driver connection detail>
  
 - Examples:
    
    . MS SQL Server: jdbc:odbc:DemoDSN
    . Oracle : jdbc:oracle:thin@myserver:1521:demodb
    . Mysql : jdbc:mysql://localhost:3306/demodb

