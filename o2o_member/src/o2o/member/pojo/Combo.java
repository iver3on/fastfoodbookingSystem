package o2o.member.pojo;

import java.util.ArrayList;
import java.util.List;

public class Combo extends Food {
	
	private List<Snack> snacks=new ArrayList<Snack>();
	private List<Drink> drinks=new ArrayList<Drink>();
	private List<SideItem> sideItems=new ArrayList<SideItem>();
	public List<Snack> getSnacks() {
		return snacks;
	}
	public void setSnacks(List<Snack> snacks) {
		this.snacks = snacks;
	}
	public List<Drink> getDrinks() {
		return drinks;
	}
	public void setDrinks(List<Drink> drinks) {
		this.drinks = drinks;
	}
	public List<SideItem> getSideItems() {
		return sideItems;
	}
	public void setSideItems(List<SideItem> sideItems) {
		this.sideItems = sideItems;
	}
	
	
}
