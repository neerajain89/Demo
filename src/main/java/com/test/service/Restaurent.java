package com.test.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import com.test.model.Table;
import com.test.model.TimeSlot;
import com.test.model.Visitor;

/**
 * 
 * @author Neeraj Jain
 *
 *This Class Represents the Restaurant 
 * Every restaurant  Object will have opening closing time 
 * restaurantId system  unique  Id generated at the time of Restaurant Registration  
 *
 */
public class  Restaurent {
	
	private Date openingTime;
	private Date closingTime;
	private String address;
	private int restaurentId;
    /**
     * A thread safe collection for Available Tables 
     * 
     */
	private CopyOnWriteArrayList<Table> availabletables;
    /**
     * A thread safe colletion for bookedTables ;
     */
	private CopyOnWriteArrayList<Table> bookedtables;

	private ConcurrentHashMap<Table,List<TimeSlot>> tableBookingMap ;
	
	public Restaurent(int restaurentId,List<Table> tables){
		this.restaurentId=restaurentId;
		this.availabletables=(CopyOnWriteArrayList<Table>) tables;
		bookedtables =  new CopyOnWriteArrayList<Table> ();
	}
	public boolean checkIn(){
	
		
		return true;
	}
	public boolean checkOut(){
		
		return false;
	}
	public Date getOpeningTime() {
		return openingTime;
	}
	public void setOpeningTime(Date openingTime) {
		this.openingTime = openingTime;
	}
	public Date getClosingTime() {
		return closingTime;
	}
	public void setClosingTime(Date closingTime) {
		this.closingTime = closingTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public boolean equals(Object obj) {
		if(((Restaurent) obj).restaurentId==this.restaurentId){
			return true;
		}else 
			return false;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return restaurentId;
	}
	public   boolean fillTable(int noOfVisitors,TimeSlot timeSlot,List<Visitor> visList) throws Exception{
		
		Table availableTable=checkTableAvailability(noOfVisitors, timeSlot);
		availableTable.addVistors(visList);
		if(tableBookingMap.contains(availableTable)){
			tableBookingMap.get(availableTable).add(timeSlot)	;
			return true;
		}else if(availableTable!=null){
			List<TimeSlot> timeSlotList = new ArrayList<TimeSlot>();
			timeSlotList.add(timeSlot);
			tableBookingMap.put(availableTable,timeSlotList);
			return true ;
		}
		
		return false;
	}
	
	
	private boolean checkTimeSlotValid(TimeSlot timeSlot){
		
		if(this.openingTime.compareTo(timeSlot.getStartTime())<=0&&this.closingTime.compareTo(timeSlot.getEndTime())>0){
			return true;
		}
			
		return false ;
	}
	public    boolean clearTable(Table tableToClear){
		if(bookedtables.contains(tableToClear)){
			bookedtables.remove(tableToClear);
			availabletables.add(tableToClear);
		  return true ;
		}
		return false;
	
	}
	private Table checkTableAvailability(int noOfVisitors,TimeSlot timeSlotToBook) throws Exception{
		if(availabletables.isEmpty()){
			throw new Exception("No Table Present");
		}
		if(!checkTimeSlotValid(timeSlotToBook)){
			throw new Exception("Invalid Time Slot");

		}
		Table tableToBook=null;
		for(Table table :availabletables){
			if(table.getCapacity()==noOfVisitors){
				tableToBook=table;
			}
		}
		if(tableToBook==null){
			throw new Exception("No Table of Such Capacity Available Try Other!!");
		}
		return getTableForBooking(timeSlotToBook, tableToBook);
		

		
	}
	private Table getTableForBooking(TimeSlot timeSlotToBook, Table tableToBook) throws Exception {
		if(tableBookingMap.containsKey(tableToBook)){
			for(TimeSlot timeSlotAlreadyBooked : tableBookingMap.get(tableToBook)){
				if(timeSlotAlreadyBooked.getStartTime().compareTo(timeSlotToBook.getStartTime())<=0&&timeSlotAlreadyBooked.getEndTime().compareTo(timeSlotToBook.getEndTime())>0){
					throw new Exception("Table Already Booked for the Time Slot");
				}else {
					
					return tableToBook;
				}
			}
				
		}else {
			return tableToBook;
		}
		throw new Exception("System Error");

	}
	
	public boolean isTableAvailable(int noOfVisitors,TimeSlot timeSlotForBooking) throws Exception{
		
		if(checkTableAvailability(noOfVisitors, timeSlotForBooking)!=null){
			return true;
		}
		return false;
		
	}
	
}
