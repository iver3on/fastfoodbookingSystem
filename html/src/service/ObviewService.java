package service;

import java.util.List;

import pojo.Customer;
import pojo.Obview;

public interface ObviewService {
	//获取餐墙列表
	public List<Obview> getObviewList(Customer c);
	//通过id查找每个餐品的实体
	public Obview findObviewById(Integer id);
}
