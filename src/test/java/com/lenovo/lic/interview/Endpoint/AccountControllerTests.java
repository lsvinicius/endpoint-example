package com.lenovo.lic.interview.Endpoint;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.lenovo.lic.interview.Endpoint.repository.AccountRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(value = EndpointApplication.class)
public class AccountControllerTests {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AccountRepository accountRepository;
	@MockBean
	private PasswordEncoder passwordEncoder;
	@Autowired
	private WebApplicationContext context;

	@Before
	public void before() {
	    MockitoAnnotations.initMocks(this);
	    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).dispatchOptions(true).build();
	}
	
	@Test
	public void registerAccount() throws Exception {
		String requestJson = "{\"username\":\"novo\", \"password\":\"novo\"";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				"/account/register").accept(
				MediaType.APPLICATION_JSON).content(requestJson)
				.contentType(MediaType.APPLICATION_JSON);;

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println("RESPONSE: "+result.getResponse().getContentAsString());

		assertEquals(HttpStatus.CREATED.value(), result.getResponse().getStatus());

	}
}
