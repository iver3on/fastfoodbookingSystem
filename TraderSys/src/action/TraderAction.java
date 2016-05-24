package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import pojo.Trader;
import com.opensymphony.xwork2.ActionSupport;
import service.TraderService;

public class TraderAction extends ActionSupport {

	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();

	TraderService tds = new TraderService();
	Trader trader;
	private String pwd2;

	public String getPwd2() {
		return pwd2;
	}

	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}

	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}

	public void validateRegiste() {
		System.out.println("enter validate!");
		System.out.println(trader.getName());
		if (trader.getName().trim() == null || trader.getName().trim().equals("")) {
			addFieldError("uname", getText("unameError"));
		}
		if (trader.getPassword().trim() == null || trader.getPassword().equals("")) {
			addFieldError("pwdNull", getText("pwdNull"));
		}
		if (!trader.getPassword().equals(pwd2)) {
			addFieldError("pwd2", getText("pwdError"));
		}
		if (trader.getLicenseId() == 0) {
			addFieldError("license", getText("liceseError"));
		}
		if (trader.getLogo() == null) {
			addFieldError("logo", getText("logoError"));
		}
	}

	public String registe() throws Exception {

		if (tds.tryaddTrader(trader)) {
			request.setAttribute("regsuc", "reg success");
			return SUCCESS;
		}
		request.setAttribute("regerror", "false");
		return "false";

	}

	public String login() {

		if (tds.trylogin(trader)) {
			session.setAttribute("LoginTrader", trader);
			request.setAttribute("loginsuc", "success");
			return "success";
		}
		request.setAttribute("loginerror", "false");
		return "false";

	}
	public String goRegist(){
		System.out.println("enter go~");
		return SUCCESS;
	}
}
