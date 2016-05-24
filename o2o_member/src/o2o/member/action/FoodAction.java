package o2o.member.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Member;
import java.util.List;

import o2o.member.pojo.Food;
import o2o.member.service.impl.LoadFoodsServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FoodAction extends ActionSupport {
	private InputStream snp;
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public InputStream getSnp() {
		return snp;
	}

	public String showSnapshot(){
		Food tf=null;
		List<Food> lf=(List<Food>)ActionContext.getContext().getSession().get("provFoods");
		for(Food f:lf){
			if(id==f.getId()){
				snp=new ByteArrayInputStream(f.getSanpshot());
			}
		}
		return SUCCESS;
		
	}
	public String goIndex(){
		int id=0;
		
		String ip=(String)ActionContext.getContext().getSession().get("ip");
		Object o=ActionContext.getContext().getSession().get("member");;
		if(o!=null){
			Member m=(Member)o;
//			id=o.getId();
		}
		LoadFoodsServiceImpl lfs = new LoadFoodsServiceImpl();
		List<Food> provFoods=lfs.getAllFoods(ip, id);
		ActionContext.getContext().getSession().put("provFoods", provFoods);
		return SUCCESS;
	}
}
