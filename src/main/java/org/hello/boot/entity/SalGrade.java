package org.hello.boot.entity;

public class SalGrade {
	Integer grade;
	Integer loSal;
	Integer hiSal;
	
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public Integer getLoSal() {
		return loSal;
	}
	public void setLoSal(Integer loSal) {
		this.loSal = loSal;
	}
	public Integer getHiSal() {
		return hiSal;
	}
	public void setHiSal(Integer hiSal) {
		this.hiSal = hiSal;
	}
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("grade : " + grade + ", ");
		builder.append("loSal : " + loSal + ", ");
		builder.append("hiSal : " + hiSal);
		return builder.toString();
	}
	
}
