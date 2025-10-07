package Tests;

import Pages.HomePage;
import Pages.ProductsPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v138.io.IO;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class SeleniumTests
{
    public static WebDriver driver;
    //Report purpose using Extent
    static ExtentReports reports;
   public static ExtentTest test;
    static ExtentReports extent = new ExtentReports();

    @BeforeSuite
    public static void setup() {
        driver = new ChromeDriver();
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/");
        driver.manage().window().maximize();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
    }
    //screesnhot code
    public class ScreenshotUtil {

        public static String capture(WebDriver driver) {
            try {
                // Capture the screenshot as a file
                File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

                // Create a destination file with timestamp in filename
                File destFile = new File("ExecImage/" + System.currentTimeMillis() + ".png");

                // Create directories if they don’t exist
                destFile.getParentFile().mkdirs();

                // Copy the file from source to destination
                FileUtils.copyFile(srcFile, destFile);

                // Return the absolute path of the saved file
                return destFile.getAbsolutePath();

            } catch (IOException e) {
                e.printStackTrace();
                return null; // or you can throw a custom exception
            }
        }
    }
    @Test(priority = 1)
    public void LoginDetails() throws InterruptedException {
        test = extent.createTest("Home page login details", "This test validates that the homepages credentials work successfully");
        HomePage.hamburger_menu_xpath();
        HomePage.online_products_xpath();
        extent.flush();
    }

    @Test(priority = 2)
    public void ValidateTitlesOnProduct()  {
        test = extent.createTest("validate Shoe Titles on Product Page", "This test validates that the different shoeTypes ore correct on Online  product page");
        ProductsPage.formal_Shoes_verifyTitle();
        ProductsPage.sports_Shoes_verifyTitle();
        ProductsPage.sneaker_Shoes_verifyTitle();
        extent.flush();
    }
    @Test(priority = 3)
    public void ValidateFirstFormalShoes()
    {
        test = extent.createTest("validate formal shoes Titles on Product Page", "This test validates that the  formal shoes on Online  product page");
      ProductsPage.formal_first_Shoes_dropdown_verify();
        extent.flush();
    }
    @Test(priority = 4)
    public void ValidateFirstSportsShoes()
    {
        test = extent.createTest("validate Sports shoes Titles on Product Page", "This test validates that the  sports shoes on Online  product page");
        ProductsPage.sports_first_Shoes_dropdownVerify();
        extent.flush();
    }
    @Test(priority = 5)
    public void ValidateSneakerShoes()
    {
        test = extent.createTest("validate spark shoes Titles on Product Page", "This test validates that the  spark shoes on Online  product page");
        ProductsPage.sneaker_first_Shoes_drodownVerify();
        extent.flush();
    }

    @AfterSuite
    void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("🚀 Browser closed successfully.");
            extent.flush();
        }
    }
}
