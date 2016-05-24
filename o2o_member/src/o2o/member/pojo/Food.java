package o2o.member.pojo;

import java.io.Serializable;

public class Food implements Serializable{
	public static final int NONE=0;
	public static final int CHUANCAI=1;
	public static final int XICAN=2;
	public static final int CHANGHAICAI=3;
	
	
	private Integer id;
	private String foodName;
	private double price;
	private Trader trader;
	private byte[] sanpshot;
	private int category=NONE;
	
	
	public Food() {
		super();
	}
	public Food(Integer id, String foodName, double price) {
		super();
		this.id = id;
		this.foodName = foodName;
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Trader getTrader() {
		return trader;
	}
	public void setTrader(Trader trader) {
		this.trader = trader;
	}
	public byte[] getSanpshot() {
		return sanpshot;
	}
	public void setSanpshot(byte[] sanpshot) {
		this.sanpshot = sanpshot;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public static int getNone() {
		return NONE;
	}
	public static int getChuancai() {
		return CHUANCAI;
	}
	public static int getXican() {
		return XICAN;
	}
	public static int getChanghaicai() {
		return CHANGHAICAI;
	}
	
}
