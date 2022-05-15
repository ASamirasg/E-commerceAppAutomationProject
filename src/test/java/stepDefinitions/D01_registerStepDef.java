package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class D01_registerStepDef {
    public static WebDriver driver = null;
    @Given("guest user open chrome browser")
    public void open_chrome()
    {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Ahmed\\IdeaProjects\\E-commerceAppAutomationProject\\src\\main\\resources\\chromedriver");
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }
    @And("guest user navigates to home page")
    public void home_page()
    {
        driver.navigate().to("https://demo.nopcommerce.com/");
    }
    @And("guest user click on register")
    public void click_register()
    {
        driver.findElement(By.className("ico-register")).click();
    }
    @When("guest user fill personal valid data")
    public void personal_data()
    {
       driver.findElement(By.id("FirstName")).sendKeys("Ahmed");
       driver.findElement(By.id("LastName")).sendKeys("Samir");
       driver.findElement(By.id("Email")).sendKeys("test@example.com");

        String ExpectedResult = "Your registration completed";


    }
    @And("guest user fill password")
    public void fill_password()
    {
        driver.findElement(By.id("Password")).sendKeys("P@ssw0rd");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("P@ssw0rd");
    }
    @And("guest user click on register button")
    public void register_button()
    {
        driver.findElement(By.id("register-button")).click();
    }

    @Then("guest user get success message")
    public void success_msg()
    {

         Assert.assertEquals(driver.findElement(By.linkText("Your registration completed")).isDisplayed(),true);
         SoftAssert soft = new SoftAssert();
         soft.assertEquals(driver.findElement(By.linkText("Your registration completed")).isDisplayed(), true);
         soft.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/registerresult/1?returnUrl=/"));
         soft.assertTrue(driver.findElement(By.cssSelector("a[href= \"/customer/info\"][class=\"ico-account\"]")).isDisplayed());
         soft.assertAll();
    }
    @And("guest user quit driver")
    public void quit_driver()
    {
        driver.quit();
    }


}
