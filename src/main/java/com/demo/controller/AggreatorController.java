package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Response;
import com.demo.service.AggregatorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping("/orderdetails")
public class AggreatorController {
	
	@Autowired
	private AggregatorService aggregatorService;
	
	@RequestMapping(value = "/{userId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Response getOrdersByUserId(@PathVariable Long userId) throws JsonMappingException, JsonProcessingException {
	
		return aggregatorService.getOrdersByUserId(userId);
	}
}
