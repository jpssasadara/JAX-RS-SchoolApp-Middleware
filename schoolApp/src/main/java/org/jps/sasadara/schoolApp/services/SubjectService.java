package org.jps.sasadara.schoolApp.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.*;
import org.jps.sasadara.schoolApp.DBConnection.JavaCreateDatabaseConnection;
import org.jps.sasadara.schoolApp.models.Subject;

public class SubjectService {
	private static String SQLEnrollSub = "INSERT INTO subject(Sub_id,Sub_name,Credit_value,Duration)"+"VALUES(?,?,?,?)";
	private static String SQLSelectsub= "SELECT * FROM subject";
	private static String SQLUpdatesub= "UPDATE Subject SET Sub_id = ?, Sub_name= ?, Credit_value= ? , Duration= ? WHERE Sub_id= ?";
	private static String SQLSelectsub2 = "SELECT * FROM subject where Sub_id = ? ";
	private static String SQLDeletesub = "DELETE FROM subject WHERE Sub_id=?";
	//Insert items
	public static  Subject insertSub(Subject sub) {
		Connection conn;
	       PreparedStatement stmt;
	       try{
	       conn = JavaCreateDatabaseConnection.getconnection();
	       stmt = conn.prepareStatement(SQLEnrollSub);
	            
	            stmt.setString(1,sub.getSub_id()) ;
	            stmt.setString(2,sub.getSub_name());
	            stmt.setString(3,sub.getCredit());
	            stmt.setString(4,sub.getDuration());
	            stmt.execute();
	            conn.close();
	            stmt.close();
	            //sub.setCredit("how");
	            return sub;
	            }
	            catch(SQLException e){
	                System.out.println(e.getMessage());
	               // sub.setCredit("howll");
	                return sub;
	            }
		
		
	}
	
	// view all items
	public static ArrayList<Subject> getSub(){
		Connection conn;
		 Statement stmt;
		 ResultSet rs;
		 ArrayList<Subject> sublist = new ArrayList<>(); 
	       try{
	       conn = JavaCreateDatabaseConnection.getconnection();
	       stmt =  conn.createStatement();
	       rs = stmt.executeQuery(SQLSelectsub);
	      //STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	         String Sub_id  = rs.getString("Sub_id");
	         String Sub_name  = rs.getString("Sub_name");
	         String Credit_value  = rs.getString("Credit_value");
	         String Duration  = rs.getString("Duration");
	         //adding them to Subject object
	         Subject sub = new Subject(Sub_id,Sub_name,Credit_value,Duration);
	         sublist.add(sub);
	         
	      }
	     
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      e.printStackTrace();
	   }
		return sublist;
	}
	
	// update item
	public static void updateSub(Subject sub) {
		Connection conn;
	       PreparedStatement stmt;
	       try{
	       conn = JavaCreateDatabaseConnection.getconnection();
	       stmt = conn.prepareStatement(SQLUpdatesub);
	            
	            stmt.setString(1,sub.getSub_id()) ;
	            stmt.setString(2,sub.getSub_name());
	            stmt.setString(3,sub.getCredit());
	            stmt.setString(4,sub.getDuration());
	            stmt.setString(5,sub.getSub_id());
	            stmt.execute();
	            conn.close();
	            stmt.close();
	            
	            }
	            catch(SQLException e){
	                System.out.println(e.getMessage());
	                sub.setCredit("howll");
	              
	            }
	}
	
	
	// view selected items
		public static Subject getSelecSub1(String id) throws SQLException{
			Connection conn;
			 PreparedStatement stmt;
			 ResultSet rs = null;
			 Subject sub = null;
			 ArrayList<Subject> sublist2 = new ArrayList<>(); 
		       try{
		       conn = JavaCreateDatabaseConnection.getconnection();
		       stmt = conn.prepareStatement(SQLSelectsub2);
	           stmt.setString(1,id);
	           rs = stmt.executeQuery();
	          
		     
	            while(rs.next()){
	   	         //Retrieve by column name
	   	         String Sub_id  = rs.getString("Sub_id");
	   	         String Sub_name  = rs.getString("Sub_name");
	   	         String Credit_value  = rs.getString("Credit_value");
	   	         String Duration  = rs.getString("Duration");
	   	         //adding them to Subject object
	   	          sub = new Subject(Sub_id,Sub_name,Credit_value,Duration);
	   	         //sublist2.add(sub);
	   	         
	   	      }
	   	     
	   	   }catch(SQLException se){
	   	      //Handle errors for JDBC
	   	      se.printStackTrace();
	   	   }catch(Exception e){
	   	      e.printStackTrace();
	   	   }finally {
	   		rs.close();
	   		
	   	   }
	   		return sub;
	   		
	   	}
		
	//delete items	
		public static void DelSelecSub1(String id) throws SQLException {
			Connection conn = null;
			 PreparedStatement stmt = null;
			 try{
			       conn = JavaCreateDatabaseConnection.getconnection();
			       stmt = conn.prepareStatement(SQLDeletesub);
		           stmt.setString(1,id);
		           stmt.execute();
		           
		 }catch(SQLException se){
	   	      //Handle errors for JDBC
	   	      se.printStackTrace();
	   	   }catch(Exception e){
	   	      e.printStackTrace();
	   	   }finally {
	   		stmt.close();
	   		conn.close();
	   	   }
		}
}



