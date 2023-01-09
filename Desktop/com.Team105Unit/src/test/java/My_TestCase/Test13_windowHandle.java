package My_TestCase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class Test13_windowHandle {
    WebDriver driver;
    @Before
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void after(){
       driver.quit();

    }
    @Test
    public void Test01() throws InterruptedException {

 //     Yeni bir class olusturun: WindowHandle
// Amazon anasayfa adresine gidin.
  driver.get("https:/www.amazon.com");

// Sayfa’nin window handle degerini String bir degiskene atayin
 String ilkSayfahandeldeger =driver.getWindowHandle();
 // Sayfa title’nin “Amazon” icerdigini test edin
 Assert.assertTrue(driver.getTitle().contains("Amazon"));
// Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
   driver.switchTo().newWindow(WindowType.TAB);
   driver.get("https:/www.wisequarter.com");
   Thread.sleep(5000);
   String Expectedkelime = "Wise Quarter";
   String ActualKelime = driver.getTitle();
   Assert.assertTrue(ActualKelime.contains(Expectedkelime));
        System.out.println(driver.getTitle());
        Thread.sleep(5000);



 Set<String>Handelset = driver.getWindowHandles();

            String Handel2 = "";
        for (String each: Handelset
             ) {
            if (!(each.equals(ilkSayfahandeldeger)))
                each=Handel2;

        }
  
    driver.switchTo().window(ilkSayfahandeldeger);
        Thread.sleep(4000);

        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.amazon.com/"));



    }

}
