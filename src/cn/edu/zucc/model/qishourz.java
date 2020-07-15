package cn.edu.zucc.model;

import java.sql.Date;

public class qishourz {
	  private int qishou_id;
	  private int user_id;
	  private int dingdan_id;
	  private Date date;
	  private String user_comment;
	  private Float money;
	public int getQishou_id() {
		return qishou_id;
	}
	public void setQishou_id(int qishou_id) {
		this.qishou_id = qishou_id;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getDingdan_id() {
		return dingdan_id;
	}
	public void setDingdan_id(int dingdan_id) {
		this.dingdan_id = dingdan_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getUser_comment() {
		return user_comment;
	}
	public void setUser_comment(String user_comment) {
		this.user_comment = user_comment;
	}
	  
}
