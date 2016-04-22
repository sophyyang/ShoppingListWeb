package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListItemDAO {

	ArrayList<ListItem> listOfAllItems = new ArrayList<ListItem>();
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

	public ListItemDAO() {
		
		makeConnection();
		
		try{
		String q = "SELECT * from items";

		st = con.createStatement();
		rs = st.executeQuery(q);
		
		while(rs.next()){
			String tempStore = rs.getString(2);
			String tempItem = rs.getString(3);
			
			ListItem e = new ListItem(tempStore, tempItem);
			listOfAllItems.add(e);
		}
		
		if(rs != null){
			rs.close();
		}
		if(st != null){
			st.close();
		}
		if(con != null){
			con.close();
		}
		
		} catch (SQLException ex){
			System.out.println("Error with table or data");
		}

	}

	

	public ArrayList<ListItem> getListOfAllItems() {
		return listOfAllItems;
	}



	public ArrayList<ListItem> getCurrentListFromStore(String s) {
		ArrayList<ListItem> itemsFromSpecificStore = new ArrayList<ListItem>();
		
		for(int i = 0; i <listOfAllItems.size(); i++){
			if(listOfAllItems.get(i).getStore().equals(s)){
				itemsFromSpecificStore.add(listOfAllItems.get(i));
			}
				
		}
		return itemsFromSpecificStore;
	}
	
	public ArrayList<String> getUniqueStores(){
		ArrayList<String> tempListOfAllStores = new ArrayList<String>();
		
		for(int i = 0; i <listOfAllItems.size(); i++){
				tempListOfAllStores.add(listOfAllItems.get(i).getStore());
			
		}
		
		
		HashSet<String> unique = new HashSet<String>(tempListOfAllStores);
		ArrayList<String> uniqueStores = new ArrayList<String>(unique);
		return uniqueStores;
		
	}

	public void insertNewItem(ListItem i) {
		makeConnection();

		try{
			String q = "insert into items (store, item) values"
					+ " ('" + i.getStore() + "', '" + i.getItem()+ "');";
			
			st = con.createStatement();
			st.executeUpdate(q);
			
			
			if(st != null){
				st.close();
			}
			if(con != null){
				con.close();
			}
			
			} catch (SQLException ex){
				System.out.println("Error with table or data");
			}
	}
	
	public void updateItem(ListItem oldValues, ListItem newValues){
		makeConnection();
		
		try {
			String oldStore = oldValues.getStore();
			String oldItem = oldValues.getItem();
			String newStore = newValues.getStore();
			String newItem = newValues.getItem();
			
			String q = "update items set STORE = '" + newStore + "', ITEM = '" + newItem + "' where STORE = '" + oldStore + "' AND ITEM = '" + oldItem + "'";
			
			st = con.createStatement();
			st.executeUpdate(q);
			if(st != null){
				st.close();
			}
			if(con != null){
				con.close();
			}
			
			} catch (SQLException ex){
				System.out.println("Error with updateItem query");
			}
		
	}

	public void deleteItem(ListItem i) {
		makeConnection();
		try{
			String q = "delete from items where store ='" 
					+ i.getStore() + "' and item = '" + i.getItem()+ "' limit 1";
			
			st = con.createStatement();
			st.executeUpdate(q);
			
			
			if(st != null){
				st.close();
			}
			if(con != null){
				con.close();
			}
			
			} catch (SQLException ex){
				System.out.println("Error with table or data");
			}
		
	}

	public void makeConnection() {
		String url = "jdbc:mysql://localhost:3306/shopping";
		String user = "root";
		String password = "password";
 
		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection made");

		} catch (Exception ex) {
			Logger lgr = Logger.getLogger(ListItemDAO.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			System.out.println("Error in Database Connection " + ex.getMessage());

		}

	}
}
