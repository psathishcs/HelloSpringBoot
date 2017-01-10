package org.hello.boot.entity;

import java.sql.Date;

public class Employee {
	Integer empNo;
	String eName;
	String job;
	Employee mgr;
	Date hireDate;
	Double sal;
	Double comm;
	Department dept;
	
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	public Employee getMgr() {
		return mgr;
	}
	public void setMgr(Employee mgr) {
		this.mgr = mgr;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	public Double getComm() {
		return comm;
	}
	public void setComm(Double comm) {
		this.comm = comm;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("empNo : " + empNo + ", ");
		builder.append("eName : " + eName + ", ");
		builder.append("job : " + job + ", " );
		builder.append("mgr : " + mgr + ", ");
		builder.append("hireDate : " + hireDate + ", " );
		builder.append("sal : " + sal + ", ");
		builder.append("comm : " + comm + ", " );
		builder.append("dept : " + dept );
		return builder.toString();
	}
}
