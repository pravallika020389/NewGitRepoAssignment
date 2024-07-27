package com.base;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.requestPOJO.AddRepoRequest;
import com.requestPOJO.UpdateRepoRequest;
import com.utils.EnvironmentDetails;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

import org.testng.Assert;

import java.util.HashMap;


@Slf4j
public class APIHelper {
    RequestSpecification reqSpec;
    String token = EnvironmentDetails.getProperty("token");;

    public APIHelper() {
        RestAssured.baseURI = EnvironmentDetails.getProperty("baseURL");
        reqSpec = RestAssured.given();
//        reqSpec = (RequestSpecification) new RequestSpecBuilder().addHeaders(getHeaders());
    }

    
    public  Response getRepo(String Owner,String Repo) {
        reqSpec = RestAssured.given();
        Response response = null;
        try {
            reqSpec.headers(getHeaders());
            response = reqSpec.get("/repos/"+ Owner +"/"+Repo);
            response.then().log().all();
        } catch (Exception e) {
            Assert.fail("Get data functionality is failing due to :: " + e.getMessage());
        }
        return response;
    }
    
    public  Response getAllRepos() {
        reqSpec = RestAssured.given();
        Response response = null;
        try {
            reqSpec.headers(getHeaders());
            response = reqSpec.get("/user/repos");
           
        } catch (Exception e) {
            Assert.fail("Get data functionality is failing due to :: " + e.getMessage());
        }
        return response;
    }




    public  Response addData(AddRepoRequest addRepoRequest) {
        reqSpec = RestAssured.given();
        Response response = null;
        try {
            log.info("Adding below data :: " + new ObjectMapper().writeValueAsString(addRepoRequest));
            reqSpec.headers(getHeaders());
            reqSpec.body(new ObjectMapper().writeValueAsString(addRepoRequest)); //Serializing addData Request POJO classes to byte stream
            response = reqSpec.post("user/repos");
            response.then().log().all();
        } catch (Exception e) {
            Assert.fail("Add data functionality is failing due to :: " + e.getMessage());
        }
        return response;
    }

    public Response updateRepo(UpdateRepoRequest updateRepoRequest, String Owner,String Repo) {
        reqSpec = RestAssured.given();
        reqSpec.headers(getHeaders());
        Response response = null;
        try {
            reqSpec.body(new ObjectMapper().writeValueAsString(updateRepoRequest)); //Serializing addData Request POJO classes to byte stream
            response = reqSpec.patch("/repos/"+ Owner +"/"+Repo);
            response.then().log().all();
        } catch (Exception e) {
            Assert.fail("Update data functionality is failing due to :: " + e.getMessage());
        }
        return response;
    }
    
    public  Response deleteRepo(String Owner,String Repo) {
        reqSpec = RestAssured.given();
        Response response = null;
        try {
            reqSpec.headers(getHeaders());
            response = reqSpec.delete("/repos/"+ Owner +"/"+Repo);
            response.then().log().all();
        } catch (Exception e) {
            Assert.fail("Delete data functionality is failing due to :: " + e.getMessage());
        }
        return response;
    }
    
   

    public HashMap<String, String> getHeaders() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", this.token);
       
        
        return headers;
    }

}
