package My_TestCase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Test20_imlictlyWait_Expilicitlywait {

    /*
    1. Bir class olusturun : WaitTest
2. Iki tane metod olusturun : implicitWait() , explicitWait()
Iki metod icin de asagidaki adimlari test edin.
3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
4. Remove butonuna basin.
5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
6. Add buttonuna basin
7. It’s back mesajinin gorundugunu test edin
     */

    WebDriver driver;
    @Test
   public void implycitlyWait(){
      WebDriverManager.chromedriver().setup();
      driver= new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

      driver.get("https://the-internet.herokuapp.com/dynamic_controls");
      driver.findElement(By.xpath("//*[text()='Remove']")).click();
    Assert.assertTrue(driver.findElement(By.xpath("//p[@id='message']")).isDisplayed());

    }

    @Test
    public void ExplycitlyWait(){
    WebDriverManager.chromedriver().setup();
    driver= new ChromeDriver();
    driver.manage().window().maximize();

    driver.get("https://the-internet.herokuapp.com/dynamic_controls");
   driver.findElement(By.xpath("//*[text()='Remove']")).click();

   WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
   WebElement Itsgone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
   Assert.assertTrue(Itsgone.isDisplayed());
  //WebElement itsGoneElementi= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
   Assert.assertTrue(driver.findElement(By.xpath("//p[@id='message']")).isDisplayed());
   WebElement itsback = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));

   Assert.assertTrue(itsback.isDisplayed());



    }



}

