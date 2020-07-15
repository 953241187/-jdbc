package cn.edu.zucc.model;

public class product {
	  private String product_id;
	  private int leibie_id;
	  private int user_id;
	  private String productor_id;
	  private String product_name;
	  private float product_price;
	  private String youhui_name;
	  private String productor_name;
	  private int ding_count;
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String id) {
		this.product_id = id;
	}
	public int getLeibie_id() {
		return leibie_id;
	}
	public void setLeibie_id(int leibie_id) {
		this.leibie_id = leibie_id;
	}
	public String getProductor_id() {
		return productor_id;
	}
	public void setProductor_id(String string) {
		this.productor_id = string;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public float getProduct_price() {
		return product_price;
	}
	public void setProduct_price(float product_price) {
		this.product_price = product_price;
	}
	public String getYouhui_name() {
		return youhui_name;
	}
	public void setYouhui_name(String youhui_name) {
		this.youhui_name = youhui_name;
	}
	public String getProductor_name() {
		return productor_name;
	}
	public void setProductor_name(String productor_name) {
		this.productor_name = productor_name;
		
	}
	public int getDing_count() {
		return ding_count;
	}
	public void setDing_count(int ding_count) {
		this.ding_count=ding_count;
		
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
}
