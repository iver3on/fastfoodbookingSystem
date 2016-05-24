package action;

import pojo.Customer;
import service.ObviewService;
import service.impl.ObviewServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowItemsAction extends ActionSupport{
	private int cid;
	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String showitems(){
		ObviewService obviewService = new ObviewServiceImpl();
		
		Customer c = new Customer();
		c.setCustomerId(cid);
		ActionContext.getContext().put("items",obviewService.getObviewList(c));
		return SUCCESS;
	}

}
