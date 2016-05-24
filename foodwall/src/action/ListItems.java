package action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;


import cloudshow.FoodWall;

public class ListItems extends ActionSupport{
	private int cid;
	private InputStream info;
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}
	public String listitems() {
		int tid=13579;
		int items[]=FoodWall.listproductbyuidandtid(cid, tid);
		String result = "";
		for (int i = 0; i < items.length; i++) {
			result += items[i] + ",";
		}
		info = new ByteArrayInputStream(result.substring(0,result.length() - 1).getBytes());
		System.out.println(info);
		return SUCCESS;
	}

}
