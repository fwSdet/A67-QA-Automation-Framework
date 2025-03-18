package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submitButton = By.cssSelector("button[type='submit']");

    public void enterEmail(String email) {
        findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        findElement(passwordField).sendKeys(password);
    }

    public void clickSubmit() {
        findElement(submitButton).click();
    }

    public void clickLogin() {
        enterEmail("frederick.willis@testpro.io");
        enterPassword("te$t$tudent");
        clickSubmit();

    }

}
