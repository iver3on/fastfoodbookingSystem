package action;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mock.NewOrderMock;
import mock.Trans;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import pojo.Order;
import pojo.Product;
import pojo.ShowOrder;

import service.OrderService;
import util.PostRequest;

public class OrderAction extends ActionSupport {

	OrderService os = new OrderService();
	Order o;

	

	public Order getO() {
		return o;
	}

	public void setO(Order o) {
		this.o = o;
	}

	
	public String addOrder() throws Exception{
		
		os.addOrder(o);
		
		ShowOrder showorder = new ShowOrder();
		ArrayList<Product> prolist = new ArrayList<Product>();
		
		for(Integer pid : o.getPro()){
			prolist.add(os.findProById(pid));
		}
		
		showorder.setProlist(prolist);
		showorder.setTotalPrice(os.getTotalPrice(prolist));
		NewOrderMock.orderList.add(showorder);
		
		return SUCCESS;
	}
	
	public String showOrder(){
		ActionContext.getContext().put("orders",NewOrderMock.orderList);
		return SUCCESS;
	}
}