package cn.edu.zucc.model;

import java.sql.Date;

public class qishou {   
	private int qishou_id;
	private int dingdan_id;
	private String qishou_name;
	private Date ruzhi_date;
	private Date songda_date;
	private String qishou_shengf;
	public int getQishou_id() {
		return qishou_id;
	}
	public void setQishou_id(int qishou_id) {
		this.qishou_id = qishou_id;
	}
	public String getQishou_name() {
		return qishou_name;
	}
	public void setDingdan_id(int dingdan_id) {
		this.dingdan_id = dingdan_id;
	}
	public int getDingdan_id() {
		return dingdan_id;
	}
	public void setQishou_name(String qishou_name) {
		this.qishou_name = qishou_name;
	}
	public Date getRuzhi_date() {
		return ruzhi_date;
	}
	public void setRuzhi_date(Date ruzhi_date) {
		this.ruzhi_date = ruzhi_date;
	}
	public Date getSongda_date() {
		return songda_date;
	}
	public void setDongda_date(Date songda_date) {
		this.songda_date = songda_date;
	}
	public String getQishou_shengf() {
		return qishou_shengf;
	}
	public void setQishou_shengf(String qishou_shengf) {
		this.qishou_shengf = qishou_shengf;
	}
	
}
