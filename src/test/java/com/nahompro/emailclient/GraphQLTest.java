package com.nahompro.emailclient;

import com.nahompro.emailclient.controller.APIController;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GraphQLTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testSaveUserMutation() throws Exception{
        // Arrange
        String mutation = "{ \"query\": \"mutation { saveUser(user: {username: \\\"johndoe\\\", password: \\\"s3cr3t\\\"}) { id username } }\" }";

        // Act
        MvcResult result = mvc.perform(
                MockMvcRequestBuilders.post("/graphql")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mutation))
                .andExpect(status().isOk())
                .andReturn();
        String response = result.getResponse().getContentAsString();
        System.out.println("####>/graphql/mutation/saveUser: "+response);

        JSONObject res=new JSONObject(response);
        JSONObject data=res.getJSONObject("data");

        // Assert
        assert(data!=null);
        assert(data.getJSONObject("saveUser")!=null);
    }

    @Test
    public void testQueryGetAllUsers() throws Exception{
        // Arrange
        String query = "{ \"query\": \"query { getAllUsers { id username password } }\" }";
        // Act
        MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/graphql").contentType(MediaType.APPLICATION_JSON).content(query))
                .andExpect(status().isOk())
                .andReturn();
        String response = result.getResponse().getContentAsString();
        System.out.println("######>/graphql/query/getAllUsers: "+response);

        assert (response.length()>0);

    }


}
