package com.test.data.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.test.model.Table;
import com.test.service.Restaurent;
/**
 * Just TO Avoid Complexity with Database Interaction 
 * Have created This class to Populate the data as class loads 
 * 
 * 
 * @author Neeraj Jain
 *
 */
public class DaoUtil {

	
	private static  HashMap<String,Restaurent>  restaurentRepo ;
	
	
	/**
	 * 
	 * This Method Populate Restaurant Data 
	 * 
	 * @return
	 */
	public static HashMap<String,Restaurent>  getRestaurentRepo(){
		
		if(restaurentRepo==null){
			
			synchronized (DaoUtil.class) {
				
				
				if(restaurentRepo==null){
					/**
					 * Table Initilization For Delhi 
					 */
					List<Table>  listOfTables = new ArrayList<Table>();
					Table  centerTable = new Table(5,1);
					Table  cornerOneTable = new Table(4,2);
					Table  cornerTwoTable = new Table(4,3);
					Table  cornerThreeTable = new Table(4,4);
					listOfTables.add(centerTable);
					listOfTables.add(cornerOneTable);
					listOfTables.add(cornerTwoTable);
					listOfTables.add(cornerThreeTable);
					Restaurent  delhiRestaurent = new Restaurent(1,listOfTables);
					/**
					 * Table Initilization For Gurgaon 
					 */
					List<Table>  listOfTablesGgn = new ArrayList<Table>();
					Table  centerTableGgn = new Table(5,1);
					Table  cornerOneTableGgn = new Table(4,2);
					Table  cornerTwoTableGgn = new Table(4,3);
					Table  cornerThreeTableGgn = new Table(4,4);
					listOfTables.add(centerTableGgn);
					listOfTables.add(cornerOneTableGgn);
					listOfTables.add(cornerTwoTableGgn);
					listOfTables.add(cornerThreeTableGgn);
					Restaurent  gurgaonRestaurent = new Restaurent(2,listOfTablesGgn);
					
					restaurentRepo.put("ggn",gurgaonRestaurent);
					restaurentRepo.put("delhi",delhiRestaurent);
					
				}
			}
			
		}
		
		return restaurentRepo;
		
		
	}

}
