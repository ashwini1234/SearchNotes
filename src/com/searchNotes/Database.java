package com.searchNotes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;


/**
 * 
 * @author AP00127798
 * 
 * Database class contains code to add data to HashMap
 * 
 * 
 *
 */
public class Database {
	
	private HashMap<SearchCriteria,Note> dataMap=new HashMap<SearchCriteria,Note>();
		
	public HashMap<SearchCriteria, Note> getData() {
		return dataMap;
	}

	public void setData(HashMap<SearchCriteria, Note> data) {
		this.dataMap = data;
	}

	public void addNote(SearchCriteria keyList,Note note){
		if(!dataMap.containsKey(keyList)){
			dataMap.put(keyList, note);
		}
	}
	
	public static void printMap(HashMap<SearchCriteria, Note> map){
        Set<SearchCriteria> keys = map.keySet();
        for(SearchCriteria s:keys){
            System.out.println(s+"=="+map.get(new SearchCriteria(s.getId(),s.getSearchList())).getNote());
        }
	 }

}


