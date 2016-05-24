package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import pojo.Customer;
import service.impl.CustomerServiceImpl;

public class CustomerAction {

	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private static CustomerServiceImpl csi = new CustomerServiceImpl();

	public String login() {
		Customer cus = csi.login(customer);
		if (cus != null) {
			session.setAttribute("loginCustomer", cus);
			request.setAttribute("loginsuc", "您已成功登录！");
			return "success";
		} else {
			request.setAttribute("loginerror", "登录失败。。");
			return "fail";
		}
	}

	public String regist() {

		boolean f = csi.regist(customer);
		System.out.println(customer.getCustomerName());
		if (f) {
			request.setAttribute("regsuc", "恭喜您，您已成功注册！！");
			return "success";

		} else {
			request.setAttribute("regerror", "注册失败！！");
			return "fail";

		}
	}

	public String delCustomer() {

		int m = csi.delCustomer(customer);
		if (m == 1)
			return "success";
		else {
			return "fail";
		}
	}

	public String findUserById() {
		Customer cus = csi.findUserById(id);
		if (cus != null) {
			ActionContext.getContext().put("customers", cus);
			return "success";
		} else {
			return "fail";
		}
	}

	public String updateCustomer() {
		Customer cus = csi.updateCustomer(customer);
		if (cus != null) {
			return "success";
		}
		return "fail";
	}

}
