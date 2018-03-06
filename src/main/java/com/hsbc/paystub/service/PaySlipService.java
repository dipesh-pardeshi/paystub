package com.hsbc.paystub.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hsbc.paystub.dto.PaySlip;
import com.hsbc.paystub.request.PaySlipRequest;
import com.hsbc.paystub.utility.EmployeeHelper;
import com.hsbc.paystub.utility.TaxHelper;

@Service
public class PaySlipService {

	@Autowired
	TaxHelper taxHelper;
	
	@Autowired
	EmployeeHelper employeeHelper; 
	
	public ResponseEntity<PaySlip> execute(PaySlipRequest request) throws IOException
	{
		PaySlip paySlip = new PaySlip();
		Map<String, Long> taxmap;
		
		paySlip.setEmployeeId(request.getEmployeeId());
		paySlip.setBasic(employeeHelper.getBasic(request.getEmployeeId()));
		
		String state = employeeHelper.getState(request.getEmployeeId());
		Map<String, Double> taxPercentage = taxHelper.getTaxPercentForState(state);
		taxmap=taxHelper.getTaxAmount(paySlip.getBasic(), taxPercentage);
		
		paySlip.setGrossPay(taxHelper.getGross(paySlip.getBasic(), taxmap));
		paySlip.setTaxDeductions(taxmap);
		
		return new ResponseEntity<PaySlip>(paySlip, HttpStatus.OK);
	}
	
}
