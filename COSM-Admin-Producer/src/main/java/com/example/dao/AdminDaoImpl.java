package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.dto.SalesPerson;
@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private JdbcTemplate jdbcTempalteObject;
	@Override
	public void createSalesPerson(String sales_person_name,int sales_person_pincode,int sales_person_mobile) {
		
		String SQL="insert into sales_person(sales_person_name,sales_person_pincode,sales_person_mobile) values(?,?,?)";
		jdbcTempalteObject.update(SQL,sales_person_name,sales_person_pincode,sales_person_mobile);

	}

	@Override
	public void deleteSalesPerson(int sales_person_pincode) {
		String SQL="delete from sales_person where sales_person_pincode=?";
		jdbcTempalteObject.update(SQL,sales_person_pincode);

	}

	@Override
	public List<SalesPerson> viewSalesPerson() {
		String SQL="select *  from sales_person ";
		List<SalesPerson> listSales= jdbcTempalteObject.query(SQL,new SalesPersonMapper());
		return listSales;
	}

	@Override
	public SalesPerson viewSalesPersonByPincode(int sales_person_pincode) {
		String SQL="select *  from sales_person where sales_person_pincode=? ";
		SalesPerson listSales= jdbcTempalteObject.queryForObject(SQL,new Object[] {sales_person_pincode},new SalesPersonMapper());
		return listSales;
	}

	

}
