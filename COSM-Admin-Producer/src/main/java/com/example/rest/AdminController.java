package com.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.SalesPerson;
import com.example.service.AdminServiceImpl;


@RestController
@RequestMapping("/admin")

public class AdminController {

	@Autowired
	private AdminServiceImpl adminService;
	@RequestMapping(value="/createSales",method=RequestMethod.POST)
	public void createSalesPerson(@RequestParam String sales_person_name,@RequestParam int sales_person_pincode ,@RequestParam int sales_person_mobile) 
	{
		adminService.createSalesPersonService(sales_person_name, sales_person_pincode, sales_person_mobile);
	}
	
	@RequestMapping(value="/deleteSales",method=RequestMethod.DELETE)
	public void deleteSalesPerson(@RequestParam int sales_person_pincode ) 
	{
		adminService.deleteSalesPersonService(sales_person_pincode);
	}
	
	@RequestMapping(value="/viewSales",method=RequestMethod.GET)
	public List<SalesPerson> viewSalesPerson() 
	{
		return adminService.viewSalesPersonService();
	}
	
	@RequestMapping(value="/viewSalesByPincode",method=RequestMethod.GET)
	public SalesPerson viewSalesPersonByPincode(int sales_person_pincode) 
	{
		return adminService.viewSalesPersonByPincodeService(sales_person_pincode);
	}
	

	
	
}
