package service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import mock.CustomerMock;

import pojo.Customer;
import service.CustomerService;

public class CustomerServiceImpl implements CustomerService{
	
	public static Set<Customer> getCustomers() {
		return customers;
	}

	public static void setCustomers(Set<Customer> customers) {
		CustomerServiceImpl.customers = customers;
	}

	private static Set<Customer> customers= new HashSet<Customer>();


	public int delCustomer(Customer customer) {
		customers = CustomerMock.trlist;
		if(customer!=null){
			for(Customer temp : customers){
				if(temp.getCustomerName().equals(customer.getCustomerName())){
					customers.remove(customer);
					return 1;
				}
			}
		}
		return 0;
	}

	public Customer login(Customer customer) {
		customers = CustomerMock.trlist;
		if (customer != null) {
			for (Customer temp : customers) {
				if (temp.getCustomerName().equals(customer.getCustomerName())
						&& temp.getPassword().equals(customer.getPassword())
							) {
					return customer;
				}
			}
		}
		return null;
	}


	public Customer findUserById(Integer id) {
		customers = CustomerMock.trlist;
		if (id != null) {
			for(Customer temp:customers){
				if(temp.getCustomerId()==id){
					return temp;
				}
			}
		}
		return null;
	}

	public Customer updateCustomer(Customer customer) {
		customers =  CustomerMock.trlist;
		if(customer!=null){
			for(Customer temp:customers){
				if(temp.getCustomerId()==customer.getCustomerId()){
					temp.setCustomerName(customer.getCustomerName());
					temp.setPassword(customer.getPassword());
					temp.setAddress(customer.getAddress());
					temp.setFaver(customer.getFaver());
					return customer;
		
				}
			}
		}
		return null;
	}

	public boolean regist(Customer customer) {
		customers = CustomerMock.trlist;
		if (customer != null) {
			for (Customer temp : customers) {
				if (temp.getCustomerName().equals(customer.getCustomerName())) {
					return false;
				}
			}
		}
		customers.add(customer);
		return true;
	}

	public boolean checkCustomer(Customer customer) {
		customers =CustomerMock.trlist;
		if (customer != null) {
			for (Customer temp : customers) {
				if (temp.getCustomerName().equals(customer.getCustomerName())) {
					return false;
				}
			}
		}
		//customers.add(customer);
		return true;
	}

	

}
