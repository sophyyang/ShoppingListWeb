package model;

public class ListItem {
	
	
	private String store;
	private String item;
	
	public ListItem(String s, String i){
		store = s;
		item = i;
		
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String toString(){
		return store + ": " + item;
	}
}
