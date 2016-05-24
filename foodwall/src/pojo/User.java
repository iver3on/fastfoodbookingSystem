package pojo;


import java.util.HashMap;
import java.util.Map;
import java.io.Serializable;
public class User implements Serializable{
	private Integer id;
	private Map<Integer,Integer> faver=new HashMap<Integer, Integer>();//口味等级
	private int mostFavaer=0;
	public int getMostFavaer() {
		return mostFavaer;
	}
	public void setMostFavaer(int mostFavaer) {
		this.mostFavaer = mostFavaer;
	}
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


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

}
