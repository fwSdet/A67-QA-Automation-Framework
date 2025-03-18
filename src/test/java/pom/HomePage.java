package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

            By userAvatarIcon = By.cssSelector("img.avatar");

    public WebElement getUserAvatar() {
         return driver.findElement(userAvatarIcon);
}
    @FindBy(css = ".playlist:nth-child(3)")
    WebElement playlist;

    public void doubleClickPlaylist() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Corrected the method to locate the element
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOf(playlist));
        new Actions(driver).doubleClick(playlistElement).perform();
    }
    public String newPlaylistName = "Edited Playlist";

    @FindBy(css = "[name='name']")
    WebElement newName;

    public void enterNewPlaylistName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Corrected the method to locate the element
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOf(newName));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }
}
