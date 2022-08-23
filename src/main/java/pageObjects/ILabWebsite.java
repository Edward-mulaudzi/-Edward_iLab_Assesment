package pageObjects;

import java.util.HashMap;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import reusableMethods.ActionMethods;
import testBase.DriverFactory;
import testBase.TestBase;

public class ILabWebsite extends TestBase{
	ActionMethods Action = new ActionMethods();
	By cereers = By.xpath("(//a[@href='https://www.ilabquality.com/careers/'])[1]");
	By southAfrica = By.xpath("//a[@href='/careers/south-africa/']");
	By firstJob = By.xpath("(//a[@class='wpjb-job_title wpjb-title'])[1]");
	By apply = By.xpath("//a[@class='wpjb-button wpjb-form-toggle wpjb-form-job-apply']");
	By name = By.xpath("//input[@id='applicant_name']");
	By email = By.xpath("//input[@id='email']");
	By phone = By.xpath("//input[@id='phone']");
	By submit = By.xpath("//input[@id='wpjb_submit']");
	By validationMessage = By.xpath("//li[normalize-space()='You need to upload at least one file.']");

	@SneakyThrows
	public void FillinTheFields (HashMap<String, String> testData) {

		Action.click_custom(DriverFactory.getInstance().getDriver().findElement(cereers), "Career");
		JavascriptExecutor executors = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executors.executeScript("window.scrollBy(0,300)");
		Action.click_custom(DriverFactory.getInstance().getDriver().findElement(southAfrica), "SouthAfrica");
		Action.click_custom(DriverFactory.getInstance().getDriver().findElement(firstJob), "Click on the First Job");
		executors.executeScript("window.scrollBy(0,600)");
		Action.click_custom(DriverFactory.getInstance().getDriver().findElement(apply), "Apply Button");
		Action.sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(name),"Name Field",testData.get("Name"));
		Action.sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(email),"Email Field",testData.get("Email"));
		Action.sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(phone),"Phone Number",Action.generatePhoneNumber());
		Action.click_custom(DriverFactory.getInstance().getDriver().findElement(submit), "Submit Button");
		executors.executeScript("window.scrollBy(0,300)");
		String actualtedResults = Action.getText_custom(DriverFactory.getInstance().getDriver().findElement(validationMessage),"Validation Message");
		Action.assertEqualsString_custom("You need to upload at least one file.",actualtedResults,"Validation Message");
		;

	}
}
