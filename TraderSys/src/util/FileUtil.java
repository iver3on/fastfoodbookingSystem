package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import mock.CommentMock;
import mock.CourierMock;
import mock.CustomerMock;
import mock.OrderMock;
import mock.PathMock;
import mock.ProductMock;
import mock.TraderMock;

import pojo.Comment;
import pojo.Courier;
import pojo.Customer;
import pojo.Order;
import pojo.Product;
import pojo.Trader;

public class FileUtil {

	private FileUtil(){}
	
	public static ObjectOutputStream createOutStream(String url,String fileName) throws Exception{
		OutputStream out;
		out = new FileOutputStream(url +fileName);
		ObjectOutputStream oStream = new ObjectOutputStream(out);
		
		return oStream;
	}
	
	public static ObjectInputStream createInStream(String url,String fileName) throws Exception{
		return new ObjectInputStream(new FileInputStream(url  +fileName));
	}
	
	public static ArrayList<Comment> getComments() throws Exception{
		System.out.println("enter getComments");
		String url = PathMock.path;
		String fileName = "Comment.data";
		ArrayList<Comment> commentList = new ArrayList<Comment>();
		Comment str;
		System.out.println("comments:"+url+fileName);
		ObjectInputStream oin = FileUtil.createInStream(url, fileName);
		while (( str = (Comment)oin.readObject())!=null) {
			System.out.println("aaaa");
			commentList.add(str);
		}
		oin.close();
		return commentList;
	}
	
	public static ArrayList<Courier> getCouriers() throws Exception{
		String url = PathMock.path;
		System.out.println("getCouriers"+ url);
		String fileName = "Courier.data";
		ArrayList<Courier> courierList = new ArrayList<Courier>();
		Courier str;
		ObjectInputStream oin = FileUtil.createInStream(url, fileName);
		while (( str = (Courier)oin.readObject())!=null) {
			courierList.add(str);
			System.out.println(str);
		}
		oin.close();
		return courierList;
	}
	
	public static ArrayList<Order> getOrders() throws Exception{
		String url = PathMock.path;
		String fileName = "Order.data";
		ArrayList<Order> orderList = new ArrayList<Order>();
		Order str;
		ObjectInputStream oin = FileUtil.createInStream(url, fileName);
		while (( str = (Order)oin.readObject())!=null) {
			orderList.add(str);
			System.out.println(str);
		}
		oin.close();
		return orderList;
	}
	
	public static ArrayList<Product> getProducts() throws Exception{
		String url = PathMock.path;
		String fileName = "Product.data";
		ArrayList<Product> productList = new ArrayList<Product>();
		Product str;
		ObjectInputStream oin = FileUtil.createInStream(url, fileName);
		while (( str = (Product)oin.readObject())!=null) {
			productList.add(str);
			System.out.println(str);
		}
		oin.close();
		return productList;
	}
	
	public static ArrayList<Trader> getTraders() throws Exception{
		String url = PathMock.path;
		String fileName = "Order.data";
		ArrayList<Trader> traderList = new ArrayList<Trader>();
		Trader str;
		ObjectInputStream oin = FileUtil.createInStream(url, fileName);
		while (( str = (Trader)oin.readObject())!=null) {
			traderList.add(str);
			System.out.println(str);
		}
		oin.close();
		return traderList;
	}
	
	public static ArrayList<Customer> getCustomer() throws Exception{
		String url = PathMock.path;
		String fileName = "Customer.data";
		ArrayList<Customer> traderList = new ArrayList<Customer>();
		Customer str;
		ObjectInputStream oin = FileUtil.createInStream(url, fileName);
		System.out.println("enter getCustomer");
		while (( str = (Customer)oin.readObject())!=null) {
			traderList.add(str);
			System.out.println("getCustomer"+str);
		}
		oin.close();
		return traderList;
	}
	
	public static boolean putCustomer() throws Exception{
		String url = PathMock.path;
		String fileName = "Customer.data";
		ArrayList<Customer> customer;
		customer = CustomerMock.cuList;
		System.out.println("enter putCustomer");
		ObjectOutputStream oStream = FileUtil.createOutStream(url, fileName);
		for(Customer cu : customer){
			System.out.println("before put");
			oStream.writeObject(cu);
			System.out.println(cu.getCustomerName());
			oStream.flush();
		}
		oStream.close();
		return true;
	}
	
	public static boolean putComments() throws Exception{
		String url = PathMock.path;
		String fileName = "Comment.data";
		ArrayList<Comment> comments;
		comments = CommentMock.comList;
		
		ObjectOutputStream oStream = FileUtil.createOutStream(url, fileName);
		for(Comment comment : comments){
			System.out.println("before put");
			oStream.writeObject(comment);
			System.out.println("1"+ comment.getCid());
			oStream.flush();
		}
		oStream.close();
		return true;
	}
	
	public static boolean putCouriers() throws Exception{
		String url = PathMock.path;
		String fileName = "Courier.data";
		ArrayList<Courier> couriers;
		couriers = CourierMock.colist;
		System.out.println(url+ fileName);
		ObjectOutputStream oStream = FileUtil.createOutStream(url, fileName);
		for(Courier courier : couriers){
			oStream.writeObject(courier);
		}
		oStream.close();
		return true;
	}
	
	public static boolean putOrders() throws Exception{
		String url = PathMock.path;
		String fileName = "Order.data";
		ArrayList<Order> orders;
		orders = OrderMock.orlist;
		ObjectOutputStream oStream = FileUtil.createOutStream(url, fileName);
		for(Order order : orders){
			oStream.writeObject(order);
		}
		oStream.close();
		return true;
	}
	
	public static boolean putProducts() throws Exception{
		String url = PathMock.path;
		String fileName = "Product.data";
		ArrayList<Product> products ;
		products = ProductMock.prolist;
		ObjectOutputStream oStream = FileUtil.createOutStream(url, fileName);
		for(Product product : products){
			oStream.writeObject(product);
		}
		oStream.close();
		return true;
	}
	
	public static boolean putTraders() throws Exception{
		String url = PathMock.path;
		String fileName = "Trader.data";
		ArrayList<Trader> traders ;
		traders = TraderMock.trlist;
		ObjectOutputStream oStream = FileUtil.createOutStream(url, fileName);
		for(Trader trader : traders){
			oStream.writeObject(trader);
		}
		oStream.close();
		return true;
	}
}
