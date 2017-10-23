package com.usyd.gscp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usyd.gscp.dao.OrdersDao;
import com.usyd.gscp.domain.Orders;

@Service(value = "ordersService")
@Transactional
public class OrdersService{
	
	@Autowired
	private OrdersDao orderDao;
	
	public Orders getOrderById(int id){
		return orderDao.getOrderById(id);
	}
	
	public Orders getOrderById(String id) {
    	return orderDao.getOrderById(Integer.parseInt(id));
    }
	
	public void createNewOrder(Orders order){
		orderDao.saveOrder(order);
	}
	
	public void uploadOrder(Orders order) {
		orderDao.saveOrder(order);
	}
	
	public void updateBook(Orders order) {
		orderDao.saveOrder(order);
	}
	
	public void deleteOrder(Orders order){
		orderDao.delete(order);
	}
	
	public ArrayList<Orders> getOrderByBuerId(int id){
		ArrayList<Orders> result = (ArrayList<Orders>) orderDao.getOrderByBuyer("buyer", id);
		return result;
	}
	
	public ArrayList<Orders> getOrderByStatus(String status){
		ArrayList<Orders> result = (ArrayList<Orders>) orderDao.getOrderByStatus("status", status);
		return result;
	}
	
}