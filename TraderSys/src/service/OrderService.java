package service;

import java.util.ArrayList;
import java.util.Date;

import mock.OrderMock;
import mock.ProductMock;

import dao.OrderDao;
import pojo.Order;
import pojo.Product;

public class OrderService {
	
	public void addOrder(Order o){
		OrderMock.orlist.add(o);
	}
	
	public Product findProById(int id){
		Product pro = new Product();
		for(Product p : ProductMock.prolist){
			if(p.getPid()==id){
				pro=p;
			}
		}
		return pro;
	}
	
	public float getTotalPrice(ArrayList<Product> list){
		float total=0;
		for(Product p:list){
			total = p.getPrice() + total;
		}
		
		return total;
	}
}