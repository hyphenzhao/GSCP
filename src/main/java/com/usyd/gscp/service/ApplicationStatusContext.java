package com.usyd.gscp.service;

public class ApplicationStatusContext {
	public static int STATUS_SUBMITTED = 0;
	public static int STATUS_EDITTING = 1;
	public static int STATUS_PROCESSING = 2;
	public static int STATUS_SUCCESSED = 3;
	public static int STATUS_FAILED = 4;
	
	public static String[] STATUS = {
			"Submitted",
			"Editting",
			"Processing",
			"Successed",
			"Failed"
	};
}
