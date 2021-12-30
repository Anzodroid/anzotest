package anzo.anzotest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class throwdice {
     
     public static void main(String[] args) throws InterruptedException {
    
        List<WebElement> resultsCount;
// set location for chrome driver
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\ChromeDriver\\chromedriver.exe");
// new instance of chrome driver
        WebDriver driver = new ChromeDriver();
// navigate to test application
       // driver.get("https://formy-project.herokuapp.com/keypress");

       // WebElement name = driver.findElement(By.id("name"));
        //name.click(); // click the text box with id = name
       // name.sendKeys("Michael A");

      //  Thread.sleep(1000); // sometimes there are issues with timing
        //WebElement button = driver.findElement(By.id("button"));
       // button.click();
// quit test application
       // Thread.sleep(1000);
        driver.get("https://throwdice.net/rooms/anzo");

        resultsCount = driver.findElements(By.cssSelector(".btn.btn-primary"));
        Thread.sleep(1000);
        System.out.println("resultsCount ="+ resultsCount);

        List<WebElement> blueButtons = new ArrayList<WebElement>();
        //listOfAllWebElements.add(driver.findElement(By.cssSelector(".btn.btn-primary")));
        //listOfAllWebElements.add(driver.findElement(By.cssSelector("input#username.form-control")));
        //listOfAllWebElements.add(driver.findElement(By.id("20")));
        // check each blue button is there
        blueButtons = driver.findElements(By.cssSelector(".btn.btn-primary"));

        WebDriverWait listWait = new WebDriverWait(driver,10);
        listWait.until(ExpectedConditions.visibilityOfAllElements(blueButtons));
        System.out.println("resultsCount ="+ listWait);
        System.out.println("resultsCount ="+ blueButtons.stream().count());
        long result = blueButtons.stream().count();
        System.out.println("resultsCount = "+ result);
        if (result == 7){
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }

        assertEquals(7, result);

        Thread.sleep(100);
        WebElement changename = driver.findElement(By.cssSelector("input#username.form-control"));
        changename.click();
        changename.clear();
        changename.sendKeys("anzotest");

        Thread.sleep(100);
        WebElement d20 = driver.findElement(By.id("20"));
        d20.click();

        WebDriverWait wait = new WebDriverWait(driver,5); /// Explicit wait - wait a max of 5 seconds (will poll every 500 ms to check if condition is true)
        WebElement autocompleteResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("4")));
        autocompleteResult.click();

        //driver.findElement(By.id("100")).click();

        Thread.sleep(100);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);// alternate method of sleep
        //WebElement throwdice = driver.findElement(By.cssSelector("button.btn.btn-danger"));
        WebElement throwdice = driver.findElement(By.cssSelector(".btn.btn-danger")); // spaces are replaced by .
        /// does not work WebElement throwdice = driver.findElement(By.cssSelector("button.btn.btn-danger[value='Throw!']"));
        //does not work, copy xpath
        //WebElement throwdice = driver.findElement(By.xpath("/div/div/div[3]/button[9]"));
        throwdice.click();

        Thread.sleep(500);
        driver.quit();
    }
         
}
