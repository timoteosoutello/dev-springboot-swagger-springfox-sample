package com.github.builder;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.github.dto.Request;
import com.github.model.Payload;

@Component
public class PayloadBuilder {

	public Payload buildPayloadByRequest(Request request) {
		Payload payload = new Payload();
		payload.setId(UUID.randomUUID());
		payload.setContent(request.toString());
		return payload;
	}
}
