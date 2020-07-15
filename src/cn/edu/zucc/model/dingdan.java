package cn.edu.zucc.model;

import java.sql.Date;

public class dingdan {
	   private int dingdan_id;
	   private int user_id;
	   private int manjian_id;
	   private int qishou_id;
	   private int address_id;
	   private float yuanshi_money;
	   private float jiesuan_money;
	   private String pingjia_comment;
	   private Date pingjia_time;
	   private int pingjia_star;
	   private int youhuiquan_id;
	   private String ding_state;
	public int getDingdan_id() {
		return dingdan_id;
	}
	public void setDingdan_id(int dingdan_id) {
		this.dingdan_id = dingdan_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getManjian_id() {
		return manjian_id;
	}
	public void setManjian_id(int manjian_id) {
		this.manjian_id = manjian_id;
	}
	public int getQishou_id() {
		return qishou_id;
	}
	public void setQishou_id(int qishou_id) {
		this.qishou_id = qishou_id;
	}
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public float getYuanshi_money() {
		return yuanshi_money;
	}
	public void setYuanshi_money(float yuanshi_money) {
		this.yuanshi_money = yuanshi_money;
	}
	public float getJiesuan_money() {
		return jiesuan_money;
	}
	public void setJiesuan_money(float jiesuan_money) {
		this.jiesuan_money = jiesuan_money;
	}
	public String getPingjia_comment() {
		return pingjia_comment;
	}
	public void setPingjia_comment(String pingjia_comment) {
		this.pingjia_comment = pingjia_comment;
	}
	public Date getPingjia_time() {
		return pingjia_time;
	}
	public void setPingjia_time(Date pingjia_time) {
		this.pingjia_time = pingjia_time;
	}
	public int getPingjia_star() {
		return pingjia_star;
	}
	public void setPingjia_star(int pingjia_star) {
		this.pingjia_star = pingjia_star;
	}
	public int getYouhuiquan_id() {
		return youhuiquan_id;
	}
	public void setYouhuiquan_id(int youhuiquan_id) {
		this.youhuiquan_id = youhuiquan_id;
	}   
	public String getDing_state() {
		return ding_state;
	}
	public void setDing_state(String ding_state) {
		this.ding_state = ding_state;
	}
	
}
