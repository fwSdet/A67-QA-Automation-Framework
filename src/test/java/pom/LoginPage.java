package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By emailField = By.cssSelector("input[type='email']");
    @FindBy(css="input[type='email']")
    WebElement inputEmail;
    By passwordField = By.cssSelector("input[type='password']");
    @FindBy(css="input[type='password']")
    WebElement inputPassword;
    //By submitButton = By.cssSelector("button[type='submit']");
    @FindBy(css="button[type='submit']")
    WebElement submitButton;
    public void enterEmail(String email) {
        //findElement(emailField).sendKeys(email);
         inputEmail.sendKeys(email);
    }

    public void enterPassword(String password) {
        //findElement(passwordField).sendKeys(password);
        inputPassword.sendKeys(password);
    }

    public void clickSubmit() {
       // findElement(submitButton).click();
        submitButton.click();
    }

    public void clickLogin() {
        enterEmail("frederick.willis@testpro.io");
        enterPassword("te$t$tudent");
        clickSubmit();

    }

}
