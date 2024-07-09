package co.yedam.vo;

import java.util.Date;

public class StudentVo {
	private String stdNo; //std_no
	private String stdName; 
	private String stdPhone; 
	private String stdAddress; 
	private String BirthDate;  // 1999-01-01
	private Date CreationDate;
	
	
	
	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public void setStdPhone(String stdPhone) {
		this.stdPhone = stdPhone;
	}
	public void setStdAddress(String stdAddress) {
		this.stdAddress = stdAddress;
	}
	public void setBirthDate(String birthDate) {
		BirthDate = birthDate;
	}
	public void setCreationDate(Date creationDate) {
		CreationDate = creationDate;
	}
	public String getStdNo() {
		return stdNo;
	}
	public String getStdName() {
		return stdName;
	}
	public String getStdPhone() {
		return stdPhone;
	}
	public String getStdAddress() {
		return stdAddress;
	}
	public String getBirthDate() {
		return BirthDate;
	}
	public Date getCreationDate() {
		return CreationDate;
	}
	
	@Override
	public String toString() {
		return "StudentVo [stdNo=" + stdNo + ", stdName=" + stdName + ", stdPhone=" + stdPhone + ", stdAddress="
				+ stdAddress + ", BirthDate=" + BirthDate + ", CreationDate=" + CreationDate + "]";
	} 
	
	public String briefShow() {
		return stdNo+"  "+stdName+"  "+stdPhone;
	}
}
