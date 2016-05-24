package action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pojo.JSOrder;
import pojo.Order;
import pojo.Product;
import util.PostRequest;

import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport{
	private static Order order;
	private String courierId;
	private List<Product> products;
	 //private Date createTime;
	
	public String getCourierId() {
		return courierId;
	}

	public void setCourierId(String courierId) {
		this.courierId = courierId;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	/*public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}*/

	private Object params;
	
	
	public Object getParams() {
		return params;
	}

	public void setParams(Object params) {
		this.params = params;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void putOrdertoTrader(){
		try {
			PostRequest.postHttpReqest("http://192.168.0.202:8888/TraderSys/addOrder.action",order,"o");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getOrderForm(){
		System.out.println("enter");
		System.out.println(courierId);
		order.setCourierId(Integer.parseInt(courierId));
		ArrayList<Integer> list=order.getPro();
		for(Product temp:products){
			list.add(temp.getPid());
		}
		/*ArrayList<Product> list = new ArrayList<Product>();
		list = order.getProducts();
		System.out.println(order);
		for(Product product : list){
			
			System.out.println(product.getProName());
		}*/
		return SUCCESS;
	}
}
