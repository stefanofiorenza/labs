package com.knits.tms.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TmsUtils {

	private static SimpleDateFormat format_ddMMyyyy = new SimpleDateFormat("dd-MM-yyyy");
	
	public static Date string2Date(String dateAsString) throws ParseException {		
		return format_ddMMyyyy.parse (dateAsString);  
	}
	
	
	public static String date2String(Date date) {
		return format_ddMMyyyy.format(date );
	}
}
