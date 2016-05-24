package action;

import cloudshow.FoodWall;
import pojo.Order;

public class NewOrder {
	private Order order;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	public void getneworder() {
		FoodWall.countcustomerfaver(order);
	}

}
