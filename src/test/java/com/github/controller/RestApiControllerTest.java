package com.github.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.github.SpringExecutor;
import com.github.service.DummyService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringExecutor.class)
@WebAppConfiguration
public class RestApiControllerTest {
	MainController mainController;
	@Spy
	@InjectMocks
	DummyService dummyService;
	MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		mainController = new MainController(dummyService);
		this.mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
	}

	@Test
	public void testDummyEndpoint() throws Exception {
		mockMvc.perform(post("/dummy").contentType(MediaType.APPLICATION_JSON).content("{ }"))
				.andExpect(status().isOk());
	}

}
