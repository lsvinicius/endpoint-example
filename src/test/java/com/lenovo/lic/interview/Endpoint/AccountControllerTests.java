package com.lenovo.lic.interview.Endpoint;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.lenovo.lic.interview.Endpoint.controller.AccountController;
import com.lenovo.lic.interview.Endpoint.model.Account;
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

	@Test
	public void retrieveDetailsForCourse() throws Exception {
		Account account = new Account();
		account.setPassword("teste");
		account.setUsername("teste");

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				"/account/register").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{}";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
}
