package com.cognizant.order.contoller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cognizant.order.entity.Orders;
import com.cognizant.order.entity.Product;
import com.cognizant.order.exception.OrderAlreadyExistsException;
import com.cognizant.order.exception.OrderNotFoundException;
import com.cognizant.order.exception.ProductTypeNotFoundException;
import com.cognizant.order.model.OrderPojo;
import com.cognizant.order.service.OrderService;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

	@InjectMocks
	private transient OrderController orderController;
	@Mock
	private transient OrderService service;


	@Test
	final void testGetAllOrders()  {
		Product product=new Product(1, "phone", "Electronics", 10000, "Y", "Y", "N", "Y");
		List<Product> productList=new ArrayList<Product>();
		productList.add(product);
		Orders order=new Orders(1, "XYZ",  productList, 10000);
		List<Orders> orderList=new ArrayList<>();orderList.add(order);
		when(service.getAllOrders()).thenReturn(orderList);
		List<OrderPojo> expected = orderController.getAllOrders();
		assertEquals(expected.get(0).getOrderId(),order.getOrderId());
	}
	
	@Test
	final void testInsertOrder() throws OrderAlreadyExistsException, ProductTypeNotFoundException  {
		Product product=new Product(1, "phone", "Electronics", 10000, "Y", "Y", "N", "Y");
		List<Product> productList=new ArrayList<Product>();
		 productList.add(product);
		Orders order=new Orders(1, "XYZ", productList, 10000);
		when(service.saveOrders(order)).thenReturn(order);
		Orders expected = orderController.insertOrder(order);
		assertEquals(expected,order);
	}
	
	@Test
	final void testUpdateOrders() throws OrderNotFoundException, ProductTypeNotFoundException  {
		Product product=new Product(1, "phone", "Electronics", 10000, "Y", "Y", "N", "Y");
		List<Product> productList=new ArrayList<Product>();
		 productList.add(product);
		Orders order=new Orders(1, "XYZ", productList, 10000);
		when(service.updateOrders(order)).thenReturn(order);
		Orders expected = orderController.updateOrders(order);
		assertEquals(expected,order);
	}
	
	@Test
	final void testDeleteOrder() throws OrderNotFoundException  {
		when(service.deleteOrders(1)).thenReturn("Order deleted with id: 1");
		String expected = orderController.deleteOrder(1);
		assertEquals(expected,"Order deleted with id: 1");
	}
}

