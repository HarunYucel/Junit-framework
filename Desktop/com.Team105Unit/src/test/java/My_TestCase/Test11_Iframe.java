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

public class Test11_Iframe {
    WebDriver driver;
    @Before
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void AfterTest(){
    driver.close();
    }



    @Test
    public void IframeTest01() throws InterruptedException {
  /*
  1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
  2 ) Bir metod olusturun: iframeTest
- “An IFrame containing….” textinin erisilebilir oldugunu test edin ve
konsolda yazdirin.
- Text Box’a “Merhaba Dunya!” yazin.
- TextBox’in altinda bulunan “Elemental Selenium” linkini textinin
gorunur oldugunu dogrulayin ve konsolda yazdirin.
   */

    driver.get("https://the-internet.herokuapp.com/iframe");

    WebElement tagname =driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));

        System.out.println(tagname.isEnabled());

   WebElement iframeid= driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframeid);

        WebElement texbox = driver.findElement(By.xpath("//*[@id=\"tinymce\"]/p"));

        texbox.clear();

        texbox.sendKeys("merhaba dunya");

        Thread.sleep(4000);
        driver.switchTo().defaultContent();

        WebElement elementexti = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));

        Assert.assertTrue(elementexti.isDisplayed());

    }









}
