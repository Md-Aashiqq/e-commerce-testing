import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RegisterPage;
import utilities.UtilityMethods;

import java.util.logging.Logger;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RegsiterTest {

    static WebDriver driver;
    static Logger logger;
    static RegisterPage registerPage;
    static String email;
    static String password ;
    static UtilityMethods utilityMethods = new UtilityMethods();

    @BeforeAll
    public static void setup(){
        driver = new ChromeDriver();
        logger = Logger.getLogger("RegsiterTest");
        registerPage = new RegisterPage(driver);
        email = utilityMethods.generateRandomEmail();
        password = utilityMethods.generateRandomPassword();
    }

//    Enter all the validate data in the register form and click on the register button.

    @BeforeEach
    public void goToRegisterPage(){
        logger.info("Navigating to the register page");
        driver.manage().deleteAllCookies();
        registerPage.goToUrl("https://magento.softwaretestingboard.com/customer/account/create/");
        registerPage.clearAllFields();
    }


    @Test
    @Order(1)
    public void registerTestWithInvalidEmail() throws InterruptedException {
        logger.info("Testing with invalid email");
        registerPage.typeEmail("invalidemail.com");
        registerPage.clickRegister();
        String errorMessage = registerPage.getErrorMessage("email_address");
        Assert.assertEquals("Please enter a valid email address (Ex: johndoe@domain.com).", errorMessage);
    }

    @Test
    @Order(2)
    public void registerTest() throws InterruptedException {
        registerPage.typeNames("John", "Doe");
        registerPage.typeEmail(email);
        registerPage.typePassword(password);
        registerPage.typeConfirmPassword(password);
        registerPage.clickRegister();

        registerPage.wait(5000);

        String pageTitle = registerPage.getTittle();
        Assert.assertEquals("My Account", pageTitle);
    }



    @AfterAll
    public static void tearDown(){
        driver.quit();
    }

}
