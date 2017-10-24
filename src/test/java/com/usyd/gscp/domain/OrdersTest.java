package com.usyd.gscp.domain;

import java.util.Date;

import junit.framework.TestCase;

public class OrdersTest extends TestCase {
	private Orders orders;
	protected void setUp() throws Exception {
		orders = new Orders();
	}
	public void testSetAndGetId(){
		int id = 1;
		orders.setId(id);
		assertEquals(orders.getId(), id, 0);
	}

	public void testSetAndGetBuyer(){
		int buyer = 1;
		orders.setBuyer(buyer);
		assertEquals(orders.getBuyer(), buyer, 0);
	}
	
	public void testSetAndGetSeller(){
		int seller = 1;
		orders.setSeller(seller);
		assertEquals(orders.getSeller(), seller, 0);
	}
	
	public void testSetAndGetItem(){
		int item = 1;
		orders.setItem(item);
		assertEquals(orders.getItem(), item, 0);
	}

	public void testSetAndGetDate() {
		Date date = new Date();
		assertNull(orders.getDate());
		orders.setDate(date);
		assertEquals(orders.getDate(), date);
	}
	
	public void testSetAndGetStatus(){
		String status = "status";
		assertNull(orders.getStatus());
		orders.setStatus(status);
		assertEquals(orders.getStatus(), status);
	}
}