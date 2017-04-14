package com.test.model;

import java.util.List;

/**
 * 
 * @author stpl
 *
 */

public interface  Booking {

	public boolean checkAvaialabity(String restaurentName,TimeSlot timeSlotToBook,int noOfVisitors);
	
	public boolean bookTables(String restaurentName,List<Visitor> visList,TimeSlot timeSlotToBook,int noOfVisitors);
		
	public void notifyBookingToRestaurent();
	


}
