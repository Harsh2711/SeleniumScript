package stepdeifination;

import DriverActions.WebDriverAction;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class MyStepdefs {
    WebDriver driver = null;

    @Before
    public void setUp(Scenario scenario) {
        WebDriverAction.setDriver();

        System.out.println("Browser setup by Thread " + Thread.currentThread().getId() + " and Driver reference is : " + WebDriverAction.getDriver());
    }

    @Given("login into application")
    public void loginIntoApplication() {
        WebDriverAction.getDriver().get("http://bhulekh.ori.nic.in/RoRView.aspx");
        WebDriverAction.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverAction.getDriver().manage().window().maximize();

        WebDriverAction.getDriver().findElement(By.xpath("//a[text()=' here. ']")).click();

        WebDriverAction.getDriver().findElement(By.xpath("//a[text()='English']")).click();

    }

    @And("select {string} value from {string} dropdown")
    public void selectValueFromDropdown(String value, String dropdown) {
        getSelectOption(value, dropdown);
    }

    private void getSelectOption(String value, String dropdown) {
        Select select = new Select( WebDriverAction.getDriver().findElement(By.xpath(String.format("//td[text()='%s']//parent::tr//select", dropdown))));
        select.selectByVisibleText(value);
    }

    @After
    public void end(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) WebDriverAction.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
        WebDriverAction.closeBrowser();
    }

    @And("wait for {int} seconds")
    public void waitForSeconds(int value) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
