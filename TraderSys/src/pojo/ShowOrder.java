package pojo;

import java.util.ArrayList;

public class ShowOrder {

	private ArrayList<Product> prolist;
	private float totalPrice;
	
	public ArrayList<Product> getProlist() {
		return prolist;
	}
	public void setProlist(ArrayList<Product> prolist) {
		this.prolist = prolist;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
}
