package com.alacriti.aman.vo;

public class EmpAuthVo {
	String email;
	String passWord;
	String empId;
	
EmpAuthVo(){}
 public EmpAuthVo(String empId,String email,String passWord){
	this.email=email;
	this.empId=empId;
	this.passWord=passWord;
}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
}
