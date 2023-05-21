-----------------------------------------POlICE AND PRISON SOFTWARE SUITE(P. P. S. S)-----------------------------------------------

Pre-requisite:
Java 
Eclipse(Jave EE) 2022-2023 
SQL Server Management Studio 18
Apache Tomcat 10.1.3

Steps:
1. First, server needs to be set up to host webapp. To host server on Apache Tomcat, go into Eclipse and in the servers tab, click on add server and navigate to the Apache Tomcat. It will ask for installation directory.
2. If we have already installed Apache Tomcat, we need to give the directory of the folder it is installed in, otherwise click on install and click finish.
3. Once server is set up, we must establish a connection to database. To ensure that Eclipse and SQl Server Mangament can communicate, check in SQL Server Configration Manager that TCP/IP ports and Named Pipes are enabled.
4. In Eclipse, click on data source explorer tab(if not visible, find in window->show view). Right click on database connection and click add a new connection.
5. It will ask for databse server, select and after setting up configrations, the connection will be established.
6. Open Police Database.sql file and click execute.
7. Click file tab in eclipse, click import, click general, click exsisting project into workspace and import the code folder from CD/DVD. 
8. Run the program on server.
9. Enjoy...
