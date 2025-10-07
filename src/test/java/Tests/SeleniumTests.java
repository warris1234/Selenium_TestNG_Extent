package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductsPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class SeleniumTests {

    public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeSuite
    public void setup() {
        // Initialize driver
        driver = new ChromeDriver();
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/");
        driver.manage().window().maximize();

        // Setup ExtentReports
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
    }

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
    public void HamburgerMenuToggles() throws InterruptedException {
        test = extent.createTest("Hamburger Menu Toggles", "Validate hamburger menu toggles");
        HomePage.hamburger_menu_xpath(driver); // pass driver to page
        extent.flush();
    }

    @Test(priority = 2)
    public void LinkTextToggleMenu() throws InterruptedException {
        test = extent.createTest("Link Text Toggle Menu", "Validate homepage links");
        LoginPage loginPage = new LoginPage(driver); // create instance
        loginPage.clickMenuToggleLink("Sign In Portal");
        extent.flush();
    }

    @Test(priority = 3)
    public void LoginDetails() throws InterruptedException {
        test = extent.createTest("Login Details", "Validate login functionality");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("sa", "sa");
        extent.flush();
    }

    @Test(priority = 4)
    public void ValidateFormalShoesText() throws InterruptedException {
        test = extent.createTest("Validate Formal ShoesText", "Checks Formal Shoes label");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.validateShoesText(loginPage.formalElement(), "Formal Shoes", "Formal");
        extent.flush();
    }

    @Test(priority = 5)
    public void ValidateSportsShoesText() throws InterruptedException {
        test = extent.createTest("Validate Sports ShoesText", "Checks Sports Shoes label");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.validateShoesText(loginPage.sportsElement(), "Sports", "Sports");
        extent.flush();
    }

    @Test(priority = 6)
    public void ValidateSneakersShoesText() throws InterruptedException {
        test = extent.createTest("Validate Sneakers Shoes Text", "Checks Sneakers Shoes label");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.validateShoesText(loginPage.sneakerElement(), "Sneakers", "Sneaker");
        extent.flush();
    }

    @Test(priority = 7)
    public void OnlineProductsClick() throws InterruptedException {
        test = extent.createTest("Online Products Click", "This test validates that the homepages credentials work successfully");
        HomePage.hamburger_menu_xpath(driver);
        HomePage.HomeClickButton_xpath(driver);
        HomePage.hamburger_menu_xpath(driver);
        HomePage.online_products_xpath();
        extent.flush();
    }

    @Test(priority = 8)
    public void ValidateTitlesOnProduct()  {
        test = extent.createTest("Validate Titles On Product", "This test validates that the different shoeTypes ore correct on Online  product page");
        ProductsPage.formal_Shoes_verifyTitle();
        ProductsPage.sports_Shoes_verifyTitle();
        ProductsPage.sneaker_Shoes_verifyTitle();
        extent.flush();
    }
    @Test(priority = 9)
    public void ValidateFirstFormalShoes()
    {
        test = extent.createTest("Validate First Formal Shoes", "This test validates that the  formal shoes on Online  product page");
        ProductsPage.formal_first_Shoes_dropdown_verify();
        extent.flush();
    }
    @Test(priority = 10)
    public void ValidateFirstSportsShoes() throws InterruptedException {
        test = extent.createTest("Validate First Sports Shoes", "This test validates that the  sports shoes on Online  product page");
        ProductsPage.sports_first_Shoes_dropdownVerify();
        extent.flush();
    }
    @Test(priority = 11)
    public void ValidateSneakerShoes()
    {
        test = extent.createTest("Validate First Sneaker Shoes", "This test validates that the  spark shoes on Online  product page");
        ProductsPage.sneaker_first_Shoes_drodownVerify();
        extent.flush();
    }



    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("🚀 Browser closed successfully.");
            extent.flush();
        }
    }
}
