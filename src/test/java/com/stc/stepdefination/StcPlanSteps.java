package com.stc.stepdefination;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.stc.BaseClass;
import com.stc.WaitClass;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;

public class StcPlanSteps extends BaseClass {

	public static WebDriver driver;
	public static String browserName = "chrome";
	public static String browserVersion = "116";
	public static String url = "https://subscribe.stctv.com/sa-ar?";

	public static WaitClass waitClassObject = new WaitClass();
	public static Duration pageLoadDuration = Duration.ofSeconds(60);
	public static Duration implicitWaitDuration = Duration.ofSeconds(30);
	public static Duration explicitWaitDuration = Duration.ofSeconds(40);

	// ENGLISH BUTTON
	public static String translateToEnglishButton = "//a[@id='translation-btn']";
	public static By englishButtonLocator = By.xpath(translateToEnglishButton);

	// COUNTRY BUTTON
	public static String countryButton = "//span[@id='country-name']";
	public static By countryButtonLocator = By.xpath(countryButton);
	
	// SELECTING BAHRAIN COUNTRY
	public static String countryButtonBahrain = "//div[@id='bh-contry-flag']//img[@alt='bh']";
	public static By countryButtonBahrainLocator = By.xpath(countryButtonBahrain);

	// SELECTING KSA COUNTRY
	public static String countryButtonKSA = "//div[@id='sa-contry-flag']//img[@alt='sa']";
	public static By countryButtonKSALocator = By.xpath(countryButtonKSA);

	// SELECTING KUWAIT COUNTRY
	public static String countryButtonKuwait = "//div[@id='kw-contry-flag']//img[@alt='kw']";
	public static By countryButtonKuwaitLocator = By.xpath(countryButtonKuwait);	

	// LITE PLAN TRIAL BUTTON
	public static String trialButtonLite = "//a[@id='lite-selection']";
	public static By trialButtonLiteLocator = By.xpath(trialButtonLite);

	// CLASSIC PLAN TRIAL BUTTON
	public static String trialButtonClassic = "//a[@id='classic-selection']";
	public static By trialButtonClassicLocator = By.xpath(trialButtonClassic);

	// PREMIUM PLAN TRIAL BUTTON
	public static String trialButtonPremium = "//a[@id='premium-selection']";
	public static By trialButtonPremiumLocator = By.xpath(trialButtonPremium);

	// PLAN NAME
	public static String result = "";
	public static String fullName = "";
	public static String name = "";
	public static List<String> planList = Arrays.asList("Lite", "Classic", "Premium");
	public static List<String> planListResult = new ArrayList<>();
	public static String convertListToString = "";
	public static String planName = "//span[@id='order-tier-name']";
	public static By planNameLocator = By.xpath(planName);

	// PLAN PRICE AND CURRENCY
	public static String price = "";
	public static String currency = "";
	public static String planPriceAndCurrency = "//span[@id='order-tier-price']";
	public static By planPriceAndCurrencyLocator = By.xpath(planPriceAndCurrency);	

	@Given("I launch chrome browser")
	public void i_launch_chrome_browser() {
		driver = BaseClass.getDriver(browserName, browserVersion);
		waitClassObject.pageLoadTimeout(driver, pageLoadDuration);
		waitClassObject.implicitWait(driver, implicitWaitDuration);
		driver.manage().window().maximize();
	}

	@When("I open stc tv plan page")
	public void i_open_stc_tv_plan_page() {
		driver.get(url);
	}

	@Then("I clicked on the translate button of type English")
	public void i_clicked_on_the_translate_button_of_type_english() {
		WebElement englishButtonElement = driver.findElement(englishButtonLocator);
		waitClassObject.explicitWaitClick(driver, explicitWaitDuration, englishButtonElement);
		englishButtonElement.click();
	}

	@Then("Based on country {string} and the plan {string}")
	public void based_on_country_select_the_plan(String country, String plan) {
		if (country.equalsIgnoreCase("Bahrain")) {
			// Click on the existing country button
			WebElement countryButtonElement = driver.findElement(countryButtonLocator);
			waitClassObject.explicitWaitClick(driver, explicitWaitDuration, countryButtonElement);
			countryButtonElement.click();

			WebElement selectCountryBahrainElement = driver.findElement(countryButtonBahrainLocator);
			waitClassObject.explicitWaitClick(driver, explicitWaitDuration, selectCountryBahrainElement);
			selectCountryBahrainElement.click();
			
			//Here we are comparing Plan, Price and Currency.
			verify(plan);

		} else if (country.equalsIgnoreCase("KSA")) {
			// Click on the existing country button
			WebElement countryButtonElement = driver.findElement(countryButtonLocator);
			waitClassObject.explicitWaitClick(driver, explicitWaitDuration, countryButtonElement);
			countryButtonElement.click();

			WebElement selectCountryKsaElement = driver.findElement(countryButtonKSALocator);
			waitClassObject.explicitWaitClick(driver, explicitWaitDuration, selectCountryKsaElement);
			selectCountryKsaElement.click();
			
			//Here we are comparing Plan, Price and Currency.
			verify(plan);

		} else if (country.equalsIgnoreCase("Kuwait")) {
			// Click on the existing country button
			WebElement countryButtonElement = driver.findElement(countryButtonLocator);
			waitClassObject.explicitWaitClick(driver, explicitWaitDuration, countryButtonElement);
			countryButtonElement.click();

			WebElement selectCountryKuwaitElement = driver.findElement(countryButtonKuwaitLocator);
			waitClassObject.explicitWaitClick(driver, explicitWaitDuration, selectCountryKuwaitElement);
			selectCountryKuwaitElement.click();
			
			//Here we are comparing Plan, Price and Currency.
			verify(plan);

		} else {
			System.out.println("Please provide a valid country!");
		}
	}

	@Given("I close the browser")
	public void close_browser() {
		BaseClass.quitDriver();
	}

	public static WebElement getLitePlan(String plan) {
		// Click on lite plan TRIAL button
		WebElement trialButtonLiteElement = driver.findElement(trialButtonLiteLocator);
		waitClassObject.explicitWaitClick(driver, explicitWaitDuration, trialButtonLiteElement);
		trialButtonLiteElement.click();
		return trialButtonLiteElement;
	}

	public static WebElement getClassicPlan(String plan) {
		// Click on classic plan TRIAL button
		WebElement trialButtonClassicElement = driver.findElement(trialButtonClassicLocator);
		waitClassObject.explicitWaitClick(driver, explicitWaitDuration, trialButtonClassicElement);
		trialButtonClassicElement.click();
		return trialButtonClassicElement;
	}

	public static WebElement getPremiumPlan(String plan) {
		// Click on premium plan TRIAL button
		WebElement trialButtonPremiumElement = driver.findElement(trialButtonPremiumLocator);
		waitClassObject.explicitWaitClick(driver, explicitWaitDuration, trialButtonPremiumElement);
		trialButtonPremiumElement.click();
		return trialButtonPremiumElement;
	}

	public static String getPlanNameOnly(String planNameFull) {
		// Find the index of the colon
		int colonIndex = planNameFull.indexOf(":");
		if (colonIndex != -1) {
			// Extract the substring after the colon
			result = planNameFull.substring(colonIndex + 1).trim();
			// Print the result
			// System.out.println("String after colon: " + result);
		} else {
			// Handle the case where there is no colon in the input string
			System.out.println("Colon not found in the input string.");
		}
		return result;
	}

	public static List<String> comparePlanName(List<String> planListLocal, String nameLocal) {
		planListResult = planListLocal.stream().filter(n -> n.equalsIgnoreCase(nameLocal)).collect(Collectors.toList());
		// System.out.println(planListResult);
		return planListResult;
	}

	public static String getPriceOnly(String planPrice) {
		// Split the string by space
		String[] parts = planPrice.split(" ");
		if (parts.length >= 1) {
			price = parts[0];
			// Print the result
			// System.out.println(price);
		} else {
			System.out.println("No number found in the string.");
		}
		return price;
	}

	public static String getCurrencyOnly(String planCurrency) {
		// Split the string by space
		String[] parts = planCurrency.split(" ");
		if (parts.length >= 2) {
			currency = parts[1];
			// Find the index of the slash
			int slashIndex = currency.indexOf("/");
			if (slashIndex != -1) {
				// Extract the substring before the slash
				result = currency.substring(0, slashIndex).trim();
				// Print the result
				// System.out.println("String before slash: " + result);
			} else {
				// Handle the case where there is no slash in the input string
				System.out.println("Slash not found in the input string.");
			}
		} else {
			System.out.println("No currency found in the string.");
		}
		return result;
	}

	public static void verify(String plan) {
		// Click on lite,classic or premium plan TRIAL button
		if (plan.equalsIgnoreCase("Lite")) {
			getLitePlan(plan);
		} else if (plan.equalsIgnoreCase("Classic")) {
			getClassicPlan(plan);
		} else if (plan.equalsIgnoreCase("Premium")) {
			getPremiumPlan(plan);
		} else {
			System.out.println("Please provide a valid plan!");
		}

		// Verifying the plan name
		WebElement planNameElement = driver.findElement(planNameLocator);
		fullName = planNameElement.getText();

		// Getting plan name
		name = getPlanNameOnly(fullName);
		System.out.println("Plan Name : " + name);

		// Comparing plan name
		planListResult = comparePlanName(planList, name);
		convertListToString = planListResult.toString();
		if (convertListToString.contains("Lite")) {
			Assert.assertTrue(true);
		} else if (convertListToString.contains("Classic")) {
			Assert.assertTrue(true);
		} else if (convertListToString.contains("Premium")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

		// Verifying the price
		WebElement planpriceElement = driver.findElement(planPriceAndCurrencyLocator);
		fullName = planpriceElement.getText();
		price = getPriceOnly(fullName);
		System.out.println("Plan Price : " + price);
		if (price != "") {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

		// Verifying the currency
		WebElement planCurrencyElement = driver.findElement(planPriceAndCurrencyLocator);
		fullName = planCurrencyElement.getText();
		currency = getCurrencyOnly(fullName);
		System.out.println("Plan Currency : " + currency);
		if (currency != "") {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
}
