package cn.edu.zucc.model;

import java.sql.Date;

public class user {
	   private int user_id;
	   private String user_name;
	   private String user_sex;
	   private String user_password;
	   private String phone_number;
	   private String email;
	   private String city;
	   private Date zhuce_time;
	   private int shifouhuiyuan;
	   private Date hui_end_time;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Date getZhuce_time() {
		return zhuce_time;
	}
	public void setZhuce_time(Date zhuce_time) {
		this.zhuce_time = zhuce_time;
	}
	public int getShifouhuiyuan() {
		return shifouhuiyuan;
	}
	public void setShifouhuiyuan(int shifouhuiyuan) {
		this.shifouhuiyuan = shifouhuiyuan;
	}
	public Date getHui_end_time() {
		return hui_end_time;
	}
	public void setHui_end_time(Date hui_end_time) {
		this.hui_end_time = hui_end_time;
	}
	   
}
