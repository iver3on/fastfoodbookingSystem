package action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.apache.commons.fileupload.FileUpload;

import pojo.Customer;
import pojo.Trader;

import servlet.TraderShow;
import util.FileUtil;

import cloudshow.FoodWall;
public class FileTrans {
	private File[] upload;
	private String[] uploadFileName;
	//private FileUpload fileUpload;
	
		
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
		if(upload==null){
			System.out.println("no files....");
			return;
		} 
	

		for(int i=0;i<upload.length;i++){
			try {
				ObjectInputStream is = null;
				is = new ObjectInputStream(new FileInputStream(upload[i].getAbsolutePath()));
				String filename = uploadFileName[i];
				System.out.println(filename);

				if(filename.equals("Product.data")){
					try {
						FoodWall.setProducts(FileUtil.getProducts(is));
						System.out.println(FoodWall.getProducts().getClass().getName());
						is.close();
					} catch (Exception e) {
						is.close();
						e.printStackTrace();
					}
				}
				if(filename.equals("Trader.data")){
					try {
						FoodWall.setTraders(FileUtil.getTraders(is));
						FoodWall.rankTraders();
						is.close();
					} catch (Exception e) {
						is.close();
						e.printStackTrace();
					}
				}
				if(filename.equals("Order.data")){
					try {
						FoodWall.setOrders(FileUtil.getOrders(is));
						is.close();
					} catch (Exception e) {
						is.close();
						e.printStackTrace();
					}
				}
				if(filename.equals("Customer.data")){
					try {
						System.out.println(FoodWall.getCoustomers().isEmpty());
						FoodWall.setCustomers(FileUtil.getCustomers(is));
						is.close();
						System.out.println(FoodWall.getCoustomers().isEmpty());
					} catch (Exception e) {
						is.close();
						e.printStackTrace();
					}
				}
					
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}



