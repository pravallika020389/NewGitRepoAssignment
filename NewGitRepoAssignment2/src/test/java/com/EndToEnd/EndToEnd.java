package com.EndToEnd;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.APIHelper;
import com.base.BaseTest;
import com.github.javafaker.Faker;
import com.requestPOJO.AddRepoRequest;
import com.requestPOJO.UpdateRepoRequest;
import com.resposePOJO.AddRepoResponse;
import com.resposePOJO.GetRepoResponse;
import com.resposePOJO.UpdateRepoResponse;
import com.utils.JsonSchemaValidate;
import com.utils.TestDataUtils;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class EndToEnd extends BaseTest {
	APIHelper apiHelper;
	String name, description, homepage ,createdRepo,fullName,inCorrectRepo,exsitingRepo,updatedRepo,toDeleteRepo,deletedRepo;
	Boolean Private;
	private Faker faker;
	 
	@BeforeClass
	public void beforeClass() {
		faker = new Faker();
		apiHelper = new APIHelper();
	}
	
	@Test(priority = 0, description = "validate get repo functionality")
	public void validateGetRepoFunctionality_TC001() {
		
		createdRepo= "DockerProject";
		System.out.println("---------------------------------------Geting single repo ---------------------------------------------------------");
		fullName= TestDataUtils.getProperty("loggedInUser")+"/"+createdRepo;
		Response response = apiHelper.getRepo(TestDataUtils.getProperty("loggedInUser"),createdRepo);
		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK,
				"Get Repo reponse status code is not as expected.");
		Assert.assertEquals(response.as(GetRepoResponse.class).getFullName(), this.fullName,
				"The value of full name is not as expected in response ");
		Assert.assertEquals(response.as(GetRepoResponse.class).getDefaultBranch(),"master", "The value of main branch is not as expected in response ");
		Assert.assertEquals(response.getContentType(),"application/json; charset=utf-8","Get Repo content type is not as expected.");		
		String actualResponse = response.jsonPath().prettyPrint();
		JsonSchemaValidate.validateSchema(actualResponse, "GetRepoResponseSchema.json");
	}

	@Test(priority = 1, description = "validate negative scenario of get repo functionality")
	public void validateNegativeScenarioGetRepoFunctionality_TC002() {
		System.out.println("---------------------------------------Geting single repo with wrong name ---------------------------------------------------------");
		
		inCorrectRepo= "Docker";
		fullName= TestDataUtils.getProperty("loggedInUser")+"/"+createdRepo;
		Response response = apiHelper.getRepo(TestDataUtils.getProperty("loggedInUser"),inCorrectRepo);
		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_NOT_FOUND,
				"Get Repo reponse status code is not as expected.");
		
		String resMessage = response.body().jsonPath().get("message");
		String actMessage = "Not Found";
		Assert.assertEquals(resMessage, actMessage,
				"The value of message is not as expected in response ");
	}
	
	
	@Test(priority = 2, description = "validate get all repos functionality")
	public void validateGetAllReposFunctionality_TC003() {
		System.out.println("---------------------------------------Geting all repos ---------------------------------------------------------");
		
		Response response = apiHelper.getAllRepos();
		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK,
				"Get Repo reponse status code is not as expected.");
		Assert.assertEquals(response.getContentType(),"application/json; charset=utf-8","Get Repo content type is not as expected.");
		
		int totalRecords = response.body().jsonPath().get("size()");
		System.out.println("Total Repos =" + totalRecords);
		for(int i=0;i<totalRecords;i++) {
			String repoVisibility=response.body().jsonPath().getString("["+i+"].visibility");
			
		if(repoVisibility.equalsIgnoreCase("Public"))	{
			String publicRepo=response.body().jsonPath().getString("["+i+"].name");
			System.out.println(publicRepo);
		}
		}
	
		String actualResponse = response.jsonPath().prettyPrint();
		JsonSchemaValidate.validateSchema(actualResponse, "GetAllReposResponseSchema.json");
		
		response.then().body(
				JsonSchemaValidator.matchesJsonSchemaInClasspath("GetAllReposResponseSchema.json"));
//				System.out.println("scheme done");
	}
	
	
	
	
	
	
	
	@Test(priority = 3, description = "validate add repo functionality")
	public void validateAddDataFunctionality_TC004() {
		name = "World-"  + faker.number().numberBetween(2000, 3000);
		description = "This is your first repo!";
		homepage = "https://github.com";
		Private = false;
		System.out.println("---------------------------------------Adding new Repo " +name+ " ---------------------------------------------------------");
		
		AddRepoRequest addRepoRequest = AddRepoRequest.builder().name(name).description(description).homepage(homepage)
				.Private(Private).build();

		Response response = apiHelper.addData(addRepoRequest);
		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED,
				"Add data functionality is not working as expected.");
		Assert.assertEquals(response.as(AddRepoResponse.class).getName(), this.name,
				"The value of name is not as expected in response ");
		Assert.assertEquals(response.as(AddRepoResponse.class).getOwner().login,
				TestDataUtils.getProperty("loggedInUser"), "The value of login is not as expected in response ");
		Assert.assertEquals(response.as(AddRepoResponse.class).getOwner().type,
				TestDataUtils.getProperty("createdType"), "The value of type key is not as expected in response ");
		String actualResponse = response.jsonPath().prettyPrint();
		JsonSchemaValidate.validateSchema(actualResponse, "CreateRepoResponseSchema.json");
	}
	
	@Test(priority = 4, description = "validate negative scenario add repo functionality")
	public void validateNegativeScenarioAddDataFunctionality_TC005() {
		System.out.println("---------------------------------------Again Adding new Repo " +name+ " ---------------------------------------------------------");
			
		description = "This is your first repo!";
		homepage = "https://github.com";
		Private = false;
		AddRepoRequest addRepoRequest = AddRepoRequest.builder().name(this.name).description(description).homepage(homepage)
				.Private(Private).build();

		Response response = apiHelper.addData(addRepoRequest);
		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_UNPROCESSABLE_ENTITY,
				"Add data functionality is not working as expected.");
		String resMessage = response.body().jsonPath().get("errors[0].message");
		String actMessage = "name already exists on this account";
		Assert.assertEquals(resMessage, actMessage,
				"The value of message is not as expected in response ");
	}
	@Test(priority = 5, description = "validate update repo functionality")
	public void validateUpdateRepoFunctionality_TC006() {
		exsitingRepo=this.name;
		updatedRepo=this.name+"12";
		description= "my repository created using apis after update";
		Private = false;
		System.out.println("---------------------------------------Updating added Repo " +name+ " to " +updatedRepo+" -----------------------------------------------");
		
		UpdateRepoRequest updateRepoRequest = UpdateRepoRequest.builder().name(updatedRepo).description(description)
				.Private(Private).build();

		Response response = apiHelper.updateRepo(updateRepoRequest,TestDataUtils.getProperty("loggedInUser"),exsitingRepo);
		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK,
				"Update Repo functionality is not working as expected.");
		Assert.assertEquals(response.body().jsonPath().get("name"),updatedRepo
			, "The value of login is not as expected in response ");
	}
	
	@Test(priority = 6, description = "validate delete repo functionality")
	public void validateDeleteRepoFunctionality_TC007() {
	
//		Hello-World-109
//		Hello12345
//		Hello123456
//		World-2553

		toDeleteRepo = this.updatedRepo;
		System.out.println("---------------------------------------Deleting the Repo " +toDeleteRepo+ " -----------------------------------------------");
		
		Response response = apiHelper.deleteRepo(TestDataUtils.getProperty("loggedInUser"),toDeleteRepo);
		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_NO_CONTENT,
				"Get Repo reponse status code is not as expected.");
		
		Assert.assertEquals(response.body().prettyPrint(),""
			, "The delete response body is not as expected ");
	}
	@Test(priority = 6, description = "validate negative delete repo functionality")
	public void validateNegativeDeleteRepoFunctionality_TC008() {
	

		deletedRepo = "World-2757";
		System.out.println("---------------------------------------Deleting already deleted Repo  -----------------------------------------------");
		
		Response response = apiHelper.deleteRepo(TestDataUtils.getProperty("loggedInUser"),toDeleteRepo);
		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_NOT_FOUND,
				"Get Repo reponse status code is not as expected.");
		
		Assert.assertEquals(response.body().jsonPath().getString("message"),"Not Found"
			, "The delete response body is not as expected ");
	}
}
