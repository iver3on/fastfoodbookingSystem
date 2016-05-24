package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.*;

import cloudshow.FoodWall;

import pojo.Customer;
import pojo.Order;
import pojo.Product;
import pojo.Trader;


public class FileUtil {

	private FileUtil(){}
	
	public static Set<Customer> getCustomers(ObjectInputStream oin) {
		Set<Customer> list = new HashSet<Customer>();
		Customer str=null;
		try {
			while (( str = (Customer)oin.readObject())!=null) {
				list.add(str);
				System.out.println(str);
			}
		} catch (IOException e) {
			System.out.println("con not read...");
			return list;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
		return list;
	}
	
	
	public static Set<Order> getOrders(ObjectInputStream oin) {
		Set<Order> list = new HashSet<Order>();
		Order str;
		try {
			while (( str = (Order)oin.readObject())!=null) {
				list.add(str);
				System.out.println(str);
			}
		} catch (IOException e) {
			return list;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static Set<Product> getProducts(ObjectInputStream oin) {
	
		Set<Product> list = new HashSet<Product>();
		Product str;
		try {
			while (( str = (Product)oin.readObject())!=null) {
				list.add(str);
				System.out.println(str);
			}
		} catch (IOException e) {
			return list;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static Set<Trader> getTraders(ObjectInputStream oin) {
		Set<Trader> list = new HashSet<Trader>();
		Trader str;
		try {
			while (( str = (Trader)oin.readObject())!=null) {
				list.add(str);
				System.out.println(str);
			}
		} catch (IOException e) {
			return list;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	
	
	
}
