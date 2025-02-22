import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework18 extends BaseTest {
    @Test
    public void Homework18Test() {
        driver = new ChromeDriver();
        driver.get("https://qa.koel.app/");
        inputEmail("frederick.willis@testpro.io");
        inputPassword("te$t$tudent");

        loginButton();
        playNextButton();
        //clickPlay();
        Assert.assertTrue(isSongPlaying());
    }

}