package co.yedam.vo;

import java.util.Date;

public class GYMVo {
	private int memberId; //std_no
	private String memberName; 
	private int age; 
	private int memberSex; 
	private String phone; 
	private String address; 
	private Date startDay;
	private String trainer;  
	
	
	
	


	public int getMemberId() {
		return memberId;
	}






	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}






	public String getMemberName() {
		return memberName;
	}






	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}






	public int getAge() {
		return age;
	}






	public void setAge(int age) {
		this.age = age;
	}






	public int getMemberSex() {
		return memberSex;
	}






	public void setMemberSex(int memberSex) {
		this.memberSex = memberSex;
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






	public Date getStartDay() {
		return startDay;
	}






	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}






	public String getTrainer() {
		return trainer;
	}






	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}






	@Override
	public String toString() {
		return "GYMVo [memberId=" + memberId + ", memberName=" + memberName + ", age=" + age + ", memberSex="
				+ memberSex + ", phone=" + phone + ", address=" + address + ", startDay=" + startDay +", trainer=" + trainer + "]";
	} 
	
//	public String briefShow() {
//		return stdNo+"  "+stdName+"  "+stdPhone;
//	}
}
