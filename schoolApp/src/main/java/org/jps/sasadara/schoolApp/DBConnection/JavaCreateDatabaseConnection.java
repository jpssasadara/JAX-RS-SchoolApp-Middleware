package org.jps.sasadara.schoolApp.DBConnection;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class JavaCreateDatabaseConnection {
	    private static final String USERNAME = "root";
	    private static final String PASSWORD = "";
	    private static final String CONN = "jdbc:mysql://localhost:3306/mystuappmw";
	    
	    public static Connection getconnection()throws SQLException{
	    	try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return DriverManager.getConnection(CONN,USERNAME,PASSWORD);
	    }


	}

