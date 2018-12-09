package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UsersRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UsersControllerTest.class)
public class UsersControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private UsersRepository userVehicleService;

    @Test
    public void testExample() throws Exception {
        given(this.userVehicleService.findAll())
                .willReturn(Collections.singletonList(new User() {{
                    setId(1);
                    setName("Ivan");
                }}));
        this.mvc.perform(MockMvcRequestBuilders.get("/users").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"user_id\":\"1\",\"user_name\":\"Ivan\"}]"));
    }
}
