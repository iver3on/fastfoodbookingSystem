package service.impl;

import java.util.ArrayList;
import java.util.List;

import mock.OrderMock;
import mock.ProductMock;
import pojo.Order;
import pojo.Product;
import service.OrderService;

import util.PostRequest;


public class OrderServiceImpl implements OrderService {


	private static ArrayList<Order> orders = new ArrayList<Order>();

	public static ArrayList<Order> getOrders() {
		return orders;
	}

	public static void setOrders(ArrayList<Order> orders) {
		OrderServiceImpl.orders = orders;
	}

	public int addOrder(Order order) {
		try {
			PostRequest.postHttpReqest("http://192.168.0.202:8888/TraderSys", order, "order");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}

	public int delOrder(Order order) {
		orders = (ArrayList<Order>) OrderMock.trlist;
		if(order!=null){
			for(Order temp : orders){
				if(temp.getId()==order.getId()){
					orders.remove(order);
					return 1;
				}
			}
		}
		return 0;
	}
	
	public static List<Product> findproductsbypids(ArrayList<Integer> pids){
		ArrayList<Product> products=null;
		int i=0;
		while(i<pids.size()){
			int pid=pids.get(i);
			for(Product temp:ProductMock.trList){
				if(pid==temp.getPid())
					products.add(temp);
					i++;
					break;
			}
		}
		return products;
		
	}
	
	public float countTotalPrice(Order order) {
		
		ArrayList<Product> list =(ArrayList<Product>) findproductsbypids( order.getPro());;
		float totalPrice=0;
		for(Product product : list){
			totalPrice = totalPrice+product.getPrice();
		}
		return 0;
	}
	


}
