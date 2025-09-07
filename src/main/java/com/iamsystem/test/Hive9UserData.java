package com.iamsystem.test;


import com.iamsystem.service.Hive9Service;

public class Hive9UserData {
	public static void main(String[] args) {
		//getUserEmail
		//getUsersData
		Hive9UserData userdata = new Hive9UserData();
		
	//	userdata.getusers();
	}
	
	
	public void getusers() {
		Hive9Service hive9Service = new Hive9Service();
		try {
			//String data = hive9Service.process();
			//System.out.println(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
