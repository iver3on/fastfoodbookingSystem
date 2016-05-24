package pojo;

import java.util.Date;
import java.util.Set;

import javax.management.loading.PrivateClassLoader;

/**
 * 订单类
 * @author Administrator
 *
 */
public class Order {
	private Integer id;
	private User user;
	private Shop shop;//店铺
	private float totalPrice;//总价格
	private Date date;//订单时间
	private int totalCount;//订单数量
	private String address;//取餐人地址
	private String telephone;//取餐人电话 
	private int status;//0待配送，1、配送完成，2、退订
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	
}
