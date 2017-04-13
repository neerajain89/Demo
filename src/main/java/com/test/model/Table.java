package com.test.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Neeraj
 *
 */
public class Table {
	/**
	 * Table Number uniquely defines the table 
	 */
	private  int tableNumber ;
	private  List<Visitor> vistors ; 
	/**
	 * capacity defines the number of people can sit on table
	 */
	private  final int  capacity ;
	
	public Table(int capacity){
		this.capacity=capacity;
	}
	
	
	public int getCapacity() {
		return capacity;
	}
	@Override
	public boolean equals(Object obj) {
		if(((Table) obj).tableNumber==this.tableNumber){
			return true;
		}else 
			return false;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return tableNumber;
	}
	public void  addVistors(List<Visitor> vistors) throws Exception{
		if(this.vistors.size()==capacity){
			throw new Exception("Table Capacity Full");
		}else if(this.vistors==null){
			vistors = new ArrayList<Visitor>();
		}
		this.addVistors(vistors);
		
	}
}
