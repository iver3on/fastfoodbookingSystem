package pojo;

import java.util.ArrayList;
import java.util.Map;


public class Trader {
	private int tid;
	private ArrayList<Product> pids;
	private String name;
	private String logo;
	private int licenseId;
	private String address;
	private String openingTime;
	private String creditEvalution;//信用评估
	private int ranking;//注册基金，不收毛票
	private String password;
	private Map<Integer,Integer> faver;
	private int mostFaver=0;
	
	
	public int getMostFaver() {
		return mostFaver;
	}

	public void setMostFaver(int mostFaver) {
		this.mostFaver = mostFaver;
	}

	public void setFaver(Map<Integer, Integer> faver) {
		this.faver = faver;
	}

	public Map<Integer, Integer> getFaver() {
		return faver;
	}

	public void setFever(Map<Integer, Integer> faver) {
		this.faver = faver;
	}
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public int getTid() {
		return tid;
	}
	
	public void setTid(int tid) {
		this.tid = tid;
	}
	

	
	public ArrayList<Product> getPids() {
		return pids;
	}

	public void setPids(ArrayList<Product> pids) {
		this.pids = pids;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLogo() {
		return logo;
	}
	
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	public int getLicenseId() {
		return licenseId;
	}
	
	public void setLicenseId(int licenseId) {
		this.licenseId = licenseId;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getOpeningTime() {
		return openingTime;
	}
	public void setOpeningTime(String openingTime) {
		this.openingTime = openingTime;
	}
	
	public String getCreditEvalution() {
		return creditEvalution;
	}
	
	public void setCreditEvalution(String creditEvalution) {
		this.creditEvalution = creditEvalution;
	}
	
}
