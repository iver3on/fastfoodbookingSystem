package o2o.member.mock;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import o2o.member.pojo.Drink;
import o2o.member.pojo.Food;
import o2o.member.pojo.SideItem;
import o2o.member.pojo.Snack;
import o2o.member.pojo.Trader;

public class DataMock {
	public static List<Food> allFoods=new ArrayList<Food>();
	
	static{
		Snack s1 = new Snack(1,"精炖牛肉煲",23.5);
		Snack s2 = new Snack(2,"酸辣猪排浓汤米线",22.5);
		SideItem i1=new SideItem(3, "葡式蛋挞", 8);
		SideItem i2=new SideItem(4, "耶汁黑米露", 10);
		Drink d1 = new Drink(5,"九真果汁",8);
		Drink d2 = new Drink(6,"醇豆浆",6);
		allFoods.add(s1);allFoods.add(s2);
		allFoods.add(i1);allFoods.add(i2);
		allFoods.add(d1);allFoods.add(d2);
		
		Trader t1=new Trader();
		Trader t2=new Trader();
		s1.setTrader(t1);
		s2.setTrader(t2);
		i1.setTrader(t1);
		i1.setTrader(t1);
		d1.setTrader(t1);
		d2.setTrader(t2);
		
		byte[] bs=null;
		InputStream in=null;
		String[] fns=new String[]{"1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","6.jpg"};
		int i=0;
		try {
			for(String fn:fns){
				in=new FileInputStream("d:/snapshot/"+fn);
				bs=new byte[in.available()];
				in.read(bs);
				allFoods.get(i).setSanpshot(bs);
				i++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
