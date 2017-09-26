package com.github.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.model.Request;
import com.github.model.Response;
import com.github.service.DummyService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MainController {

  private DummyService dummyService;

  @Autowired
  public MainController(DummyService dummyService) {
    this.dummyService = dummyService;
  }

  @RequestMapping(value = "/dummy", method = RequestMethod.POST,
      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
      consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  @ResponseBody
  @ApiOperation(value = "Run dummy request")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Dummy POST executed successfully",
          response = Response.class),
      @ApiResponse(code = 400, message = "Body validation error or query execution exception",
          response = Response.class)})
  public final ResponseEntity<Response> dummyMethod(
      @ApiParam(value = "Body that contains all queries and params",
          required = true) @RequestBody Request body) {
    return dummyService.handleResponse(body);
  }
}
