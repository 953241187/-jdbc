package cn.edu.zucc.model;

import java.sql.Date;

public class youhuichiyou { 
	public int getYouhuiquan_id() {
		return youhuiquan_id;
	}
	public void setYouhuiquan_id(int youhuiquan_id) {
		this.youhuiquan_id = youhuiquan_id;
	}
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
	public String getProductor_id() {
		return productor_id;
	}
	public void setProductor_id(String productor_id) {
		this.productor_id = productor_id;
	}
	public int getShuliang() {
		return shuliang;
	}
	public void setShuliang(int shuliang) {
		this.shuliang = shuliang;
	}
	public Date getHui_end_time() {
		return hui_end_time;
	}
	public void setHui_end_time(Date hui_end_time) {
		this.hui_end_time = hui_end_time;
	}
	private int youhuiquan_id;
	private int user_id;
	private String productor_id;
	private int dingdan_id;
	private int shuliang;
	private Date hui_end_time;
	
}
