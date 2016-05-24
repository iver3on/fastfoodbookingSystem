package cloudshow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import java.util.Set;

import com.sun.org.apache.xml.internal.serializer.utils.Utils;



import pojo.Order;
import pojo.Product;
import pojo.Trader;
import pojo.Customer;

;

public class FoodWall {

	private static Set<Product> products = new HashSet<Product>();
	private static Set<Customer> users = new HashSet<Customer>();
	private static Set<Order> orders = new HashSet<Order>();
	private static List<Trader> rankList = new ArrayList<Trader>();// 商家排名

	private static Set<Trader> traders;

	public static Set<Trader> getTraders() {
		return traders;
	}

	public static void setTraders(Set<Trader> traders) {
		FoodWall.traders = traders;
	}

	public static Set<Product> getProducts() {
		return products;
	}

	public static void setProducts(Set<Product> products) {
		FoodWall.products = products;
	}

	public static Set<Customer> getCoustomers() {
		return users;
	}

	public static void setCustomers(Set<Customer> users) {
		FoodWall.users = users;
	}

	public static Set<Order> getOrders() {
		return orders;
	}

	public static void setOrders(Set<Order> orders) {
		FoodWall.orders = orders;
	}

	public static List<Trader> getRankList() {
		return rankList;
	}

	public static void setRankList(List<Trader> rankList) {
		FoodWall.rankList = rankList;
	}

	/**
	 * 閫氳繃鐢ㄦ埛Id鏌ヨ鐢ㄦ埛鐩稿悓鍠滃ソ鐨勫簵閾洪泦
	 * 
	 * @param uid
	 *            鐢ㄦ埛ID
	 * @return 涓�釜鎺掑簭濂界殑鍟嗗簵ID 鏁扮粍
	 */
	public static int[] listTradersByuid(String uid) {
		Customer user = util.Utils.finduserbyid(uid, users);
		int[] traderlist = new int[rankList.size()];
		Map<Integer, Integer> userfaver = user.getFaver();
		if(userfaver.size()==0){
			for(int i=0;i<rankList.size();i++){
				traderlist[i]=rankList.get(i).getTid();
			}
			return traderlist;
		}
		int i=0;
		while(i<rankList.size()){
			for (Trader temp : rankList) {
				if (temp.getMostFaver() == userfaver.get(i)) {
					traderlist[i++] = temp.getTid();
				}
			}
		}
		return traderlist;
	}

	/**
	 * 
	 * @param order
	 *            璁㈠崟
	 * @param orderItem
	 *            鍏蜂綋璁㈠崟淇℃伅
	 * @param users
	 *            鍐呭瓨涓瓨鍌ㄧ殑鐧诲綍鐢ㄦ埛 閫氳繃鏂板畬鎴愮殑璁㈠崟缁熻鐢ㄦ埛鍙ｅ懗
	 */

	public static void countcustomerfaver(Order order) {
		Customer user = util.Utils.finduserbyorder(order, users);
		if (user == null)
			return;
		
		ArrayList<Product> orderfood = (ArrayList<Product>) util.Utils.findproductsbypids(order.getPro());
		Map<Integer, Integer> map = user.getFaver();
		for (Product product : orderfood) {
			int key = product.getType();
			map.put(key, map.get(key) + 1);
		}
		users.remove(util.Utils.finduserbyorder(order, users));
		users.add(user);
	}

	/**
	 * 缁熻鍑虹敤鎴锋渶鍠滅埍鐨勫彛鍛�
	 * 
	 * @param user
	 */

	public static void countusermostfaver(Customer user) {
		Map<Integer, Integer> map = user.getFaver();
		if (map.size() == 0)
			return;
		int mostFaver = 0;
		for (int i = 1; i < map.size(); i++) {
			if (map.get(i) > map.get(mostFaver)) {
				mostFaver = i;
			}
		}
		user.setMostFaver(mostFaver);
	}

	/**
	 * 缁熻搴楅摵鐗硅壊鍙ｅ懗
	 * 
	 * @param trader
	 */

	public static void counttradermostfaver(Trader trader) {
		Map<Integer, Integer> map = trader.getFaver();
		int mostFaver = 0;
		for (int i = 1; i < map.size(); i++) {
			if (map.get(i) > map.get(mostFaver)) {
				mostFaver = i;
			}
		}
		trader.setMostFaver(mostFaver);
	}

	/**
	 * 
	 * 瀵瑰晢瀹惰繘琛屾帓鍚�Ranking楂樼殑鍦ㄥ墠闈�
	 * 
	 */
	@SuppressWarnings("null")
	public static void rankTraders() {
		if (traders.size() == 0)
			return;
		List<Trader> rankList1 = null;
		rankList1.addAll(traders);
		Collections.sort(rankList1, new Comparator<Trader>() {
			public int compare(Trader arg0, Trader arg1) {
				if (arg0.getRanking() > arg1.getRanking())
					return -1;
				else {
					return 1;
				}
			}
		});
		rankList = rankList1;
		FoodWall.countTraderFaver();
		for(Trader trader:traders){
		FoodWall.counttradermostfaver(trader);
		}
	}

	/**
	 * 浼犻�涓�釜user瀵瑰叾璁㈣繃鐨勫彛鍛虫寜鐓ф暟閲忚繘琛屾帓搴�USER 鐨刴ap
	 * 
	 * @param user
	 * 
	 */
	public static void rankUserFavor(Customer user) {
		Map<Integer, Integer> map = user.getFaver();
		if (map.size() == 0)
			return;
		//int list[] = new int[map.size()];
		List<Map.Entry<Integer, Integer>> entryLists = new ArrayList<Map.Entry<Integer, Integer>>(
				map.entrySet());
		Collections.sort(entryLists, new EntryComparator());
		user.setFaver(map);

	}

	public static class EntryComparator implements
			Comparator<Map.Entry<Integer, Integer>> {// value鍒楄〃椤哄簭鐨勬瘮杈冨櫒
		public int compare(Map.Entry<Integer, Integer> map1,
				Map.Entry<Integer, Integer> map2) {// 閲嶅啓compare鏂规硶
			// return map1.getValue() - map2.getValue(); // 鍗囧簭鎺掑垪
			return map2.getValue() - map1.getValue();// 闄嶅簭鎺掑垪
		}
	}

	/**
	 * 
	 * @param uid 用户ID
	 * @param tid	商家ID
	 * 用户点击进入商家后，根据用户爱好对食品进行排序
	 * @return	返回该商家所有商品根据用户口味的一个排序。int[]中存放商品id号码。
	 */
	public static int[] listproductbyuidandtid(Integer uid, Integer tid) {
		Trader tra = new Trader();
		Customer cus = new Customer();

		for (Customer customer : users) {
			if (customer.getCustomerId() == uid)
				cus = customer;
		}
		for (Trader trader : traders) {
			if (trader.getTid() == tid) {
				tra = trader;
			}
		}

		int n[] = new int[tra.getPids().size()];
		int s;
		Map<Integer, Integer> faver = cus.getFaver();
		if(faver.size()==0){
			for(int i=0;i<tra.getPids().size();i++){
				n[i]=tra.getPids().get(i).getPid();
			}
			return n;
		}
		int i=0;
		while(i<tra.getPids().size()){
			s = faver.get(i);
			for (int j = 0; j < tra.getPids().size(); j++) {
				Product pro = tra.getPids().get(j);
				if(pro.getType() ==s){
					n[i++] = pro.getPid();
				}
			}
		}
		return n;
	}
	
	/**
	 * 对商家所有商品种类进行统计，至于trader的faver中。
	 */
	public static void countTraderFaver() {
		for(Trader trader:traders){
			Map<Integer, Integer> map = trader.getFaver();
			for(Product product:trader.getPids()){
				int i = product.getType();
				map.put(i, map.get(i)+1);
			}
		}
	}
	/**
	 * 根据商品类型对商家faver进行排序。
	 * trader 用户商家
	 */
	public static void rankTraderFavor(Trader trader) {
		Map<Integer, Integer> map = trader.getFaver();
		if (map.size() == 0)
			return;
		List<Map.Entry<Integer, Integer>> entryLists = new ArrayList<Map.Entry<Integer, Integer>>(
				map.entrySet());
		Collections.sort(entryLists, new EntryComparator());
		trader.setFaver(map);

	}


	
}
