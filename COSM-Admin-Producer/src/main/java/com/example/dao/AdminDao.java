package com.example.dao;

import java.util.List;

import com.example.dto.SalesPerson;

public interface AdminDao {

	public void createSalesPerson(String sales_person_name,int sales_person_pincode,int sales_person_mobile);
	public void deleteSalesPerson(int sales_person_pincode);
	public List<SalesPerson> viewSalesPerson();
	public SalesPerson viewSalesPersonByPincode(int sales_person_pincode);
}
