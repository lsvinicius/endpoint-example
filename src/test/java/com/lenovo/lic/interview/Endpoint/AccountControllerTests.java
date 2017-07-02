package com.lenovo.lic.interview.Endpoint;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.lenovo.lic.interview.Endpoint.controller.AccountController;
import com.lenovo.lic.interview.Endpoint.repository.AccountRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
@ContextConfiguration(classes={AccountRepository.class})
public class AccountControllerTests {
	 @Autowired
	 private MockMvc mvc;

	 @Test
	 public void testExample() throws Exception {
		 this.mvc.perform(post("/account/register").accept(MediaType.APPLICATION_JSON))
	     .andExpect(status().isOk()).andExpect(content().string("Honda Civic"));
	 }
}
