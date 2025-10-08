package Pages;

import Tests.SeleniumTests;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static Tests.SeleniumTests.ScreenshotUtil.capture;
import static Tests.SeleniumTests.driver;
import static Tests.SeleniumTests.test;

public class SignUpPage {
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    public static WebElement newRegistration() {
        return driver.findElement(By.id("NewRegistration"));
    }
    public static List<WebElement> getOption() {
        return driver.findElements(By.xpath("//div//div[@class='dropdown']//child::option"));
    }

    public static String verifyUserReg = "//center//h1";
    public static String firstName = "//input[@name='firstname']";
    public static String lastName = "//input[@name='lastname']";
    public static String emailId = "//input[@name='emailId']";
    public static String contactNumber = "//input[@id='contactNumber']";
    public static String userName = "//input[@id='usr']";
    public static String userPwd = "//input[@id='pwd']";
    public static String submitbtn = "//input[@type='submit']";
    public static String successfulText = "//h1[contains(text(),'User Registered Successfully !!!')]";



    public static void NewRegistration() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(newRegistration()));
        newRegistration().click();
        test.log(Status.PASS,test.addScreenCaptureFromPath(capture(SeleniumTests.driver))+"Test Passed");
    }
    public static void ClickOption(String optionText) {

        wait.until(ExpectedConditions.visibilityOfAllElements(getOption()));

        List<WebElement> options = getOption();
        System.out.println("🔗 Number of options: " + options.size());
        boolean isClicked = false;

        for (WebElement option : options) {
            String text = option.getText().trim();
            if (text.equalsIgnoreCase(optionText.trim())) {
                option.click();
                System.out.println("✅ Clicked on '" + optionText + "' option.");
                test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + " Test Passed");
                isClicked = true;
                break;
            }
        }

        if (!isClicked) {
            System.out.println("❌ Option '" + optionText + "' not found.");
            test.log(Status.FAIL, "Option '" + optionText + "' not found.");
            Assert.fail("Option '" + optionText + "' not found in the list.");
        }
    }

    public static void VerifyUserReg()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(verifyUserReg)));
        String actualTile = driver.findElement(By.xpath(verifyUserReg)).getText();
        String expectedTitle = "User Registration Page";
        Assert.assertEquals(actualTile, expectedTitle);
        if(expectedTitle.equals(actualTile))
        {
            test.log(Status.PASS,"Test passed for Verify User Registration Page");
            test.log(Status.PASS,test.addScreenCaptureFromPath(capture(driver))+"Test Passed");
        }
        else
        {
            // test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());
            test.log(Status.FAIL,"Test fail for Verify User Registration Page");
        }
    }
    public static void FirstName()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstName)));
        driver.findElement(By.xpath(firstName)).sendKeys("war");
        driver.findElement(By.xpath(lastName)).sendKeys("waisu");
        driver.findElement(By.xpath(emailId)).sendKeys("waisu@gmail.com");
        driver.findElement(By.xpath(contactNumber)).sendKeys("9837647245");
        driver.findElement(By.xpath(userName)).sendKeys("sar");
        driver.findElement(By.xpath(userPwd)).sendKeys("sarr");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(submitbtn)));
        driver.findElement(By.xpath(submitbtn)).click();
        test.log(Status.PASS,test.addScreenCaptureFromPath(capture(SeleniumTests.driver))+"Test Passed");
    }
    public static void SuccessfulText()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(successfulText)));
        String actualTileuser = driver.findElement(By.xpath(successfulText)).getText();
        String expectedTitleuser = "User Registered Successfully !!!";
        Assert.assertEquals(actualTileuser, expectedTitleuser);
        if(expectedTitleuser.equals(actualTileuser))
        {
            test.log(Status.PASS,"Test passed for Verify User Registered Successfully !!!");
            test.log(Status.PASS,test.addScreenCaptureFromPath(capture(driver))+"Test Passed");
        }
        else
        {
            // test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());
            test.log(Status.FAIL,"Test fail for Verify User Registered Successfully !!!");
        }
    }

}
