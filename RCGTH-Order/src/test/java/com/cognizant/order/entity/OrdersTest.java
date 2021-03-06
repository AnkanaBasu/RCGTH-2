package com.cognizant.order.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


class OrdersTest {


	@Test
	void testOrdersGettersSettersConstructorsToString() { 

		Product product=new Product(1, "phone", "Electronics", 10000, "Y", "Y", "N", "Y");
		List<Product> productList=new ArrayList<Product>();productList.add(product);
		Orders order1 = new Orders(1,"XYZ",productList, 1);
		Orders order2 = new Orders();
		Orders order3 = new Orders(1, "XYZ", 1);
		
		order2.setOrderId(1);
		order2.setProducts(productList);
		order2.setOrderName("XYZ");
		order2.setTotal(1);
		
		
		assertEquals(1,order1.getOrderId());
		assertEquals(productList,order1.getProducts());
		assertEquals("XYZ",order1.getOrderName());
		assertEquals(1,order3.getTotal());
		
		
		assertEquals("Orders(orderId=1, orderName=XYZ, products=[Product(productId=1, productName=phone, productType=Electronics, productPrice=10000, returnpolicy=Y, fragility=Y, expiry=N, warranty=Y, order=null)], total=1)", order1.toString());
	}

}
