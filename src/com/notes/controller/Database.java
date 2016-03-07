package com.notes.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.notes.model.Note;
import com.notes.model.SearchCriteria;

/**
 * 
 * @author AP00127798
 * 
 *         Database class contains code to add data to HashMap
 * 
 * 
 *
 */
public class Database {

	private HashMap<SearchCriteria, Note> dataMap = new HashMap<SearchCriteria, Note>();

	// SearchCriteria searchCriteria=new SearchCriteria();

	public HashMap<SearchCriteria, Note> getData() {
		return dataMap;
	}

	public void setData(HashMap<SearchCriteria, Note> data) {
		this.dataMap = data;
	}

	public void addNote(SearchCriteria keyList, Note note) {
		if (!dataMap.containsKey(keyList)) {
			dataMap.put(keyList, note);
		}
	}

	/**
	 * if the search Criteria entered by user matches the keywords in any of the
	 * keys, then return all the values containing those keywords in keys
	 * 
	 * [Java, Spring, Interview]:Notes1 [Spring, DI, AOP]:Notes2 [Java,
	 * Hibernate, Oracle, Interview]:Notes3
	 * 
	 * userSearch:Java, Spring Result: Notes 1 and Notes 3 Loop thru the
	 * arraylist
	 * 
	 * use matchLevel() from SearchCriteria make a list of keywords after
	 * matching, sort them using compare anonymous block:compare() for sorting
	 * return all values for the keywords list
	 * 
	 * 
	 * @param keyList
	 */
	public List<Entry<SearchCriteria, Note>> searchNote(final SearchCriteria sc) {
		List<Entry<SearchCriteria, Note>> matchedSearchList = new ArrayList<Entry<SearchCriteria, Note>>();

		// adding matched elements to the list
		for (Entry<SearchCriteria, Note> e : dataMap.entrySet()) {
			int count = sc.matchLevel(e.getKey());
			if (count > 0) {
				matchedSearchList.add(e);
			}
		}
		// sort matchedSearchList based on matchLevel count
		Collections.sort(matchedSearchList, new Comparator<Entry<SearchCriteria, Note>>() {
			@Override
			public int compare(Entry<SearchCriteria, Note> o1, Entry<SearchCriteria, Note> o2) {
				int c1 = sc.matchLevel(o1.getKey());
				int c2 = sc.matchLevel(o2.getKey());
				return c1 == c2 ? 0 : (c1 - c2) / Math.abs(c1 - c2);

			}
		});
		return matchedSearchList;
	}

	public void editData(Entry<SearchCriteria, Note> e){
		this.dataMap.put(e.getKey(), e.getValue());
	}
	
	
	public static void printMap(HashMap<SearchCriteria, Note> map) {
		Set<SearchCriteria> keys = map.keySet();
		for (SearchCriteria s : keys) {
			System.out.println(s.getSearchList() + ":"
					+ map.get(new SearchCriteria(s.getId(), s.getSearchList())).getNote());
		}
	}
	
	public void printEntryList(List<Entry<SearchCriteria, Note>> searchNotes){
		for(Entry<SearchCriteria, Note> e: searchNotes){
			System.out.printf("Key : %s and Value: %s %n", e.getKey().getSearchList(), e.getValue().getNote());
		}
	}
}

/*
 * public void searchNote(List<String> keyList){ Set<SearchCriteria> keys =
 * dataMap.keySet(); for(String userSearch:keyList){ for(SearchCriteria
 * searchCriteria: keys){ for(String searchList:searchCriteria.getSearchList()){
 * if(userSearch.equalsIgnoreCase(searchList)){ //return } } } }
 * 
 * }
 */
