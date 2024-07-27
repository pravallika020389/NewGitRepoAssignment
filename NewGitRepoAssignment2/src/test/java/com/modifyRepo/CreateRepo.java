package com.modifyRepo;

import org.apache.http.HttpStatus;

import com.base.APIHelper;
import com.base.BaseTest;
import com.requestPOJO.AddRepoRequest;
import com.resposePOJO.AddRepoResponse;
import com.utils.JsonSchemaValidate;
import com.utils.TestDataUtils;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CreateRepo extends BaseTest {
	APIHelper apiHelper;
	String name, description, homepage;
	Boolean Private;

	@BeforeClass
	public void beforeClass() {

		apiHelper = new APIHelper();
	}

	@Test(priority = 0, description = "validate add repo functionality")
	public void validateAddDataFunctionality() {
		name = "World123456";
		description = "This is your first repo!";
		homepage = "https://github.com";
		Private = false;
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
}