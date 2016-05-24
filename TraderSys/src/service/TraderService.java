package service;

import java.util.HashMap;
import java.util.Map;

import mock.PathMock;

import org.apache.taglibs.standard.extra.spath.Path;

import pojo.Trader;
import util.PostRequest;
import dao.TraderDao;

public class TraderService {

	public boolean tryaddTrader(Trader trader) {
		try {
			if (TraderDao.adduser(trader)) {
				String url="";
				PostRequest.postHttpReqest(url, trader, "trader");
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public boolean trylogin(Trader trader) {

		try {
			if (TraderDao.login(trader)) {
				return true;

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	/**
	 * 更新trader信息，并且告诉另一个服务器
	 * @param trader
	 * @throws Exception 
	 */
	public void tryupdate(Trader trader) throws Exception{
		
		TraderDao.updatePerInfo(trader);
		
		String url="";
		PostRequest.postHttpReqest(url, trader, "trader");
	}
	
}
