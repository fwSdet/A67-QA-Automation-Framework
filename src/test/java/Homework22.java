import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;

import java.time.Duration;

public class Homework22 extends BaseTest {
    @Test
    public void RenamePlayListTest() {
        driver = new ChromeDriver();
        driver.get("https://qa.koel.app/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputEmail("frederick.willis@testpro.io");
        //inputEmail("frederick.willis@testpro.io");
        loginPage.enterPassword("te$t$tudent");
        loginPage.clickSubmit();

        //loginButton();
        //deletePlaylist();
        //playNextButton();
        //clickPlay();
        HomePage homePage = new HomePage(driver);
        homePage.doubleClickPlaylist();
        homePage.enterNewPlaylistName();


        Assert.assertTrue(getRenamePlaylistSuccessMsg());
    }
}





