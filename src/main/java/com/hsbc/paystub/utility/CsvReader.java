package com.hsbc.paystub.utility;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.assertj.core.api.exception.RuntimeIOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.hsbc.paystub.dto.Employee;

@Component
public class CsvReader implements DataReader {

	@Autowired
	ResourceLoader resourceLoader;

	String[] STATE_HEADERS = { "state", "tax", "percentage"};
	String[] EMPLOYEE_HEADERS = { "employeeId", "basic", "state"};
	
	public Map<String,Double> loadStateTaxes(String state) throws IOException
	{
		Resource resource = resourceLoader.getResource("classpath:StateTax.csv");
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader(STATE_HEADERS).withFirstRecordAsHeader()
        		.parse(new FileReader(resource.getFile()));
       
        Map<String,Double> taxPercentage = 	new HashMap<>();
        for (CSVRecord record : records) 
        {
        	if(record.get("state").equals(state))
	        {
        		taxPercentage.put(record.get("tax"),Double.valueOf(record.get("percentage")));
	        }
        }
       return taxPercentage;
	}
	
	public Employee loadEmployee(long id) throws IOException
	{
		Resource resource = resourceLoader.getResource("classpath:Employee.csv");
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader(EMPLOYEE_HEADERS).withFirstRecordAsHeader()
        		.parse(new FileReader(resource.getFile()));
       
        Employee employee = null;
        for (CSVRecord record : records) 
        {
        	if(record.get("employeeId").equals(""+id))
	        {
        		employee = new Employee();
        		employee.setId( Long.valueOf(record.get("employeeId")));
        		employee.setBasic( Long.valueOf(record.get("basic")));
        		employee.setState(record.get("state"));
        	  }
        }
        if(employee==null)
        	throw new RuntimeIOException("Employee not found");
        return employee;
	}
	
}
