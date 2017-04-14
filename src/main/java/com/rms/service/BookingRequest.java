package com.rms.service;

import java.util.Date;
import java.util.List;

import com.rms.data.dao.DaoUtil;
import com.rms.model.Booking;
import com.rms.model.TimeSlot;
import com.rms.model.Visitor;
import com.rms.service.Restaurent;
/**
 * 
 * @author Neeraj Jain
 * This Class Represents the Booking Request 
 * User can check Availability of seats between specified date time  
 * Booking Request 
 */
public class BookingRequest implements Booking {


	 private static BookingRequest request ;
	 private  BookingRequest() {
	
	 }
	 public static  BookingRequest getInstance(){
		 if(request == null){
		        synchronized (BookingRequest.class) {
		            if(request == null){
		            	request = new BookingRequest();
		            }
		        }
		    }
		    return request;
	    }
	 @Override
	 public boolean checkAvaialabity(String restaurentName,TimeSlot timeSlotToBook,int noOfVisitors){
		 try {
			if(DaoUtil.getRestaurentRepo().get(restaurentName).isTableAvailable(noOfVisitors, timeSlotToBook))
			   return true;
			 else 
				 return false ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	 }
		
	
	@Override
	public boolean bookTables(String restaurentName, List<Visitor> visList, TimeSlot timeSlotToBook, int noOfVisitors)  {
		try {
			return DaoUtil.getRestaurentRepo().get(restaurentName).fillTable(noOfVisitors, timeSlotToBook,visList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	@Override
	public void notifyBookingToRestaurent() {
		// TODO Auto-generated method stub
		
	}
}
