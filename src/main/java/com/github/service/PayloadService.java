package com.github.service;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.github.builder.PayloadBuilder;
import com.github.constants.LogAttribute;
import com.github.dto.Request;
import com.github.dto.Response;
import com.github.model.Payload;
import com.github.repository.PayloadRepository;

@Service
public class PayloadService {
	private static Logger logger = LogManager.getLogger(LogAttribute.SPRING_FRAMEWORK.getPackageName());
	private PayloadRepository payloadRepository;
	private PayloadBuilder payloadBuilder;
	
	@Autowired
	public PayloadService (PayloadRepository payloadRepository, PayloadBuilder payloadBuilder) {
		this.payloadRepository = payloadRepository;
		this.payloadBuilder = payloadBuilder;
	}
	
	@Transactional
	public ResponseEntity<Response> savePayload(Request request) {		
		logger.info("Receiving request POST payloads {}", request.toString());
		Response response = new Response();
		response.setStatus(HttpStatus.OK);
		response.setMessage("OK");
		response.setDetailMessage("Request executed successfully");
		Payload payload = payloadBuilder.buildPayloadByRequest(request);
		payloadRepository.save(payload);
		return new ResponseEntity<Response>(response, response.getStatus());
	}
	
	public ResponseEntity<Response> getPayloads() {		
		logger.info("Receiving request GET payloads");
		Response response = new Response();
		response.setStatus(HttpStatus.OK);
		response.setMessage("OK");
		response.setDetailMessage("Request executed successfully");
		response.setContent(payloadRepository.findAll());
		return new ResponseEntity<Response>(response, response.getStatus());
	}

}
