package com.ljd.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Created by author on 17-11-3.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void list() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/account/list")).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getById() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/account/1")).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void delete() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/account/1")).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void updateAccount() throws Exception {
        mvc.perform(MockMvcRequestBuilders.put("/account/2").contentType(MediaType.APPLICATION_JSON).param("name","haha").param("money","123123").accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void addAccount() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/account").contentType(MediaType.APPLICATION_JSON).param("name","liangjidong").param("money","123456").accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

}