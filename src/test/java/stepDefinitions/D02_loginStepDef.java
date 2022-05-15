package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D02_loginStepDef {
    public static WebDriver driver = null;
@Given("user navigate to login page")
    public void navigate_login_page()
{
    driver.navigate().to("https://demo.nopcommerce.com/");



}
@When("guest user click on login tab")
public void login_tab()
{
          driver.findElement(By.className("ico-login")).click();
}
@And("user set valid email and password")
    public void set_email_password()
{
    driver.findElement(By.id("Email")).sendKeys("test@example.com");
    driver.findElement(By.id("Password")).sendKeys("P@ssw0rd");

}
@Then("user click on login button")
    public void login_button() throws InterruptedException
{
    driver.findElement(By.className("login-button")).click();
    Thread.sleep(2);
    SoftAssert soft = new SoftAssert();
    soft.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/"));
    soft.assertAll();

}
}
