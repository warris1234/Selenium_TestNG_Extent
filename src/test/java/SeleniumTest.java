import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class SeleniumTest {

    public static ChromeOptions options;
    public static WebDriver driver;

    @BeforeClass
    void setup() {
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/");
        System.out.println("✅ Browser launched and URL opened successfully.");
    }

    @Test(priority = 1)
    public void testSteps() throws InterruptedException {
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.xpath("//div[@id='menuToggle']/input"));
        element.click();
        System.out.println("✅ Menu toggle clicked successfully.");
    }

    @Test(priority = 2, dependsOnMethods = {"testSteps"})
    public void LinksText() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("🔗 Number of links: " + links.size());

        for (WebElement link : links) {
            String linkText = link.getText().trim();
            System.out.println("Link Text: " + linkText);

            if (linkText.equalsIgnoreCase("Sign In Portal")) {
                link.click();
                System.out.println("✅ Clicked on 'Sign In Portal' link.");
                break;
            }
        }
    }

    @Test(priority = 3, dependsOnMethods = {"LinksText"})
    public void LoginDetails() throws InterruptedException {
        Thread.sleep(2000);
        WebElement username = driver.findElement(By.id("usr"));
        WebElement pwd = driver.findElement(By.id("pwd"));
        WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));

        username.sendKeys("sa");
        pwd.sendKeys("sa");
        login.click();
        System.out.println("✅ Login attempted with username and password.");
    }

    @Test(priority = 4, dependsOnMethods = {"LoginDetails"})
    public void TestTest() throws InterruptedException {
        Thread.sleep(1000);
        WebElement element = driver.findElement(By.xpath("(//h3[@id='ShoeType'])[1]"));

        String expected = "Formal Shoes";
        String actualText = element.getText();

        Assert.assertEquals(actualText, expected, "❌ Shoe type text does not match!");

        System.out.println("✅ Expected Shoe Type: " + expected);
        System.out.println("✅ Actual Shoe Type: " + actualText);
        System.out.println("✅ Text verification successful: 'Formal Shoes' is displayed correctly.");
    }

    @AfterClass
    void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("🚀 Browser closed successfully.");
        }
    }
}
