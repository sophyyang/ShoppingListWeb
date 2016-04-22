package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dbConnTester {

	public static void main(String[] args) {
	
			String url = "jdbc:mysql://localhost:3306/shopping";
			String user = "root";
			String password = "password";

			try {

				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, user, password);
				System.out.println("Connection made");
				
				ListItemDAO dao = new ListItemDAO();
				
				for(ListItem i : dao.getListOfAllItems()){
					System.out.println(i);
				}

			} catch (Exception ex) {
				Logger lgr = Logger.getLogger(ListItemDAO.class.getName());
				lgr.log(Level.SEVERE, ex.getMessage(), ex);
				System.out.println("Sql Exception");

			}

		}

	

}
