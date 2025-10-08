package Pages;
import Tests.SeleniumTests;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Tests.SeleniumTests.ScreenshotUtil.capture;
import static Tests.SeleniumTests.driver;
import static Tests.SeleniumTests.test;

public class HomePage
{
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public static String hamburger_menu_xpath = "//div[@id='menuToggle']/input";
    public static String online_products_xpath = "//li[text()='Online Products']";
    public static String HomeClick_xpath = "//li[text()='Home']";


    public static void hamburger_menu_xpath(WebDriver driver) {
        SeleniumTests.driver.findElement(By.xpath(hamburger_menu_xpath)).click();
        test.log(Status.PASS,test.addScreenCaptureFromPath(capture(SeleniumTests.driver))+"Test Passed");
    }
    public static void HomeClickButton_xpath(WebDriver driver) throws InterruptedException {
        SeleniumTests.driver.findElement(By.xpath(HomeClick_xpath)).click();
        test.log(Status.PASS,test.addScreenCaptureFromPath(capture(SeleniumTests.driver))+"Test Passed");

    }

    public static void online_products_xpath() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(online_products_xpath)));
        driver.findElement(By.xpath(online_products_xpath)).click();

        test.log(Status.PASS,test.addScreenCaptureFromPath(capture(driver))+"Test Passed");
    }


    }

