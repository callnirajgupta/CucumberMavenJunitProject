package com.cucumberJunit.common;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumberJunit.util.WebConnector;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoblaStepDefinition {
	private static final Logger logger = Logger
			.getLogger(GoblaStepDefinition.class);

	private static WebConnector web = WebConnector.getInstance();



	@Before(order = 0)
	public void Setup(Scenario scenario) {
		System.out.println("before setup");
		String scenarioName = scenario.getName();
		System.out.println("print scenario name " + scenarioName);

		Collection<String> col = scenario.getSourceTagNames();
		// Iterator it= col.iterator();
		for (String tagname : col) {

			System.out.println("print tagname " + tagname);

		}
	}

	@Given("^user enter the  url \"(.*?)\"$")
	public void user_enter_the_url(String url) throws Throwable {

		System.out.println("user enter the  url " + url);
	}

	@When("^user enter the username \"(.*?)\" and password \"(.*?)\"$")
	public void user_enter_the_username_and_password(String userName,
			String password) throws Throwable {

		System.out.println("user enter the username " + userName
				+ " and  password " + password);

	}

	@Then("^user should able to login into \"(.*?)\"$")
	public void user_should_able_to_login_into(String portal) throws Throwable {

		System.out.println("user should able to login into " + portal);

	}

	@Given("^I am a Facebook user$")
	public void i_am_a_Facebook_user() throws Throwable {

	}

	@When("^I enter my username$")
	public void i_enter_my_username() throws Throwable {

	}

	@When("^I enter my password$")
	public void i_enter_my_password() throws Throwable {

	}

	@Then("^login should be successful\\.$")
	public void login_should_be_successful() throws Throwable {

	}

	@Then("^home page should not be missing\\.$")
	public void home_page_should_not_be_missing() throws Throwable {

	}

	@Given("^open browser$")
	public void open_browser() throws Throwable {

		
		System.out.println(" background tag");
	}

	@Given("^I am on a new user registration page$")
	public void i_am_on_a_new_user_registration_page() throws Throwable {

	}

	@When("^I enter valid data on the page$")
	public void i_enter_valid_data_on_the_page(List<String> table)
			throws Throwable {
		
		for (String a : table)
			System.out.println("print " + a);
	}

	@Then("^the user registration should be successful\\.$")
	public void the_user_registration_should_be_successful() throws Throwable {

	}

	@When("^I enter valid data on the page registration page$")
	public void i_enter_valid_data_on_the_page_registration_page(Map<String, String> table) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)
		System.out.println("print keys value" + table.get("First Name"));
		System.out.println("print the last name "+table.get("Last Name"));

	}

	@When("^I enter valid data on the page registration page without knowing keys fields$")
	public void i_enter_valid_data_on_the_page_registration_page_without_knowing_keys_fields(
			DataTable table) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)
		List<List<String>> data = table.raw();
		System.out.println("pring keys and value " + data.get(1).get(0)
				+ "  value " + data.get(1).get(1));
		
		
	}

	@Given("^execute some some step before this given$")
	public void execute_some_some_step_before_this_given() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("execute some some step before this given ");
		web.getDriver().get("http://www.google.com");
		Assert.assertFalse("", true);
	}
	
	@Given("^i am fine$")
	public void given(){
		
		System.out.println("i am fine");
		
	}
	
	@When("^thing is ok$")
	public void When(){
		System.out.println("thing is ok");
	}
	
	@Given("^execute some some step before this given for number (\\d+)$")
	public void execute_some_some_step_before_this_given_for_number(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

System.out.println("print the integer passed "+arg1);
	}

	@After(order = 1)
	public void TearDown(Scenario scenario) {
		System.out.println("Tear down");
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) web.getDriver())
					.getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png"); // stick it in the report
		}
	}
}
