package com.mystudy.jdbc_dao;

public class MemberVO {
	//컬럼명, 타입과 동일하게 자바빈 VO 작성
	private String id;
	private String name;
	private String password;
	private String phone;
	private String address;
	
	//생성자(id, name, password, phone)
	//생성자(id, name, password, phone, address)
	MemberVO(String id, String name, String pw, String ph){
		this.id = id;
		this.name = name;
		this.password = pw;
		this.phone = ph;
	
	}
	
	MemberVO(String id, String name, String pw, String ph, String ads){
		this.id = id;
		this.name = name;
		this.password = pw;
		this.phone = ph;
		this.address = ads;
		
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	//toString 오버라이딩
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", name=" + name + ", password=" + password + ", phone=" + phone + ", address="
				+ address + "]";
	}
	
	
}
