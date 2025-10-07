package Pages;

import org.openqa.selenium.By;

import static Tests.SeleniumTests.driver;

public class HomePage
{
    public static String hamburger_menu_xpath = "//div[@id='menuToggle']/input";
    public static String online_products_xpath = "//li[text()='Online Products']";


    public static void hamburger_menu_xpath() {
        driver.findElement(By.xpath(hamburger_menu_xpath)).click();
    }

    public static void online_products_xpath() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath(online_products_xpath)).click();
    }


}
