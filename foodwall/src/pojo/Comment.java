package pojo;

import java.io.Serializable;

public class Comment implements Serializable{
	private int cid;
	private String content;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
