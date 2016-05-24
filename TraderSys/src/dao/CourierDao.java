package dao;

import java.util.*;

import pojo.Courier;

public class CourierDao {
	
	private static ArrayList<Courier> Couriers = new ArrayList<Courier>();

	public static ArrayList<Courier> getCouriers() {
		return Couriers;
	}

	public static void setCouriers(ArrayList<Courier> couriers) {
		Couriers = couriers;
	}
}
