package com.hsbc.paystub.dto;

import java.util.Map;

public class PaySlip {
	
	long employeeId;
	String month = "April";
	long basic;
	Map<String,Long> taxDeductions;
	long grossPay;
	
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public long getBasic() {
		return basic;
	}
	public void setBasic(long basic) {
		this.basic = basic;
	}
	public Map<String,Long> getTaxDeductions() {
		return taxDeductions;
	}
	public void setTaxDeductions(Map<String,Long> taxDeductions) {
		this.taxDeductions = taxDeductions;
	}
	public long getGrossPay() {
		return grossPay;
	}
	public void setGrossPay(long grossPay) {
		this.grossPay = grossPay;
	}

	
}
