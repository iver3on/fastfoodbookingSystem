package service.impl;



import org.apache.commons.lang.StringUtils;

import mock.ProductMock;
import net.sf.json.JSONObject;
import java.util.*;
import pojo.Customer;
import pojo.Obview;
import service.ObviewService;
import util.PostRequest;

public class ObviewServiceImpl implements ObviewService{
	public List<Obview> getObviewList(Customer c) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("cid", String.valueOf(c.getCustomerId()));
		
		//跨系统请求
		String list =  PostRequest.postHttpReqest("http://192.168.0.196:8888/foodwall/listItems.action", params);
		
		if(!StringUtils.isEmpty(list)){
			JSONObject jsonObject = JSONObject.fromObject(list);
			List<Integer> plist = (List<Integer>)jsonObject.toBean(jsonObject);
			List<Obview> obviews = new ArrayList<Obview>();
			for (int i = 0; i < plist.size(); i++) {
				obviews.add(findObviewById(plist.get(i)));
			}
			return obviews;
		}
		return null;
	}
	/**
	 * ID PROid
	 */
	public Obview findObviewById(Integer id) {
		return null;
	}
	
}
