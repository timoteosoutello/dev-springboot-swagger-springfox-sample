package com.github.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.github.constants.LogAttribute;
import com.github.model.Request;
import com.github.model.Response;

@Service
public class DummyServiceImpl implements DummyService {
  private static Logger logger =
      LogManager.getLogger(LogAttribute.SPRING_FRAMEWORK.getPackageName());

  @Override
  public ResponseEntity<Response> handleResponse(Request request) {
    logger.info("Receiving request instance {}", request.toString());
    Response response = new Response();
    response.setStatus(HttpStatus.OK);
    response.setMessage("OK");
    response.setDetailMessage("Request executed successfully");
    return new ResponseEntity<Response>(response, response.getStatus());
  }


}
