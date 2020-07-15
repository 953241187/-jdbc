package cn.edu.zucc.model;

import cn.edu.zucc.model.productor;

public class productor {
	public static productor currentLoginUser=null;
	private String productor_id;
	private String productor_name;
	private String productor_star;
	private float renjuncost;
	private float zongxiaol;
	
	public String getProductor_id() {
		return productor_id;
	}
	public void setProductor_id(String productor_id) {
		this.productor_id = productor_id;
	}
	public String getProductor_name() {
		return productor_name;
	}
	public void setProductor_name(String productor_name) {
		this.productor_name = productor_name;
	}
	public String getProductor_star() {
		return productor_star;
	}
	public void setProductor_star(String productor_star) {
		this.productor_star = productor_star;
	}
	public float getRenjuncost() {
		return renjuncost;
	}
	public void setRenjuncost(float renjuncost) {
		this.renjuncost = renjuncost;
	}
	public float getZongxiaol() {
		return zongxiaol;
	}
	public void setZongxiaol(float zongxiaol) {
		this.zongxiaol = zongxiaol;
	}
	
}
