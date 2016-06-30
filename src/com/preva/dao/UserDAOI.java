package com.preva.dao;

import java.util.List;

import com.preva.vo.FuelDetails;
import com.preva.vo.FuelSummaryDetails;



public interface UserDAOI {
	public List<FuelDetails> getFuelDetails(String accountID,String deviceID,String Timestamp1,String Timestamp2);
	public List<FuelSummaryDetails> getFuelSummaryDetails(String accountID,String deviceID,String Timestamp1,String Timestamp2);
}