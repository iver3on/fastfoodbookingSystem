package pojo;
import java.io.Serializable;
public class Courier implements Serializable{
	private int courier;
	private String name;
	
	public int getCourier() {
		return courier;
	}
	public void setCourier(int courier) {
		this.courier = courier;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
