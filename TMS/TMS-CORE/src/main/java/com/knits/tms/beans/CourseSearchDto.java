package com.knits.tms.beans;

import java.util.List;

import lombok.Data;

@Data
public class CourseSearchDto {

	private List<String> tags;
	private List<String> topics;
	private String title;
	private Boolean active;
	private Boolean published;
}
