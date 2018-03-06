package com.hsbc.paystub.utility;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.hsbc.paystub.dto.Employee;

@Component
public interface DataReader {
	
	Map<String,Double> loadStateTaxes(String state) throws IOException;
	Employee loadEmployee(long id) throws IOException;
}
