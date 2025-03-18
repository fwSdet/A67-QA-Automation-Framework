/*1. Create a new branch named homework-17.

2. Create a new file, Homework17.java in IntelliJ IDEA.

3. Create a test case, addSongToPlaylist() using @Test annotation and the helper/reusable methods we created.

4. Navigate to "https://qa.koel.app/".

5. Log in with your credentials.

6. Search for a song (choose any song of your choice).

7. Click 'View All' button to display the search results.

8. Click the first song in the search results.

9. Click 'ADD TO...' button.

10. Choose the playlist to add it to, (you can create a new one with a unique name).

11. Verify that a notification message appears and contains the text, "Added 1 song into [Actual Playlist Name]".

Note: Please verify using the Assert.assertEquals() method to compare the actual notification message text with the expected text. If they match, the assertion in your test will pass; otherwise, it will fail.

12. Commit your changes to the new branch homework-17

13. Push your code to the remote repository.

14. Create a pull request.

Note: Your work will be auto graded so you can continue with the next assignment in less than a minute (just refresh the results page)



When you are done with your work, click 'Add Submission' and paste your pull request (or branch) into the provided field. Here is a sample link format for the pull request to submit:

Example (DO NOT USE):
https://github.com/{your-github-username}/A40-QA-Automation-Framework/pull/1
*
 */




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


/*public class Homework17 extends BaseTest {
    @Test
    public void   addSongToPlaylist(){

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);

        WebElement emailInput = driver.findElement(By.cssSelector("input[type='email']"));

        // Optionally, interact with the input field (e.g., send keys)
        emailInput.sendKeys("frederick.willis@testpro.io");
        WebElement passwordInput = driver.findElement(By.cssSelector("input[type='password']"));

        // Optionally, interact with the input field (e.g., send keys)
        passwordInput.sendKeys("te$t$tudent"); //password
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));

        // Click the submit button
        submitButton.click();


        WebElement searchInput = driver.findElement(By.xpath("//input[@type='search']"));

        // Optionally, interact with the search input (e.g., typing a search term)
        searchInput.sendKeys("dark");

        // Output the value of the search input field
        System.out.println("Search input value: " + searchInput.getAttribute("value"));
        // Find the button with data-test="view-all-songs-btn" using a CSS Selector
        WebElement button = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));

        // Optionally, perform an action on the button (e.g., clicking it)
        button.click();

        // Output the button's text or perform any other actions
        System.out.println("Found button with text: " + button.getText());
        // Find all <tr> elements with draggable="true" and class="song-item selected" using CSS selector

        // Find all <table> elements with class="items" using XPath
        List<WebElement> tables = driver.findElements(By.xpath("//table[@class='items']"));

        // Output the number of tables found
        System.out.println("Found " + tables.size() + " tables with class 'items'");

        // Optionally, you can interact with the tables (e.g., print the HTML of each table)
        for (WebElement table : tables) {
            String outerhtml = table.getAttribute("outerHTML");
            if (outerhtml.contains("draggable")) {
                //find first music here
                List<WebElement> songRows = table.findElements(By.cssSelector("tr.song-item[draggable='true']"));


                // Print the number of found rows
                System.out.println("Number of songs found: " + songRows.size());

                // Loop through and print details (Modify as needed)
                for (WebElement row : songRows) {

                }

            }
            System.out.println(table.getAttribute("outerHTML"));
        }
        WebElement trElement = driver.findElement(By.cssSelector("tr.song-item.selected"));

        // Optionally, perform an action on the <tr> element (e.g., printing its text)
        System.out.println("Found <tr> element with text: " + trElement.getText());

        // Output the article's text or perform any other actions
        System.out.println("Found article with text: " + trElement.getText());
        trElement.click();
        WebElement button_AddTo = driver.findElement(By.cssSelector("button.btn-add-to"));

        // Optionally, perform an action on the button (e.g., clicking it)
        button_AddTo.click();

        // Output the button's text or perform any other actions
        System.out.println("Found button with text: " + button.getText());

        WebElement liElement = driver.findElement(By.xpath("//li[text()='FredPlaylist']"));

        // Optionally, perform an action on the <li> element (e.g., clicking it)
         liElement.click();

        // Output the <li> element's text or perform other actions
        System.out.println("Found <li> element with text: " + liElement.getText());
        WebElement notification = driver.findElement(By.cssSelector(".notification-message"));

        // Get the actual notification message text
        String actualMessage = notification.getText();

        // Define the expected message
        String expectedMessage = "Added 1 song into [FredPlaylist]"; // Replace [Actual Playlist Name] with actual playlist name if dynamic

        // Assert that the actual message matches the expected message
        Assert.assertEquals("Notification message is not as expected!", expectedMessage, actualMessage);

        // Optionally, print the message
        System.out.println("Actual Notification Message: " + actualMessage);

        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }
}
*/


public class homework17 extends BaseTest {

    /*
        @Test
        public void addSongToPlaylist() {
            WebDriver driver = new ChromeDriver();
            driver.get("https://qa.koel.app/");
            driver.findElement(By.name("email")).sendKeys("your-email@example.com");
            driver.findElement(By.name("password")).sendKeys("your-password");
            driver.findElement(By.cssSelector("button[type='submit']")).click();

            // Search for a song
            WebElement searchBox = driver.findElement(By.cssSelector("input[type='search']"));
            searchBox.sendKeys("song name");
            driver.findElement(By.cssSelector("button[aria-label='View All']")).click();

            // Click the first song in the search results
            driver.findElement(By.cssSelector(".song-item:first-child")).click();

            // Add to playlist
            driver.findElement(By.cssSelector("button[aria-label='Add to...']")).click();
            driver.findElement(By.cssSelector("button[aria-label='Create new playlist']")).click();
            WebElement playlistNameInput = driver.findElement(By.cssSelector("input[name='name']"));
            String playlistName = "Unique Playlist Name";
            playlistNameInput.sendKeys(playlistName);
            driver.findElement(By.cssSelector("button[type='submit']")).click();

            // Verify notification message
            WebElement notification = driver.findElement(By.cssSelector(".notification"));
            String expectedMessage = "Added 1 song into " + playlistName;
            Assert.assertEquals(expectedMessage, notification.getText());
            //Assert.assertEquals(driver.getCurrentUrl(), url);

            driver.quit();
        }
    }
    */
    @Test
    public void addSongToPlayList() throws InterruptedException {
        driver = new ChromeDriver();


        String clickAddToPlaylistMessage = "Added 1 song into ";
        String strSongName = "Pluto";
        String strEmail = "frederick.willis@testpro.io";
        String strPassword = "te$t$tudent";

        navigateToPage();
        inputEmail(strEmail);
        inputPassword(strPassword);
        loginButton();
        Thread.sleep(2000);

        searchSong(strSongName);
        clickViewAllBtn();
        selectFirstSongResult();
        clickAddToBtn();
        String chosenPlayList = clickAddToPlaylistMessage + choosePlayList();


        Assert.assertEquals(getAddToPlayListSuccessMsg(), chosenPlayList);

    }
}