package com.github.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.SpringExecutor;
import com.github.builder.PayloadBuilder;
import com.github.dto.Response;
import com.github.repository.PayloadRepository;
import com.github.service.PayloadService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringExecutor.class)
@WebAppConfiguration
public class RestApiControllerTest {
	PayloadController mainController;
	@Mock
	PayloadRepository payloadRepository;
	@Mock
	PayloadBuilder payloadBuilder;
	PayloadService payloadService;
	MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		payloadService = new PayloadService(payloadRepository, payloadBuilder);
		mainController = new PayloadController(payloadService);
		this.mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
	}

	@Test
	public void testPostPayload() throws Exception {
		mockMvc.perform(post("/payload").contentType(MediaType.APPLICATION_JSON).content("{ }"))
				.andExpect(status().isOk());
	}

	@Test
	public void testGetPayloads() throws Exception {
		MvcResult result = mockMvc.perform(get("/payloads").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		Response response = new ObjectMapper().readValue(result.getResponse().getContentAsString(), Response.class);
		assert (response.getContent() != null);
	}
}
