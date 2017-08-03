package com.alacriti.aman.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EmpVo {
	
	private String empId; 
	private String fName;
	private String lName;
	private String gender;
	private String contactNo; 
	private String email;
	private String passWord;
	private String questionId;
	private String answer;
	
	
	boolean empStatus;

	public EmpVo() {
	}

	public boolean isEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(boolean empStatus) {
		this.empStatus = empStatus;
	}



	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String emp_id) {
		this.empId = emp_id;
	}

	public String getFname() {
		return fName;
	}

	public void setF_name(String f_name) {
		this.fName = fName;
	}

	public String getLname() {
		return lName;
	}

	public void setL_name(String lName) {
		this.lName = lName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContact_no(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return passWord;
	}

	public void setPassword(String password) {
		this.passWord = password;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestion_id(String questionId) {
		this.questionId = questionId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
