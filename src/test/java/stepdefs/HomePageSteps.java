package stepdefs;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;

import ApplicationPages.Homepage;
import WebConnector.webconnector;
import cucumber.api.java.en.When;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomePageSteps extends webconnector {
    private Homepage homePage;
	private String scenDesc;

    public HomePageSteps() {
        this.homePage = new Homepage();
    }
    
    @Before
	public void before(Scenario scenario) {
		this.scenDesc = scenario.getName();
		setUpDriver();
	}
    
    @After
    public void after(Scenario scenario){
    	closeDriver(scenario);
    }
	
	@BeforeStep
	public void beforeStep() throws InterruptedException {
		Thread.sleep(2000);
	}

    @Given("^User navigates to ebay HomePage$")
    public void UserNavigatesToHomePage() throws InvalidFormatException, IOException {
        this.homePage.goToHomePage();
        
    }
    
    @When("^search for iphone11$")
    public void SearchForPhone() throws Exception {
    	this.homePage.searchApple();        
    }
    
    @When("^Add to cart$")
    public void addToCart() throws Exception {
    	this.homePage.selectApple();        
    }
     
    
    @Then("^iphone11 should be in cart$")
    public void assertItem() throws Exception {
    	assertEquals(this.homePage.assertText(), "Apple iPhone 11 64GB ATT Locked Smartphone Very Good", "item is not iphone11");
    }
}
