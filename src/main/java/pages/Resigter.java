package pages;

import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Resigter extends BasePage {

    public Resigter(WebDriver driver) {
        super(driver);
    }

    public void register() {
        click(By.linkText("Register"));
    }

}
