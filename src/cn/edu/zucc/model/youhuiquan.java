package cn.edu.zucc.model;

import java.sql.Date;

public class youhuiquan { 
	 private int youhuiquan_id;
	 private float youhui_money;
	 private Date start_time;
	 private Date hui_end_time;
	public int getYouhuiquan_id() {
		return youhuiquan_id;
	}
	public void setYouhuiquan_id(int youhuiquan_id) {
		this.youhuiquan_id = youhuiquan_id;
	}
	public float getYouhui_money() {
		return youhui_money;
	}
	public void setYouhui_money(float youhui_money) {
		this.youhui_money = youhui_money;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Date getHui_end_time() {
		return hui_end_time;
	}
	public void setHui_end_time(Date hui_end_time) {
		this.hui_end_time = hui_end_time;
	}
}
