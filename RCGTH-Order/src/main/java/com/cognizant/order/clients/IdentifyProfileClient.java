package com.cognizant.order.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.order.exception.ProductTypeNotFoundException;
import com.cognizant.order.entity.Orders;

@FeignClient(name = "RCGTH-IdentifyProfiles", url = "http://35.184.222.106:8082")
public interface IdentifyProfileClient {

	@PostMapping("/identifyprofiles/matchProfile")
	public Orders matchProfile(@RequestBody Orders orders) throws ProductTypeNotFoundException ;

}
