package com.alacriti.empleavetool.vo;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;

@XmlRootElement
public class LeaveVo {
	private String leaveId;
	private Date fromDate;
	private Date toDate;
	private String Reason;
	private int noDays;
	private String leaveStatus;
	private String empId;
		
	public String getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(String leaveId) {
		this.leaveId = leaveId;
	}


	public String getLeaveTag() {
		return leaveTag;
	}

	public void setLeaveTag(String leaveTag) {
		this.leaveTag = leaveTag;
	}

	private Date lastModifiedTime;
	private String leaveTag;
	private Date lastModifyTime;


	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	@JsonFormat
	public Date getToDate() {
		return toDate;
	}
	@JsonFormat
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getReason() {
		return Reason;
	}

	public void setReason(String reason) {
		Reason = reason;
	}

	public int getNoDays() {
		return noDays;
	}

	public void setNoDays(int noDays) {
		this.noDays = noDays;
	}

	public String getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

}
