package com.tjcichra.tira;

import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcResultHandlersDsl;

@SpringBootTest
@AutoConfigureMockMvc
class TiraApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	// @Test
	// void contextLoads() {
	// 	System.out.println("HELLO EVERYONE THIS IS DIREWOLF20");
	// 	Assertions.assertThat(webServerController).isNotNull();
	// }

	@Test
	public void greetingShouldReturnDefaultMessage() {
		//this.mockMvc.perform(MockMvcResultHandlersDsl.get("/").andDo(print()).andExpect(status().isOk()))
	}
}
