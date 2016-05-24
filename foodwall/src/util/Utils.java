package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cloudshow.FoodWall;

import pojo.Customer;
import pojo.Order;
import pojo.Product;
import pojo.User;

public class Utils {
	public static Customer finduserbyorder(Order order,Set<Customer> users){
		int id=order.getCourierId();
		for(Customer temp:users){
			if(temp.getCustomerId().equals(id)){
				return temp;
			}
		}
		return null;
	}

	public static List<Product> findproductsbypids(ArrayList<Integer> pids){
		ArrayList<Product> products=null;
		int i=0;
		while(i<pids.size()){
			int pid=pids.get(i);
			for(Product temp:FoodWall.getProducts()){
				if(pid==temp.getPid())
					products.add(temp);
					i++;
					break;
			}
		}
		return products;
		
	}
	
	public static Customer finduserbyid(String uid,Set<Customer> users){
		for(Customer temp:users){
			if(temp.getCustomerId().equals(uid))
				return temp;
		}
		return null;
	}

	



}

