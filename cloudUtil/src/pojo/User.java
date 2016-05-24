package pojo;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class User {
	private Integer id;
	private String username;
	private String password;	
	private String mobilePhone;
	private Integer	usertype;
	private Map<Integer,Integer> faver=new HashMap<Integer, Integer>();//口味等级1-5
	private String ip;
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Map<Integer, Integer> getFaver() {
		return faver;
	}
	public void setFaver(Map<Integer, Integer> faver) {
		this.faver = faver;
	}

	public Integer getUsertype() {
		return usertype;
	}
	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
}
