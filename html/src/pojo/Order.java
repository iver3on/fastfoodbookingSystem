package pojo;

import java.util.ArrayList;
import java.util.Date;

public class Order {
	private int id;
	private int tid;
	private Date createTime;
	private Date sendTime;
	private Date finishTime;
	private int courierId;
	private ArrayList<Integer> pro;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public int getCourierId() {
		return courierId;
	}
	public void setCourierId(int courierId) {
		this.courierId = courierId;
	}
	public ArrayList<Integer> getPro() {
		return pro;
	}
	public void setPro(ArrayList<Integer> pro) {
		this.pro = pro;
	}
	
}
