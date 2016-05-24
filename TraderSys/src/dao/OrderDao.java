package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import mock.OrderMock;

import pojo.Order;

;

public class OrderDao {
	private static ArrayList<Order> orders = new ArrayList<Order>();

	public static ArrayList<Order> getOrders() {
		return orders;
	}

	public static void setOrders(ArrayList<Order> orders) {
		OrderDao.orders = orders;
	}

	/**
	 * 添加Order
	 * 
	 * @param order
	 * @return
	 */
	public boolean addOrder(Order order) {
		boolean flag = true;
		OrderMock.orlist.add(order);
		return flag;
	}

	/**
	 * 编辑Order
	 * 
	 * @param order
	 * @return
	 */
	public boolean editOrder(Order order) {
		boolean flag = false;

		for (Order o : OrderMock.orlist) {
			if (o.getId() == order.getId()) {
				o = order;
				flag = true;
			}
		}
		return flag;
	}

	public static String getSubmitTime() {
		String submittime = null;
		Calendar cal1 = Calendar.getInstance();
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8:00"));
		java.text.SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy-MM-dd kk:mm:ss");
		submittime = sdf.format(cal1.getTime());
		// System.out.println(sdf.format(cal1.getTime()));
		return submittime;
	}
}
