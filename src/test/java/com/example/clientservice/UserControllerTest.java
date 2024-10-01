package com.example.clientservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;

	@Test
	public void createUserTest() throws Exception {
		User user = new User("John", "Doe", "Smith", "123456789");

		when(userService.saveUser(user)).thenReturn(user);

		mockMvc.perform(post("/users/create")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"nombre\":\"John\",\"apellidoPaterno\":\"Doe\",\"apellidoMaterno\":\"Smith\",\"documentoIdentidad\":\"123456789\"}"))
				.andExpect(status().isOk())
				.andExpect(content().json("{\"nombre\":\"John\",\"apellidoPaterno\":\"Doe\",\"apellidoMaterno\":\"Smith\",\"documentoIdentidad\":\"123456789\"}"));
	}
}
