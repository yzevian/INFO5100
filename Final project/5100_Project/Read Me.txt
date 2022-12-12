1. This is a car rent application. It is created by Java + Mysql.
The jre version is "17.0.5”, and the Mysql version is 8.0.23.

2. You can use the following information to log in：
User Name : User1
Password : 1234678

3.To open the database locally: Open the workbench, first create a new database, 
then click Import file. Import the sql file(named untitled.sql) and refresh the database, then you can see all tables.

4.In connectionDatabase package, the conData class should modify some content:
  private static String dbUrl="jdbc:mysql://localhost:3306/CarRental?useSSL=false&serverTimezone=UTC"; // Database connect address
	private static String dbUserName="root"; // UserName
	private static String dbPassword="00000000"; // password
	private static String jdbcName="com.mysql.cj.jdbc.Driver"; // Driver Name
  
  These information in "" should be modify according to your laptop database information.

5.If you have any difficulities to check it, please contact me. Thank you.
My Email: zhao.yi9@northeastern.edu
