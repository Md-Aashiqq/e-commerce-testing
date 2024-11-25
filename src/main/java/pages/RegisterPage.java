package pages;

import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void typeNames(String firstname, String lastname) {
        type(By.id("firstname"), firstname);
        type(By.id("lastname"), lastname);
    }

    public void typeEmail(String email) {
        type(By.id("email_address"), email);
    }

    public void typePassword(String password) {
        type(By.id("password"), password);
    }

    public void typeConfirmPassword(String password) {
        type(By.id("password-confirmation"), password);
    }

    public void clickRegister() {
        click(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button"));
    }

    public String getErrorMessage(String id) {
        return getText(By.id(id+"-error"));
    }

    public void clearAllFields() {
        driver.findElement(By.id("firstname")).clear();
        driver.findElement(By.id("lastname")).clear();
        driver.findElement(By.id("email_address")).clear();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password-confirmation")).clear();
    }

}
