package com.github.service;

import org.springframework.http.ResponseEntity;

import com.github.model.Request;
import com.github.model.Response;

public interface DummyService {
  ResponseEntity<Response> handleResponse(Request request);
}
