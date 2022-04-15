package com.gg.compList;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Alias("companylist")
@Getter
@Setter
@ToString
public class CompListDTO {
    int CO_NO;
	String COMPANY;
	String HR;
	String CO_EMAIL;
	String CO_CATEGORY;
	String CO_SIZE;	
	
	public CompListDTO() {}

	public CompListDTO(int CO_NO, String COMPANY, String HR, String CO_EMAIL, String CO_CATEGORY, String CO_SIZE) {
		super();
		this.CO_NO = CO_NO;
		this.COMPANY = COMPANY;
		this.HR = HR;
		this.CO_EMAIL = CO_EMAIL;
		this.CO_CATEGORY = CO_CATEGORY;
		this.CO_SIZE = CO_SIZE;
	}

	public CompListDTO(String COMPANY) {
		super();
		this.COMPANY = COMPANY;
	}
}
