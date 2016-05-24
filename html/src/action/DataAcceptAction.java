package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import mock.CustomerMock;
import mock.OrderMock;
import mock.ProductMock;
import mock.TraderMock;

import org.apache.commons.fileupload.FileUpload;

import com.opensymphony.xwork2.ActionSupport;

import pojo.Customer;
import pojo.Trader;

import util.FileUtil;

public class DataAcceptAction extends ActionSupport {
	private File[] upload;
	private String[] uploadFileName;

	// private FileUpload fileUpload;

	public File[] getUpload() {
		return upload;
	}

	public void setUpload(File[] upload) {
		this.upload = upload;
	}

	public String[] getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void filetrans() {
		if (upload == null) {
			System.out.println("no files....");
			return;
		}
		ObjectInputStream is = null;

		for (int i = 0; i < upload.length; i++) {
			try {
				is = new ObjectInputStream(new FileInputStream(
						upload[i].getAbsolutePath()));
				String filename = uploadFileName[i];
				System.out.println(filename);

				if (filename.equals("Product.data")) {
					try {
						ProductMock.trList = FileUtil.getProducts(is);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (filename.equals("Trader.data")) {
					try {
						TraderMock.trList = FileUtil.getTraders(is);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (filename.equals("Order.data")) {
					try {
						OrderMock.trlist = FileUtil.getOrders(is);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (filename.equals("Customer.data")) {
					try {
						CustomerMock.trlist = FileUtil.getCustomers(is);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		try {
			is.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
