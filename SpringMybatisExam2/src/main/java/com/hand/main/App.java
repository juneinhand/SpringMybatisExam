package com.hand.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hand.dao.CustomerDao;
import com.hand.model.Address;
import com.hand.model.Customer;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = null;
		ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		CustomerDao customerDao = (CustomerDao) ctx.getBean("customerDao");
	
		Customer customer = new Customer();
		Address address = new Address();

		System.out.println("请输入FirstName(first_name):");
		Scanner scanner0 = new Scanner(System.in);
		String setFirst_name = scanner0.next();

		System.out.println("请输入LastName(last_name):");
		Scanner scanner1 = new Scanner(System.in);
		String setLast_name = scanner1.next();

		System.out.println("请输入Email(emai):");
		Scanner scanner2 = new Scanner(System.in);
		String setEmail = scanner2.next();

		List<Integer> temp = customerDao.selectAddress();
		
		int setAddress_id = 0;
		System.out.println("请输入Address ID:");
		while (true) {
			Scanner scanner3 = new Scanner(System.in);
			int i = scanner3.nextInt();
			boolean m = false;
			for (int j : temp) {
				if (i == j)
					m = true;
			}
			if (m) {
				setAddress_id = i;
				break;
			} else {
				System.out.println("你输入的Address ID不存在,请重新输入:");
			}
		}

		int store_id = 1;
		customer.setStore_id(1);
		customer.setFirst_name(setFirst_name);
		customer.setLast_name(setLast_name);
		customer.setEmail(setEmail);
		customer.setAddress_id(setAddress_id);
		customer.setCreate_date(new Date());
		// System.out.println(new Date());
		customerDao.addCustomer(store_id, setFirst_name, setLast_name,
				setEmail, setAddress_id, new Date());
	

		System.out.println("添加成功");

		System.out.println("Before Insert Customer Date");
		System.out.println("已经保存的数据如下");
		System.out.println("ID: " + customer.getStore_id());
		System.out.println("FirstName: " + customer.getFirst_name());
		System.out.println("Last_name: " + customer.getLast_name());
		System.out.println("Email: " + customer.getEmail());
		System.out.println("Address:" + customerDao.findAddress(setAddress_id).getAddress());
		System.out.println("After Insert Customer Data");
		
		
		List<Integer> temp1 = customerDao.selectCustomer();
		
		int setCustomer_id = 0;
		System.out.println("请输入Customer ID:");
		while (true) {
			Scanner scanner4 = new Scanner(System.in);
			int i = scanner4.nextInt();
			boolean m = false;
			for (int j : temp1) {
				if (i == j)
					m = true;
			}
			if (m) {
				setCustomer_id = i;
				break;
			} else {
				System.out.println("你输入的Customer ID不存在,请重新输入:");
			}
		}
		
		customerDao.deleteCustomer(setCustomer_id);
		System.out.println("你输入的ID 为"+setCustomer_id +"的Customer 已经 删除.");
	}
}
