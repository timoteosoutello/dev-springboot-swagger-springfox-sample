package com.github.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.dto.Request;
import com.github.dto.Response;
import com.github.service.PayloadService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class PayloadController {

	private PayloadService payloadService;

	@Autowired
	public PayloadController(PayloadService payloadService) {
		this.payloadService = payloadService;
	}

	@RequestMapping(value = "/payload", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	@ApiOperation(value = "Run payload request")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Payload executed successfully", response = Response.class),
			@ApiResponse(code = 400, message = "Body validation error", response = Response.class) })
	public final ResponseEntity<Response> save(
			@ApiParam(value = "Body that contains the payload content", required = true) @RequestBody Request body) {
		return payloadService.savePayload(body);
	}

	@RequestMapping(value = "/payloads", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	@ApiOperation(value = "Get Payloads")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Payloads returned successfully", response = Response.class) })
	public final ResponseEntity<Response> getAll() {
		return payloadService.getPayloads();
	}
}
