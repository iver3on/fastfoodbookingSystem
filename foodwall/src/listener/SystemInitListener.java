package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import util.FileUtil;

import com.sun.org.apache.xml.internal.serializer.utils.Utils;

import cloudshow.FoodWall;

public class SystemInitListener implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent sce) {
		
			/*try {
				FileUtil.putTraders();
				FileUtil.putCustomers();
				FileUtil.putOrders();
				FileUtil.putProducts();
			} catch (Exception e) {
				System.out.println("Data save error.....");
				e.printStackTrace();
			}*/
			
		
		
	}

	public void contextInitialized(ServletContextEvent sce) {
		/*try {
			FoodWall.setTraders(FileUtil.getTraders());
			FoodWall.setCoustomers(FileUtil.getCustomers());
			FoodWall.setOrders(FileUtil.getOrders());
			FoodWall.setProducts(FileUtil.getProducts());
		} catch (Exception e) {
			System.out.println("Data init error....");
			e.printStackTrace();
		}*/
		
	}
	

}
