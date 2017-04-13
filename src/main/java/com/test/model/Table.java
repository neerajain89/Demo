package com.test.model;
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
		
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}
