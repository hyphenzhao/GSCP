package com.usyd.gscp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usyd.gscp.dao.OrderDao;
import com.usyd.gscp.domain.Order;

@Service(value = "orderService")
@Transactional
public class OrderService{
	
	@Autowired
	private OrderDao orderDao;
	
	public Order getOrderById(int id){
		return orderDao.getOrderById(id);
	}
	
	public Order getOrderById(String id) {
    	return orderDao.getOrderById(Integer.parseInt(id));
    }
	
	public void createNewOrder(Order order){
		orderDao.saveOrder(order);
	}
	
	public void uploadOrder(Order order) {
		orderDao.saveOrder(order);
	}
	
	public void updateBook(Order order) {
		orderDao.saveOrder(order);
	}
	
	public ArrayList<Order> getOrderByBuerId(int id){
		ArrayList<Order> result = (ArrayList<Order>) orderDao.getOrderByBuyer("buyer", id);
		return result;
	}
	
	public ArrayList<Order> getOrderByStatus(String status){
		ArrayList<Order> result = (ArrayList<Order>) orderDao.getOrderByStatus("status", status);
		return result;
	}
	
}