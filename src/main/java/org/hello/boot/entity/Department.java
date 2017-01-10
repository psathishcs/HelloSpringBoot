package org.hello.boot.entity;

public class Department {
	Integer deptNo;
	String dName;
	String loc;

	public Integer getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("deptNo : " + deptNo + ", ");
		builder.append("dName : " + dName + ", ");
		builder.append("loc : " + loc);
		return builder.toString();
	}
	
}
