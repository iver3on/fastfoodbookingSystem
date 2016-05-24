package pojo;

public class Shop {
	private Integer id;;
	private String name;
	private String logo;
	private User user;
	private String content;
	private int totalCount=0;//总销量
	private int contribution=0;//商店贡献
	private int rankbase=0;//商家总得分
	
	public int getContribution() {
		return contribution;
	}
	public void setContribution(int contribution) {
		this.contribution = contribution;
	}
	public int getRankbase() {
		return rankbase;
	}
	public void setRankbase(int rankbase) {
		this.rankbase = rankbase;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getId() {
		return id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setId(Integer id) {
		this.id = id;
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

}
