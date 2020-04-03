package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.AdminDaoImpl;
import com.example.dto.SalesPerson;
@Service
public class AdminServiceImpl implements AdminService {

	
	@Autowired
	private AdminDaoImpl adminDaoImpl;
	@Override
	public void createSalesPersonService(String sales_person_name,int sales_person_pincode,int sales_person_mobile) {
		adminDaoImpl.createSalesPerson(sales_person_name,sales_person_pincode,sales_person_mobile);

	}

	@Override
	public void deleteSalesPersonService(int sales_person_pincode) {
		adminDaoImpl.deleteSalesPerson(sales_person_pincode);

	}
	public List<SalesPerson> viewSalesPersonService()
	{
		return adminDaoImpl.viewSalesPerson();
	}
	public SalesPerson viewSalesPersonByPincodeService(int sales_person_pincode)
	{
		return adminDaoImpl.viewSalesPersonByPincode(sales_person_pincode);
	}
}
