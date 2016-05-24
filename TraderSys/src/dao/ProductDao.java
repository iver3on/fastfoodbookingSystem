package dao;

import java.util.ArrayList;

import pojo.Comment;
import pojo.Product;

;

public class ProductDao {
	private static ArrayList<Product> products = new ArrayList<Product>();

	public static ArrayList<Product> getProducts() {
		return products;
	}

	public static void setProducts(ArrayList<Product> products) {
		ProductDao.products = products;
	}

	public void addPro(Product pro) {
		products.add(pro);
	}

	public void updatePro(Product pro) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getPid() == pro.getPid()) {
				products.remove(i);
				products.add(pro);
			}
		}
	}

	public void deletePro(Product pro) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getPid() == pro.getPid()) {
				products.remove(i);
			}
		}
	}

	public ArrayList<Comment> getComments(int pid) {
		ArrayList<Comment> ac = null;
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getPid() == pid) {
				ac = products.get(i).getComment();
			}
		}
		return ac;
	}

	public Product findById(int pid) {
		Product p = null;
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getPid() == pid) {
				p = products.get(i);
			}
		}
		return p;
	}
}
