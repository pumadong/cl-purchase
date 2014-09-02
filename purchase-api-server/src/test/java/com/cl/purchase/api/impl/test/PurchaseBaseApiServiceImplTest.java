package com.cl.purchase.api.impl.test;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cl.purchase.api.impl.PurchaseBaseApiServiceImpl;
import com.cl.purchase.model.base.Supplier;

public class PurchaseBaseApiServiceImplTest {

	private static PurchaseBaseApiServiceImpl service;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-test.xml");  
		service = (PurchaseBaseApiServiceImpl)ctx.getBean("purchaseBaseApiServiceImpl");
		ctx.close();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getSupplierById() {		
		Supplier supplier = service.getSupplierById(1);
		if(supplier == null)
		{
			System.out.println("supplier is null");
		} else {
			System.out.println("supplier is not null");
		}
	}

}
