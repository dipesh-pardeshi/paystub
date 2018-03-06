package com.hsbc.paystub.constants;

public class RestPath {

	private RestPath()
	{
		super();
	}
	public static final String VERSION = "/v1";
	public static final String PAYSLIP = "/employee/{employeeId}/payslip";
}
