package com.yedam.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class StudentVo {
	private String StdNo;
	private String StdName;
	private String StdPhone;
	private String Address;
	private String birth;
	
}
