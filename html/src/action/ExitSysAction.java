package action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;



public class ExitSysAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	public String execute() {
		HttpServletRequest request = ServletActionContext.getRequest();

		HttpSession session = request.getSession();

		session.removeAttribute("loginCustomer");
		return SUCCESS;
	}
}

