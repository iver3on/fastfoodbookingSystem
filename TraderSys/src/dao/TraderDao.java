package dao;

import java.util.ArrayList;

import mock.TraderMock;

import pojo.Trader;

/**
 * @author zwb
 *
 */
public class TraderDao {
	private static ArrayList<Trader> traders = new ArrayList<Trader>();

	public static ArrayList<Trader> getTraders() {
		return traders;
	}

	public static void setTraders(ArrayList<Trader> traders) {
		TraderDao.traders = traders;
	}
	
//判断注册卖家是否可以存入list
	public static boolean adduser(Trader regTrader) throws Exception {
		
		traders = TraderMock.trlist;
		if (regTrader != null) {
			for (Trader temp : traders) {
				if (temp.getName().equals(regTrader.getName())) {
					return false;
				}
			}
		}
		traders.add(regTrader);
		return true;
	}

//判断登录卖家是否可以登录
	public static boolean login(Trader logTrader) throws Exception {
		traders = TraderMock.trlist;
		if (logTrader != null) {
			for (Trader temp : traders) {
				if (temp.getName().equals(logTrader.getName())
						&& temp.getPassword().equals(logTrader.getPassword())) {
					return true;
				}
			}
		}
		return false;
	}

//从list里边移除旧的卖家，将更新后的卖家存入List.
	public static boolean updatePerInfo(Trader logTrader) {

		traders = TraderMock.trlist;
		if (logTrader != null) {
			for (Trader temp : traders) {
				if (temp.getTid() == logTrader.getTid()) {
					traders.remove(temp);
					traders.add(logTrader);
					break;
				}
			}
		}
		return true;

	}
}
