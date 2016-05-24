package action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import pojo.Trader;

import service.ImgService;
import service.TraderService;

import com.opensymphony.xwork2.ActionSupport;

public class PortraitChangeAction extends ActionSupport {
	private File uploadImage; // 娑撳﹣绱堕惃鍕瀮娴狅拷	
	private String uploadImageContentType; //娑撳﹣绱堕弬鍥︽閻ㄥ嫮琚崹锟�
	private String uploadImageFileName; // 娑撳﹣绱堕弬鍥︽閻ㄥ嫬鎮曠粔锟�
	TraderService tds = new TraderService();

	public File getUploadImage() {
		return uploadImage;
	}

	public void setUploadImage(File uploadImage) {
		this.uploadImage = uploadImage;
	}

	public String getUploadImageContentType() {
		return uploadImageContentType;
	}

	public void setUploadImageContentType(String uploadImageContentType) {
		this.uploadImageContentType = uploadImageContentType;
	}

	public String getUploadImageFileName() {
		return uploadImageFileName;
	}

	public void setUploadImageFileName(String uploadImageFileName) {
		this.uploadImageFileName = uploadImageFileName;
	}

	public String execute() {

		String realpath = ServletActionContext.getServletContext().getRealPath(
				"/portrait");
		File file = new File(realpath);
		if (!file.exists())
			file.mkdirs();
		String fileName = ImgService
				.getPortraitName(uploadImageFileName);
		try {
			FileUtils.copyFile(uploadImage, new File(file, fileName));
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			Trader trader = (Trader) session.getAttribute("LoginTrader");
			File delFile = new File(trader.getLogo());
			delFile.delete();
			trader.setLogo("portrait/" + fileName);
			tds.tryupdate(trader);
			session.setAttribute("LoginTrader", trader);
		} catch (Exception e) {
		}

		return SUCCESS;
	}
}
