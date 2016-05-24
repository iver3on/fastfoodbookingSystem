package o2o.member.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import o2o.member.mock.DataMock;
import o2o.member.pojo.Food;

public class LoadFoodsServiceImpl {
	public List<Food> getAllFoods(String ip,int id){
		System.out.println("ip:::::"+ip);
		List<Food> prov=new ArrayList<Food>();
		List<Food> foods= DataMock.allFoods;
		int[] rs=null;
		try {
			rs = getProvFoodIds(ip, id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int m:rs){
			for(Food f:foods){
				if(m==f.getId()){
					prov.add(f);
				}
			}
		}
		return prov;
		
	}
	private int[] getProvFoodIds(String ip,int id) throws Exception{
		String line="{'ip':'"+ip+"','id':"+id+"}\n";
		Socket sk=new Socket("127.0.0.1",4567);
		OutputStream out=sk.getOutputStream();
		BufferedReader reader=new BufferedReader(new InputStreamReader(sk.getInputStream()));
		out.write(line.getBytes());
		String l=reader.readLine();
		JSONArray jsa=JSONArray.fromObject(l);
		Object[] os=jsa.toArray();
		int[] rs=new int[os.length];
		for(int i=0;i<rs.length;i++){
			rs[i]=(Integer)os[i];
		}
		
		out.flush();
		out.close();
		sk.close();
		return rs;
	}
	
	public static void main(String[] args) throws Exception{
		//getProvFoodIds("", 0);
	}
}
