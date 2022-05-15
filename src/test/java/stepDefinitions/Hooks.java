package stepDefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver = null;
    @Before
    public void openBrowser()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Ahmed\\IdeaProjects\\E-commerceAppAutomationProject\\src\\main\\resources\\chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.navigate().to("https://demo.nopcommerce.com/");


    }
    @After
    public void quitDriver()
    {

        driver.quit();
    }
}
