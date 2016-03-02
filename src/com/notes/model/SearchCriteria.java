package com.notes.model;

import java.util.List;

/**
 * 
 * @author AP00127798 Search Criteria is key of HashMap<SearchCriteria, Notes>
 *         It contains a variable searchList to hold Search Criteria
 *         Methods:Contains getters and setters for searchList, Set
 *         searchFlag=true for Search Operation
 */

public class SearchCriteria {
	private int id;
	private List<String> searchList;
	private static boolean searchFlag = false;

	public List<String> getSearchList() {
		return searchList;
	}

	public void setSearchList(List<String> searchList) {
		this.searchList = searchList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public SearchCriteria() {
		super();
	}

	public SearchCriteria(int id, List<String> list) {
		super();
		this.id = id;
		this.searchList = list;
	}
	
	
	/**
	 * 
	 *  [Java, Spring, Interview]:Notes1
	 	[Spring, DI, AOP]:Notes2
		[Java, Hibernate, Oracle, Interview]:Notes3
		
		userSearch:Java, Spring
		Result: Notes 1 and Notes 3
	 * 
	 * @param sc
	 * @return
	 */
	public int matchLevel(SearchCriteria sc){
		int count=0;
		for(String k: sc.getSearchList()){
			for(String s:this.searchList){
				if(s.toLowerCase().contains(k.toLowerCase())){
					count++;
				}
			}
		}
		return count;
	}

	@Override
	public int hashCode() {
		if(searchFlag){
			return 0;
		}else{
			return id;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SearchCriteria searchCriteria = (SearchCriteria) obj;
		if(searchFlag){
			//check containsKey
			for(String s:searchCriteria.getSearchList()){
				for(String str:this.searchList){
					if(s.equals(str)){
						
					}
				}
			}		
		}else{
			// if id is equal,then object is equal----return true
			if (this.id == searchCriteria.id) {
				return true;
			} return false;
		}
		return false;
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * @Override public int hashCode() { if(searchFlag){ return 0; }else{ return
	 * id; } }
	 */
	/*
	 * @Override public boolean equals(Object obj) { if (this == obj) return
	 * true; if (obj == null) return false; if (getClass() != obj.getClass())
	 * return false; SearchCriteria searchCriteria = (SearchCriteria) obj;
	 * 
	 * if (searchList == null) { if (searchCriteria.searchList != null) return
	 * false; } else if (!searchList.equals(searchCriteria.searchList)) return
	 * false; return true; if(searchFlag){ // //check containsKey }else{ //if id
	 * is equal,then object is equal----return true } }
	 */

}
