package com.knits.tms.beans;

import lombok.Data;

@Data
public class EditionDto {
	
	private String startDate;
	private String endDate;
	private String deadline;
	private boolean open;

}
