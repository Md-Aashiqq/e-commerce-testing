import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.util.logging.Logger;

public class LoginTest {

    static WebDriver driver;
    static Logger logger;

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        logger = Logger.getLogger("LoginTest");
    }

    @Test
    public void loginTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToUrl("https://magento.softwaretestingboard.com/customer/account/login/");

        loginPage.login("IzR2D@example.com", "");


        WebElement errorMessage = loginPage.waitForElement(By.id("pass-error"));
        logger.info(errorMessage.getText());


    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

}
