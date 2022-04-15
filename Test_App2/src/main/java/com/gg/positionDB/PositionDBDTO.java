package com.gg.positionDB;

import org.apache.ibatis.type.Alias;
import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Alias("position")
@Getter
@Setter
@ToString
public class PositionDBDTO {
	String POSITION;
	String QUALIFY;
	String EMPLOY_TYPE;
	String JOB;
	Date REGI_DT;
	int CO_NO;
	
	public PositionDBDTO() {}

	public PositionDBDTO(
			String POSITION, String QUALIFY, String EMPLOY_TYPE,
			String JOB, Date REGI_DT, int CO_NO) {
		super();
		this.POSITION = POSITION;
		this.QUALIFY = QUALIFY;
		this.EMPLOY_TYPE = EMPLOY_TYPE;
		this.JOB = JOB;
		this.REGI_DT = REGI_DT;
		this.CO_NO = CO_NO;
	}
}
