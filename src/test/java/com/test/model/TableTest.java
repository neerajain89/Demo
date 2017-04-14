package com.test.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.rms.model.Table;
import com.rms.model.Visitor;

import junit.framework.Assert;

public class TableTest {

	Table tableInstance;
	@Before
	public void setUp(){
		tableInstance = new Table(2, 1);
		
	}
	@Test(expected=Exception.class)
	public void check_IfGetExceptionIfTableCapacityFull() throws Exception{
		Visitor  vis1 = new Visitor();
		Visitor  vis2 = new Visitor();
		Visitor  vis3 = new Visitor();
        List<Visitor> visitors = new ArrayList<Visitor> ();
        visitors.add(vis1);
        visitors.add(vis2);
        visitors.add(vis3);
		tableInstance.addVistors(visitors);
		
	}
}
