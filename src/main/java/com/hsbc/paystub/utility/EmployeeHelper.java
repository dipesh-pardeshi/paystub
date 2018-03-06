package com.hsbc.paystub.utility;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeHelper {

	@Autowired
	DataReader dataReader;
	
	public String getState(long employeeId) throws IOException
	{
		return dataReader.loadEmployee(employeeId).getState();
	}
	
	public long getBasic(long employeeId) throws IOException
	{
		return dataReader.loadEmployee(employeeId).getBasic();
	}
	
}
