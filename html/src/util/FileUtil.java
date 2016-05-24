package util;

import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.Set;

import pojo.Customer;
import pojo.Order;
import pojo.Product;
import pojo.Trader;

public class FileUtil {

	private FileUtil(){}
	
	public static Set<Customer> getCustomers(ObjectInputStream oin) throws Exception{
		Set<Customer> list = new HashSet<Customer>();
		Customer str;
		while (( str = (Customer)oin.readObject())!=null) {
			list.add(str);
			System.out.println(str);
		}
		oin.close();
		return list;
	}
	
	
	public static Set<Order> getOrders(ObjectInputStream oin) throws Exception{
		Set<Order> list = new HashSet<Order>();
		Order str;
		while (( str = (Order)oin.readObject())!=null) {
			list.add(str);
			System.out.println(str);
		}
		oin.close();
		return list;
	}
	
	public static Set<Product> getProducts(ObjectInputStream oin) throws Exception{
	
		Set<Product> list = new HashSet<Product>();
		Product str;
		while (( str = (Product)oin.readObject())!=null) {
			list.add(str);
			System.out.println(str);
		}
		oin.close();
		return list;
	}
	
	public static Set<Trader> getTraders(ObjectInputStream oin) throws Exception{
		Set<Trader> list = new HashSet<Trader>();
		Trader str;
		while (( str = (Trader)oin.readObject())!=null) {
			list.add(str);
			System.out.println(str);
		}
		oin.close();
		return list;
	}

	
	
	
}