package service;

import pojo.Customer;


public interface CustomerService {
	
	public boolean regist(Customer customer);
	public int delCustomer(Customer customer);
	public Customer login(Customer customer);
	public boolean checkCustomer(Customer customer);
	public Customer findUserById(Integer id);
	public Customer updateCustomer(Customer customer);
	
	
}
