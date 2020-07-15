package cn.edu.zucc.model;

public class address {   
	public static final String[] tableTitles={"序号","名称","步骤数","已完成数"};
	
	private int address_id;
	private int user_id;
	private String province;
	private String city;
	private String area;
	private String address;
	private String link_people;
	private String phone;
	
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLink_people() {
		return link_people;
	}
	public void setLink_people(String link_people) {
		this.link_people = link_people;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
