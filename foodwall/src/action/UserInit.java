package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import cloudshow.FoodWall;

import util.FileUtil;

public class UserInit {
	private File file;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	public void userinit(){
		if(file==null){
			System.out.println("no files....");
			return;
		}
	 ObjectInputStream is = null;
	 	try {
			is = new ObjectInputStream(new FileInputStream(file.getAbsolutePath()));
			String filename = file.getName();
			System.out.println(filename);
			try {
				FoodWall.setCustomers(FileUtil.getCustomers(is));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
