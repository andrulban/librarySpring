package com.andruha.security_test;

import com.andruha.security_test.annotations.CustomUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import javax.servlet.Filter;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by andrusha on 01.08.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class SecurityMockTest {
    @Autowired
    private WebApplicationContext context;

    @Autowired
    private Filter springSecurityFilterChain;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void inboxRequiresLogin() throws Exception {
        mvc
                .perform(get("/"))
                .andExpect(loginPage());
    }

    @Test
    @CustomUser
    public void validUsernamePassword() throws Exception {
        mvc
                .perform(formLogin())
                .andExpect(authenticated());
    }

    @Test
    @CustomUser
    @WithUserDetails("admin")
    public void validUsernamePassword1() throws Exception {
        mvc
                .perform(formLogin())
                .andExpect(authenticated());
    }

    @Test
    @CustomUser
    public void userCanAccessBooks() throws Exception {
        mvc
                .perform(get("/books"))
                .andExpect(status().isOk());
    }



    private static ResultMatcher loginPage() {
        return new ResultMatcher() {
            @Override
            public void match(MvcResult result) throws Exception {
                status().isMovedTemporarily().match(result);
                redirectedUrl("http://localhost/login").match(result);
            }
        };
    }

}
