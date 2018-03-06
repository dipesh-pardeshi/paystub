package com.hsbc.paystub.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hsbc.paystub.constants.RestPath;
import com.hsbc.paystub.dto.PaySlip;
import com.hsbc.paystub.request.PaySlipRequest;
import com.hsbc.paystub.service.PaySlipService;

@RestController()
@RequestMapping(RestPath.VERSION)
public class PaystubController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PaySlipService paySlipService; 
		
	@RequestMapping(path=RestPath.PAYSLIP,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaySlip> getPaySlip(@PathVariable(name="employeeId") long employeeId) throws IOException
	{
		logger.info("request received for endpoint{} , with id {}",RestPath.PAYSLIP,employeeId);
		PaySlipRequest request = new PaySlipRequest(employeeId);
		return paySlipService.execute(request);
	}

}
