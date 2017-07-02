package com.lenovo.lic.interview.Endpoint;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.lenovo.lic.interview.Endpoint.model.Account;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes={EndpointApplication.class})
public class AccountControllerTests {
	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;


    @MockBean
    UserDetailsService userDetailsService;

	
	@Before
	public void setup() {
		mvc = MockMvcBuilders
				.webAppContextSetup(context)
				.apply(springSecurity())
				.build();
	}
	
	private MvcResult registerAccount(Account account) throws Exception {
		Gson gson = new Gson();
		MvcResult result = this.mvc.perform(post("/account/register").contentType(MediaType.APPLICATION_JSON)
							.content(gson.toJson(account)))
						    .andExpect(status().isOk())
						    .andReturn();		
		return result;
	}
	
	@Test
	public void testRegister() throws Exception {
		Account account = new Account("novo", "novo");
		MvcResult result = registerAccount(account);
		String content = result.getResponse().getContentAsString();
		String contentCopy = "{\"success\":true,\"message\":\"account registered successfully\","
				+ "\"user\":\"novo\"}" + 
				"";
		assert content.equals(contentCopy);
	}
	
	@Test
	public void testValidate() throws Exception {
		
		MvcResult result = this.mvc.perform(get("/account/validate")
						   .with(SecurityMockMvcRequestPostProcessors.httpBasic("novo","novo"))
						   .contentType(MediaType.APPLICATION_JSON))
						   .andExpect(status().isOk()).andReturn();
				
		String content = result.getResponse().getContentAsString();
		System.out.println("MVCRESULT "+result);
		assert 1 == 0;
	}
}