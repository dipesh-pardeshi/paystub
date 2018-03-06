package com.hsbc.paystub.utility;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaxHelper {
	
	@Autowired
	DataReader dataReader;
	
	public Map<String,Long> getTaxAmount(long basicPay, Map<String,Double> taxPercentage)
	{
		Map<String,Long> taxAmount = new HashMap<>();
		Set<Entry<String, Double>> keySet = taxPercentage.entrySet();
		Iterator<Entry<String, Double>> iterator = keySet.iterator();
		while(iterator.hasNext())
		{
			Entry<String, Double> entry = iterator.next();
			long tax = (long) (basicPay * (entry.getValue()/100));
			taxAmount.put(entry.getKey(),  tax);
		}		
		return taxAmount;
	}
	
	public Map<String,Double> getTaxPercentForState(String state) throws IOException
	{
		return dataReader.loadStateTaxes(state);
	}
		
	public long getGross(long basicPay, Map<String,Long> taxAmount)
	{
		long amount = basicPay;
		Set<Entry<String, Long>> keySet = taxAmount.entrySet();
		Iterator<Entry<String, Long>> iterator = keySet.iterator();
		while(iterator.hasNext())
		{
			Entry<String, Long> entry = iterator.next();
			amount = amount-entry.getValue();
		}		
		return amount;
	}

}
