package pojo;

import java.util.Map;

/**
 * 餐名
 * @author Administrator
 *
 */
public class Item {
	private Integer id;
	private String name;
	private float price;
	private String imgs;//图片路径，多张图片中间用;隔开
	private int delayMins;//需等待分钟数
	private Shop shop;
	private int grade;//餐品口味等级1-5
	
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getImgs() {
		return imgs;
	}
	public void setImgs(String imgs) {
		this.imgs = imgs;
	}
	public int getDelayMins() {
		return delayMins;
	}
	public void setDelayMins(int delayMins) {
		this.delayMins = delayMins;
	}
}
