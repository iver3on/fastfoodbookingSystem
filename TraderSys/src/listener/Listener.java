package listener;

import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import mock.CommentMock;
import mock.CourierMock;
import mock.CustomerMock;
import mock.OrderMock;
import mock.PathMock;
import mock.ProductMock;
import mock.TraderMock;
import mock.Trans;


import pojo.Comment;
import pojo.Courier;
import pojo.Customer;
import pojo.Order;
import pojo.Product;
import pojo.Trader;

import util.FileUtil;
import util.PostRequest;


import dao.CommentDao;
import dao.CourierDao;
import dao.OrderDao;
import dao.ProductDao;
import dao.TraderDao;

public class Listener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	try {
		System.out.println("des-------");
		
		
		//系统内置数据
		Comment comment = new Comment();
		comment.setCid(1);
		comment.setContent("aa");
		CommentMock.comList.add(comment);
		
		Courier courier = new Courier();
		courier.setCourier(4);
		courier.setName("bv");
		CourierMock.colist.add(courier);
		
		Order order = new Order();
		order.setCourierId(5);
		order.setId(5);
		order.setState("4");
		order.setCreateTime(null);
		order.setSendTime(null);
		order.setFinishTime(null);
		order.setTid(5);
		
		Product pro = new Product();
		pro.setPid(1);
		pro.setProName("油酥饼");
		float price= (float) 12.5;
		pro.setPrice(price);
	
		
		Product pro2 = new Product();
		pro2.setPid(2);
		pro2.setProName("烩麻食");
		float price2= (float) 12.5;
		pro.setPrice(price2);
		
		Product pro3 = new Product();
		pro3.setPid(3);
		pro3.setProName("红烧排骨面");
		float price3= (float) 45.1;
		pro.setPrice(price3);
		
		Customer customer = new Customer();
		customer.setCustomerId(4);
		customer.setCustomerName("aaa");
		ArrayList<String> ad = new ArrayList<String>();
		ad.add("fgf");
		customer.setAddress(ad);
		customer.setPassword("123");
		CustomerMock.cuList.add(customer);
		
		Customer customer2 = new Customer();
		customer2.setCustomerId(5);
		customer2.setCustomerName("aaa");
		ArrayList<String> ad2 = new ArrayList<String>();
		ad2.add("fadsf");
		customer2.setAddress(ad2);
		customer2.setPassword("123");
		CustomerMock.cuList.add(customer2);
		
		
		Trader trader = new Trader();
		trader.setTid(13579);
		
		
		FileUtil.putComments();
		FileUtil.putCouriers();
		FileUtil.putOrders();
		FileUtil.putProducts();
		FileUtil.putTraders();
		FileUtil.putCustomer();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
		try {

			
			
			
			System.out.println("init-------");
			PathMock.path=arg0.getServletContext().getRealPath("/");
			
			//给餐墙推数据
			String url=Trans.foodwall+"filetrans.action";
			String filePath = arg0.getServletContext().getRealPath("/");
			PostRequest.submitPost(url, filePath);
			
			//给买方推数据
			String url2=Trans.html + "dataAccept.action";
			PostRequest.submitPost(url2, filePath);
			
			
			CourierMock.colist = FileUtil.getCouriers();
			OrderMock.orlist = FileUtil.getOrders();
			ProductMock.prolist = FileUtil.getProducts();
			TraderMock.trlist = FileUtil.getTraders();
			CustomerMock.cuList = FileUtil.getCustomer();
			CommentMock.comList = FileUtil.getComments();
			
			for(Customer c : CustomerMock.cuList){
				System.out.println("customer name");
				System.out.println(c.getCustomerName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
