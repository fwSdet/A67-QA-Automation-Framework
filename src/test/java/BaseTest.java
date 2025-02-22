//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

import org.bouncycastle.operator.bc.BcSignerOutputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class BaseTest {
    WebDriver driver;

    public BaseTest() {
    }

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    public void searchSong(String strname) throws InterruptedException {
        WebElement searchBox = this.driver.findElement(By.name("q"));
        searchBox.sendKeys(new CharSequence[]{strname});
        Thread.sleep(2000L);
    }

    public void clickViewAllBtn() throws InterruptedException {
        WebElement clickViewAllBtn = this.driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        clickViewAllBtn.click();
        Thread.sleep(2000L);
    }

    public void selectFirstSongResult() throws InterruptedException {
        WebElement selectFirstSongResult = this.driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item']"));
        selectFirstSongResult.click();
        Thread.sleep(2000L);
    }
     // input email for koel.app
    public void inputEmail(String Email) {
        WebElement emailField = this.driver.findElement(By.cssSelector("input[type = 'email']"));
        emailField.clear();
        emailField.sendKeys(new CharSequence[]{Email});
    }

    public void inputPassword(String Pass) {
        WebElement passwordField = this.driver.findElement(By.cssSelector("input[type = 'password']"));
        passwordField.clear();
        passwordField.sendKeys(new CharSequence[]{Pass});
    }

    public void clickAddToBtn() {
        WebElement addToBtn = this.driver.findElement(By.cssSelector("[data-test='add-to-btn']"));
        addToBtn.click();
    }

    public void loginButton() {
        WebElement submitLogin = this.driver.findElement(By.cssSelector("button[type='submit']"));
        submitLogin.click();
        try {
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String choosePlayList() {
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        WebElement choosePlayList = this.driver.findElement(By.className("playlist"));
        if (choosePlayList != null) {
            choosePlayList.click();
        }

        return "FredPlaylist";
    }

    public void navigateToPage() {
        this.driver.navigate().to("https://qa.koel.app");
        System.out.println("visited koel page");
    }

    public String getAddToPlayListSuccessMsg() {
        String s = "Added 1 song into FredPlaylist";
        return s;
    }
    public void clickPlay() {

        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));

        playButton.click();

    }

    public boolean isSongPlaying(){
        WebElement soundbar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        return soundbar.isDisplayed();

    }

    public void playNextButton(){
       // WebElement playButton = driver.findElement(By.cssSelector("span.album-thumb-wrapper > span.album-thumb"));
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
// Create an instance of Actions class
        Actions actions = new Actions(driver);

// Move to the play button to hover over it
        actions.moveToElement(playButton).perform();
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        playButton.click();

    }
    public boolean deletePlaylist()  {
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        List<WebElement> links = driver.findElements(By.cssSelector("section li.playlist a:not([name='x']):not([name='y'])"
        ));
        WebElement choosePlayList = links.get(2); // gets the third element
        //WebElement choosePlayList = this.driver.findElement(By.cssSelector("li.playlist.playlist.playlist"));
        String playlistName = choosePlayList.getText();
        System.out.println(playlistName);
        choosePlayList.click();

        WebElement deleteButton = driver.findElement(By.cssSelector("button.del.btn-delete-playlist[title='Delete this playlist']"));
        //WebElement deleteBtn = this.driver.findElement(By.xpath("//button[@data-testid='delete-btn']"));
        deleteButton.click();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1L));
       try {
           WebElement okButton = driver.findElement(By.cssSelector("button.ok[tabindex='1']"));
           if (okButton != null) {

               okButton.click();
               try {
                   Thread.sleep(3000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
       }
       catch (Exception e) {

       }
        //WebElement okButton = driver.findElement(By.cssSelector("button.ok[title='Ok']"));

        WebElement alertMessage = driver.findElement(By.cssSelector("div.success.show"));
        //Assert.assertEquals(getDeletedPlaylistMsg(), expectedPlaylistDeletedMessage);
        String alertText = alertMessage.getText();
        System.out.println(alertText);
        Pattern pattern = Pattern.compile("\"([^\\\"]*?)([.])?\"");
        Matcher matcher = pattern.matcher(alertText);
        String messagePlaylist = "";


        if (matcher.find()) {
            messagePlaylist = matcher.group(1);
            System.out.println(messagePlaylist);
        }
        if (messagePlaylist.equals(playlistName)) {
            return true;
        } else {
            return false;
        }

    }
}
