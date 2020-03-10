package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Day2StepDefinition {

	WebDriver driver;

	@Given("User on the adaction hotel booking home page")
	public void user_on_the_adaction_hotel_booking_home_page() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\eclipse-workspace\\sundar\\NewCucumberPtoejct\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://adactin.com/HotelApp/");

	}

	@When("User enters the {string}, {string}")
	public void user_enters_the(String userName, String password) {

		// Enter the UserName
		WebElement txtuserName = driver.findElement(By.id("username"));
		txtuserName.sendKeys(userName);

		// Enter the Password
		WebElement txtpassword = driver.findElement(By.id("password"));
		txtpassword.sendKeys(password);

	}

	@When("User should click on loging button")
	public void user_should_click_on_loging_button() {
		// Click the Login Button
		WebElement btnLoging = driver.findElement(By.id("login"));
		btnLoging.click();

	}

	@When("User enters the {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void user_enters_the(String location, String hotels, String roomType, String numberOfRooms,
			String checkInDate, String checkOutDate, String adultsPerRoom, String childrenPerRoom) {

		// Select the Location of Hotel
		WebElement selectlocation = driver.findElement(By.id("location"));
		Select sl = new Select(selectlocation);
		sl.selectByVisibleText(location);

		// Select the Hotels
		WebElement selecthotels = driver.findElement(By.id("hotels"));
		Select sh = new Select(selecthotels);
		sh.selectByValue(hotels);

		// Select the Room Type
		WebElement selectRoomType = driver.findElement(By.id("room_type"));
		Select srt = new Select(selectRoomType);
		srt.selectByVisibleText(roomType);

		// Select the Number Of Rooms
		WebElement selectNumberOfRooms = driver.findElement(By.id("room_nos"));
		Select snor = new Select(selectNumberOfRooms);
		snor.selectByValue(numberOfRooms);

		// Enter the Check In Date
		WebElement txtCheckInDate = driver.findElement(By.name("datepick_in"));
		txtCheckInDate.sendKeys(checkInDate);

		// Enter the Check Out Date
		WebElement txtCheckOutDate = driver.findElement(By.name("datepick_out"));
		txtCheckOutDate.sendKeys(checkOutDate);

		// Select the How many adults in the Room
		WebElement selectAdultsPerRoom = driver.findElement(By.id("adult_room"));
		Select sapr = new Select(selectAdultsPerRoom);
		sapr.selectByValue(adultsPerRoom);

		// Select the How many childrens in the Room
		WebElement selectChildrenPerRoom = driver.findElement(By.id("child_room"));
		Select scpr = new Select(selectChildrenPerRoom);
		scpr.selectByVisibleText(childrenPerRoom);

	}

	@When("User click on the search button")
	public void user_click_on_the_search_button() {

		// Click the Search button for searching rooms in hotel
		WebElement btnSearch = driver.findElement(By.id("Submit"));
		btnSearch.click();
	}

	@When("User click to select the hotel and click on continue button")
	public void user_click_to_select_the_hotel_and_click_on_continue_button() {

		// Check all the details and select it
		WebElement tickRadioButton = driver.findElement(By.id("radiobutton_0"));
		tickRadioButton.click();

		// Click to continue to move next page
		WebElement btnContinue = driver.findElement(By.name("continue"));
		btnContinue.click();

	}

	@When("User now enter the {string} , {string} , {string} , {string} , {string}, {string}, {string}, {string}")
	public void user_now_enter_the(String firstName, String lastName, String billingAddress, String creditCardNo,
			String creditCardType, String expiryMonth, String expiryYear, String cvvNumber) {

		// Enter the First Name
		WebElement txtFirstName = driver.findElement(By.id("first_name"));
		txtFirstName.sendKeys(firstName);

		// Enter the Last Name
		WebElement txtLastName = driver.findElement(By.name("last_name"));
		txtLastName.sendKeys(lastName);

		// Enter the Billing Address
		WebElement txtBillingAddress = driver.findElement(By.id("address"));
		txtBillingAddress.sendKeys(billingAddress);

		// Enter the credit card number for bill payment
		WebElement txtCreditCardNo = driver.findElement(By.id("cc_num"));
		txtCreditCardNo.sendKeys(creditCardNo);

		// Select the Credit card type
		WebElement selectCreditCardType = driver.findElement(By.id("cc_type"));
		Select scct = new Select(selectCreditCardType);
		scct.selectByValue(creditCardType);

		// Select Credit card expire month
		WebElement selectExpiryMonth = driver.findElement(By.id("cc_exp_month"));
		Select sem = new Select(selectExpiryMonth);
		sem.selectByValue(expiryMonth);

		// // Select Credit card expire year
		WebElement selectExpiryYear = driver.findElement(By.id("cc_exp_year"));
		Select sey = new Select(selectExpiryYear);
		sey.selectByVisibleText(expiryYear);

		// Enter the CVV Number
		WebElement txtCVVnumber = driver.findElement(By.id("cc_cvv"));
		txtCVVnumber.sendKeys(cvvNumber);

	}

	@When("User now click on the booknow button and wait Order No.")
	public void user_now_click_on_the_booknow_button_and_wait_Order_No() {

		WebElement btnBookNow = driver.findElement(By.id("book_now"));
		btnBookNow.click();

		// Error occur in this part. Pls verify
		// WebElement textOrderNo =
		// driver.findElement(By.xpath("//input[@name='order_no']"));
		// String OrderNo = textOrderNo.getAttribute("Value");
		// System.out.println(OrderNo);

	}

	@Then("User should verify the booking details.")
	public void user_should_verify_the_booking_details() {

		// String title = driver.getTitle();
		// boolean a = title.contains("Adactin");
		// Assert.assertTrue("Verify the Hotel Page", a);

		String currentUrl = driver.getCurrentUrl();
		boolean b = currentUrl.contains("https://adactin.com/HotelApp/");
		Assert.assertTrue("Verify the Current URL in Hotel Page", b);

	}

}
