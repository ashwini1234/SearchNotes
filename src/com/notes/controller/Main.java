package com.notes.controller;

import java.math.BigDecimal;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.notes.model.Note;
import com.notes.model.SearchCriteria;

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
		database.addNote(new SearchCriteria(2, new ArrayList<String>(Arrays.asList("Spring", "DI","AOP"))), new Note("Notes2"));
		database.addNote(new SearchCriteria(3, new ArrayList<String>(Arrays.asList("Java", "Hibernate","Oracle","Interview"))), new Note("Notes3"));
		
		Database.printMap(database.getData());
		
		SearchCriteria sc1=new SearchCriteria(new ArrayList<String>(Arrays.asList("AOP", "abc")));
		List <Entry<SearchCriteria, Note>> searchResults =database.searchNote(sc1);
		
		if(!searchResults.isEmpty() && searchResults !=null){
			System.out.println("Search Results are:");
			database.printEntryList(searchResults);
		}else{
			System.out.println("No matches found for the search criteria entered");
		}
		
		SearchCriteria sc2=new SearchCriteria(2, new ArrayList<String>(Arrays.asList("Spring", "DI","AOP","Spring MVC")));
		Note note2=new Note("Updated Notes");
		
		Map.Entry<SearchCriteria, Note> entry=new AbstractMap.SimpleEntry<SearchCriteria, Note>
							(sc1,note2);
		database.editData(entry);
		System.out.println("Notes after Editing");
		database.printEntryList(searchResults);
		
		

		

		
	}
	
	

	
	
	
}



/*Iterator<Entry<SearchCriteria, Note>> iterator =searchResults.iterator();
while(iterator.hasNext()){
	Entry<SearchCriteria, Note> entry = iterator.next();
	System.out.printf("Key : %s and Value: %s %n", entry.getKey().getSearchList(), entry.getValue().getNote());
}*/