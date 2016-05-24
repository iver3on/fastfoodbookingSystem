package pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Customer {
	private Integer customerId;
	private ArrayList<String> address;
	private String customerName;
	private String password;
	private ArrayList<Order> orderList;
	private Map<Integer, Integer> faver = new HashMap<Integer, Integer>();
	private int mostFaver=0;
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public ArrayList<String> getAddress() {
		return address;
	}
	public void setAddress(ArrayList<String> address) {
		this.address = address;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ArrayList<Order> getOrderList() {
		return orderList;
	}
	public void setOrderList(ArrayList<Order> orderList) {
		this.orderList = orderList;
	}
	public Map<Integer, Integer> getFaver() {
		return faver;
	}
	public void setFaver(Map<Integer, Integer> faver) {
		this.faver = faver;
	}
	public int getMostFaver() {
		return mostFaver;
	}
	public void setMostFaver(int mostFaver) {
		this.mostFaver = mostFaver;
	}
	
	
	
	
}
