package cloudUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pojo.Order;
import pojo.OrderItem;
import pojo.Shop;
import pojo.User;

public class UserUtil {

	/**
	 * 
	 * @param order
	 *            订单
	 * @param orderItem
	 *            具体订单信息
	 * @param users
	 *            内存中存储的登录用户 通过新完成的订单统计用户口味
	 */

	public static void count_grade(Order order, OrderItem orderItem,
			Set<User> users) {
		User user = order.getUser();
		int key = orderItem.getItem().getGrade();
		Map<Integer, Integer> map = user.getFaver();
		map.put(key, map.get(key) + orderItem.getCount());
		for (User temp : users) {
			if (temp.getUsername().equals(user.getUsername())) {
				temp.setFaver(map);
			}
		}
	}

	/**
	 * 
	 * @param user
	 *            传入一个用户user
	 * @return 返回用户所处位置
	 */
	public static int cal_location(User user) {

		return 0;
	}

	/**
	 * 
	 * @param shops
	 *            传入一个商家集合Set<Shop> 对商家进行排名
	 * @return 返回一个List<Shop>集合
	 */
	public static List<Shop> shop_rank(Set<Shop> shops) {
		List<Shop> listShops = new ArrayList<Shop>();
		for (Shop temp : shops) {
			int rankbase = temp.getTotalCount() * 50 + temp.getContribution()* 50;
			temp.setRankbase(rankbase);
			listShops.add(temp);
		}
		Collections.sort(listShops, new Comparator<Shop>() {
			public int compare(Shop arg0, Shop arg1) {
				if (arg0.getRankbase() > arg1.getRankbase())
					return 1;
				else {
					return -1;
				}
			}
		});
		return listShops;
	}
}
