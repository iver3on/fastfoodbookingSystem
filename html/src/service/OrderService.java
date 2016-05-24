package service;

import java.util.ArrayList;
import java.util.List;

import pojo.Order;
import pojo.Order;

public interface OrderService {
	
	public int addOrder(Order order);
	public int delOrder(Order order);
		
	public float countTotalPrice(Order order);
	
}
