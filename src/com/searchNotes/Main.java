package com.searchNotes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/**
 * 
 * @author AP00127798
 * 
 * 
 * 
 *
 */
public class Main {

	public static void main(String[] args) {
		Database database=new Database();
		database.addNote(new SearchCriteria(1, new ArrayList<String>(Arrays.asList("Java", "Spring","Interview"))), new Note("Notes1"));
		database.addNote(new SearchCriteria(2, new ArrayList<String>(Arrays.asList("Java", "Spring","Interview"))), new Note("Notes2"));
		database.addNote(new SearchCriteria(3, new ArrayList<String>(Arrays.asList("Java", "Spring","Interview"))), new Note("Notes3"));
		
		Database.printMap(database.getData());
	}
	
	

	
	
	
}
