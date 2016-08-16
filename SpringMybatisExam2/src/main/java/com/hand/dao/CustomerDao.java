package com.hand.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hand.model.Address;
import com.hand.model.Customer;

public interface CustomerDao {

	public Customer getCustomer(int customer_id);

	public List selectAddress();

	public List selectCustomer();

	public void addCustomer(@Param("store_id") int store_id,
			@Param("first_name") String first_name,
			@Param("last_name") String last_name, @Param("email") String email,
			@Param("address_id") int address_id,
			@Param("create_date") Date create_date);

	public void deleteCustomer(int id);

	public Address findAddress(int address_id);
}
