package Pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static Tests.SeleniumTests.ScreenshotUtil.capture;
import static Tests.SeleniumTests.driver;
import static Tests.SeleniumTests.test;

public class ProductsPage
{
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    //WebElement
    public static String formal_shoes_xpath = "//h2[@class='FormalShoesTitle']";
    public static String sports_shoes_xpath = "//h2[@class='SportsShoesTitle']";
    public static String sneaker_shoes_xpath = "//h2[@class='SneakerShoesTitle']";
    public static String formal_shoes_dropdown_xpath = "//i[@class='fa fa-angle-double-down formalshoedropdown']";
    public static String sports_shoes_dropdown_xpath = "//i[@class='fa fa-angle-double-down sportsshoedropdown']";
    public static String sneaker_shoes_dropdown_xpath = "//i[@class='fa fa-angle-double-down sneakershoedropdown']";
    public static String formal_shoes_table_xpath = "//table[@class='table table-striped thead-dark formalshoetable']/tbody/tr[1]/td[1]";
    public static String sports_shoes_table_xpath = "//table[@class='table table-striped thead-dark sportsshoetable']/tbody/tr[1]/td[1]";
    public static String sneaker_shoes_table_xpath = "//table[@class='table table-striped thead-dark sneakersshoetable']/tbody/tr[1]/td[1]";

// Methods
    public static void formal_Shoes_verifyTitle()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(formal_shoes_xpath)));
        String actualTileFS = driver.findElement(By.xpath(formal_shoes_xpath)).getText();
        String expectedTitleFS = "Formal Shoes";
        Assert.assertEquals(actualTileFS, expectedTitleFS);
        if(expectedTitleFS.equals(actualTileFS))
        {
            test.log(Status.PASS,"Test passed for formal_Shoes_verifyTitle");
            test.log(Status.PASS,test.addScreenCaptureFromPath(capture(driver))+"Test Passed");
        }
//        else if(false)
//        {
//        }
//        {
//            test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());
//            test.log(Status.FAIL,"Test fail for formal_Shoes_verifyTitle");
//        }
    }
    public static void sports_Shoes_verifyTitle()
    {
        String actualTileSS = driver.findElement(By.xpath(sports_shoes_xpath)).getText();
        String expectedTitleSS = "Sports Shoes";
        Assert.assertEquals(actualTileSS, expectedTitleSS);
        if(expectedTitleSS.equals(actualTileSS))
        {
            test.log(Status.PASS,"Test passed for sports_Shoes_verifyTitle");
            test.log(Status.PASS,test.addScreenCaptureFromPath(capture(driver))+"Test Passed");
        }
        else
        {
           // test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());
            test.log(Status.FAIL,"Test fail for sports_Shoes_verifyTitle");
        }
    }
    public static void sneaker_Shoes_verifyTitle()
    {
        String actualTileSeS = driver.findElement(By.xpath(sneaker_shoes_xpath)).getText();
        String expectedTitleSeS = "Sneakers";
        Assert.assertEquals(actualTileSeS, expectedTitleSeS);
        if(expectedTitleSeS.equals(actualTileSeS))
        {
            test.log(Status.PASS,"Test passed for sneaker_Shoes_verifyTitle");
            test.log(Status.PASS,test.addScreenCaptureFromPath(capture(driver))+"Test Passed");
        }
        else
        {
           // test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());
            test.log(Status.FAIL,"Test fail for sneaker_Shoes_verifyTitle");
        }
    }
    public static void formal_first_Shoes_dropdown_verify()
    {
        driver.findElement(By.xpath(formal_shoes_dropdown_xpath)).click();
        String actualTileSeS = driver.findElement(By.xpath(formal_shoes_table_xpath)).getText();
        String expectedTitleSeS = "   Classic Cheltenham";
        Assert.assertEquals(actualTileSeS, expectedTitleSeS);
        if(expectedTitleSeS.equals(actualTileSeS))
        {
            test.log(Status.PASS,"Test passed for formal_first_Shoes_dropdown_verify");
            test.log(Status.PASS,test.addScreenCaptureFromPath(capture(driver))+"Test Passed");
        }
        else
        {
           // test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());
            test.log(Status.FAIL,"Test fail for formal_first_Shoes_dropdown_verify");
        }

    }
    public static void sports_first_Shoes_dropdownVerify()
    {
        driver.findElement(By.xpath(sports_shoes_dropdown_xpath)).click();
        String actualTileSS = driver.findElement(By.xpath(sports_shoes_table_xpath)).getText();
        String expectedTitleSS = "   Ultimate";
        Assert.assertEquals(actualTileSS, expectedTitleSS);
        if(expectedTitleSS.equals(actualTileSS))
        {
            test.log(Status.PASS,"Test passed for sports_first_Shoes_dropdownVerify");
            test.log(Status.PASS,test.addScreenCaptureFromPath(capture(driver))+"Test Passed");
        }
        else
        {
          //  test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());
            test.log(Status.FAIL,"Test fail for sports_first_Shoes_dropdownVerify");
        }

    }
    public static void sneaker_first_Shoes_drodownVerify() throws InterruptedException {
        driver.findElement(By.xpath(sneaker_shoes_dropdown_xpath)).click();

        wait.withTimeout(Duration.ofDays(1000));
        String actualTileSeS = driver.findElement(By.xpath(sneaker_shoes_table_xpath)).getText();
        wait.withTimeout(Duration.ofDays(1000));
        String expectedTitleSeS = "   Archivo";
        Assert.assertEquals(actualTileSeS, expectedTitleSeS);


        if(expectedTitleSeS.equals(actualTileSeS))
        {
            test.log(Status.PASS,"Test passed for sneaker_first_Shoes_drodownVerify");
            test.log(Status.PASS,test.addScreenCaptureFromPath(capture(driver))+"Test Passed");
        }
        else
        {
           // test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());
            test.log(Status.FAIL,"Test fail for sneaker_first_Shoes_drodownVerify");
        }


    }

}
