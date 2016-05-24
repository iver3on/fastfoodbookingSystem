package action;

import cloudshow.FoodWall;
import pojo.Product;

public class ProductUpdata {
	private Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public void deleteproduct(){
		FoodWall.getProducts().remove(product);
	}
	public void addproduct() {
		FoodWall.getProducts().add(product);
	}
	public void updataproduct(){
		for(Product temp:FoodWall.getProducts()){
			if(temp.getPid()==product.getPid()){
				FoodWall.getProducts().remove(temp);
				FoodWall.getProducts().add(product);
				return;
			}
		}
	}
}
