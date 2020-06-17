//package com.webatoz.backend.interfaces;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.gson.Gson;
//import com.webatoz.backend.domain.CommentDomain;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class CommentControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    ObjectMapper mapper = new ObjectMapper();
//    Gson gson = new Gson();
//
//    @Test
//    public void setComment() throws Exception{
//
//        String json = gson.toJson(new CommentDomain("제목", "내용"));
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/replies")
//                .contentType(MediaType.APPLICATION_JSON).content(json))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//    @Test
//    public void getComment() throws Exception{
//        mockMvc.perform(MockMvcRequestBuilders.get("/replies/3"))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//}
