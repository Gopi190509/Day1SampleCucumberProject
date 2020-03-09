package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitionClass {

	WebDriver driver;

	@Given("User on the facebook page")
	public void user_on_the_facebook_page() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\eclipse-workspace\\sundar\\NewCucumberPtoejct\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");

		String title = driver.getTitle();
		System.out.println(title);

	}

	@When("User enter the username and password")
	public void user_enter_the_username_and_password() {

		WebElement txtUserName = driver.findElement(By.id("email"));
		txtUserName.sendKeys("Gopinath");

		WebElement txtPassword = driver.findElement(By.id("pass"));
		txtPassword.sendKeys("12345");

	}

	@When("User should click on login button")
	public void user_should_click_on_login_button() {

		WebElement btnLogin = driver.findElement(By.xpath("//input[@value='Log In']"));
		btnLogin.click();
	}

	@Then("User should verify the error message")
	public void user_should_verify_the_error_message() {

		String currentUrl = driver.getCurrentUrl();
		boolean b = currentUrl.contains("login_attemp");
		Assert.assertTrue("Verify thr invalid credential", b);
	}

}
