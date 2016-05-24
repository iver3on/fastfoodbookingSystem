package action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import util.ImgCreator;

public class AutoCodeAction {
	private HttpServletResponse response = ServletActionContext.getResponse();  
    private HttpServletRequest request = ServletActionContext.getRequest();  

	public String  AutoCode() {
	ImgCreator imgCreator = new ImgCreator();
	String text = imgCreator.createRandomText();
	try {
		imgCreator.responseImg(text, response.getOutputStream());
		request.getSession().setAttribute("text", text);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	}
	
}
