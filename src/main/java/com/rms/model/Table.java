package com.rms.model;

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
	
	public Table(int capacity,int tableNumber){
		this.capacity=capacity;
		this.tableNumber=tableNumber;
	}
	
	
	public int getCapacity() {
		return capacity;
	}
	
	public void  addVistors(List<Visitor> vistors) throws Exception{
		if(this.vistors.size()==capacity){
			throw new Exception("Table Capacity Full");
		}else if(this.vistors==null){
			vistors = new ArrayList<Visitor>();
		}
		this.addVistors(vistors);
		
	}


	public int getTableNumber() {
		return tableNumber;
	}


	public List<Visitor> getVistors() {
		return vistors;
	}


	
	
	
}
