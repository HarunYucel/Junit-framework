package My_TestCase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test08_assertions {

    /*
    1) Bir class oluşturun: BestBuyAssertions
2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak
asagidaki testleri yapin
○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
○ logoTest => BestBuy logosunun görüntülendigini test edin
○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
     */

    WebDriver driver;
    @Before
    public void test01(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");

    }
    @After
    public void test(){

       driver.close();

    }

    @Test
    public void Test02(){

        //driver.get("https://www.bestbuy.com/");

        String expectedUrl= "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);


    }
    @Test
    public void Test03(){

        //driver.get("https://www.bestbuy.com/");

        String expectedicerik = "Rest";
        String actualTitle = driver.getTitle();
    Assert.assertTrue(!(actualTitle.contains(expectedicerik)));


}

    @Test
    public void Test04(){

        //driver.get("https://www.bestbuy.com/");


        WebElement bestBuyLogo = driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));

        Assert.assertTrue(bestBuyLogo.isDisplayed());

        WebElement francaisLink = driver.findElement(By.xpath("//button[text()='Français']"));

            Assert.assertTrue(francaisLink.isDisplayed());

}

}
