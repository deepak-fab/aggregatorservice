package com.demo.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.model.OrderDetails;
import com.demo.model.Response;
import com.demo.model.UserDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class AggregatorService {

	@Value("${USER_SERVICE_URL}")
	private String userServiceUrl;

	@Value("${ORDER_SERVICE_URL}")
	private String ordersServiceUrl;

	@Resource(name = "restTemp")
	private RestTemplate restTemplate;

	public Response getOrdersByUserId(Long userId) throws JsonMappingException, JsonProcessingException {

		Response response = new Response();
		UserDetails userDetails = null;
		OrderDetails[] orderDetails = null;
		try {
			userDetails = restTemplate.getForObject(userServiceUrl +"/user/"+userId, UserDetails.class);
			orderDetails = restTemplate.getForObject(ordersServiceUrl +"/orders/"+userId, OrderDetails[].class);
			response.setUserDetails(userDetails);
			response.setOrderDetails(orderDetails);
		} catch (Exception e) {
		   System.out.println(e.getMessage());
		}

		return response;
	}

}
