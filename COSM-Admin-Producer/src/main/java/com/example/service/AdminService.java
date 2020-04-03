package com.example.service;

import java.util.List;

import com.example.dto.SalesPerson;

public interface AdminService {

	public void createSalesPersonService(String sales_person_name,int sales_person_pincode,int sales_person_mobile);
	public void deleteSalesPersonService(int sales_person_pincode);
	public List<SalesPerson> viewSalesPersonService();
	public SalesPerson viewSalesPersonByPincodeService(int sales_person_pincode);
	
}
