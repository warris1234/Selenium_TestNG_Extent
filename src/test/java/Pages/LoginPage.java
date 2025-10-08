package Pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static Tests.SeleniumTests.ScreenshotUtil.capture;
import static Tests.SeleniumTests.driver;
import static Tests.SeleniumTests.test;

public class LoginPage {

    static WebDriver driver;
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locate elements when needed
    public List<WebElement> getLinks() {
        return driver.findElements(By.tagName("a"));
    }

    public WebElement usernameField() {
        return driver.findElement(By.id("usr"));
    }


    public WebElement passwordField() {
        return driver.findElement(By.id("pwd"));
    }

    public WebElement loginButton() {
        return driver.findElement(By.xpath("//input[@type='submit']"));
    }

    public WebElement formalElement() {
        return driver.findElement(By.xpath("(//h3[@id='ShoeType'])[1]"));
    }

    public WebElement sportsElement() {
        return driver.findElement(By.xpath("(//h3[@id='ShoeType'])[2]"));
    }

    public WebElement sneakerElement() {
        return driver.findElement(By.xpath("(//h3[@id='ShoeType'])[3]"));
    }

    // Methods
    public void clickMenuToggleLink(String linkText) throws InterruptedException {
     wait.wait(1000);
        List<WebElement> links = getLinks();
        System.out.println("🔗 Number of links: " + links.size());

        for (WebElement link : links) {
            if (link.getText().trim().equalsIgnoreCase(linkText)) {
                link.click();
                System.out.println("✅ Clicked on '" + linkText + "' link.");
                test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "Test Passed");
                break;
            }
        }
    }



    public void login(String username, String password) throws InterruptedException {
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(verifyUserReg)));
       // Thread.sleep(2000);
        wait.wait(1000);
        usernameField().sendKeys("sa");
        passwordField().sendKeys("sa");
        loginButton().click();
        System.out.println("✅ Login attempted with username and password.");
        test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "Test Passed");
    }

    public void validateShoesText(WebElement element, String expectedText, String type) throws InterruptedException {
        wait.wait(1000);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(verifyUserReg)));
        String actualText = element.getText();

        if (expectedText.equals(actualText)) {
            test.log(Status.PASS, "Test passed for " + type);
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "Test Passed");
        } else {
            test.log(Status.FAIL, "Test fail for " + type + "_verifyTitle");
        }
    }
}
