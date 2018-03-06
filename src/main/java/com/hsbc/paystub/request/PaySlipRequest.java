package com.hsbc.paystub.request;

public class PaySlipRequest{
	long employeeId;

	public PaySlipRequest(long employeeId) {
		super();
		this.employeeId = employeeId;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
}
