package com.lovegis.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.heygis.dao.PageViewCounterDAImpl;
import com.lovegis.mapper.PageViewCounterMapper;
@Service
public class OtherPageViewCounter {
	//private static int num = new PageViewCounterDAImpl().getLastNum() + 137;
	@Resource PageViewCounterMapper pageViewCounterMapper;
	private  int num = pageViewCounterMapper.getLastNum() + 137;//获取人数
	private  int index = 0;
	private  List<String> ip = new ArrayList<String>();
	private  List<Long> time = new ArrayList<Long>();
	private  List<String> userAgent = new ArrayList<String>();
	
	public  void addViewer(String _ip, String _userAgent){
		ip.add(_ip);//添加ip
		time.add(new Date().getTime());//添加时间
		userAgent.add(_userAgent);  //添加来源
//		System.out.println(_userAgent+"ua");
		index++;num++;
		
		if(index ==  50){
			store();
		}
	}
	private  boolean store(){
		System.out.println("-----------------------");
	
		
		try {
			for(int i=0;i<ip.size();i++){
			pageViewCounterMapper.store(ip.get(i),new Timestamp(time.get(i)),userAgent.get(i));//存储
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		//清空
		ip.clear();
		time.clear();
		userAgent.clear();
		index = 0;
		return true;
	}
	public  int getNum(){
		return num;
	}
}
