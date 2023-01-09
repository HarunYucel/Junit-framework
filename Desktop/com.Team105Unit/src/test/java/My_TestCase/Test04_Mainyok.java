package My_TestCase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test04_Mainyok {
    /*
    1- C01_TekrarTesti isimli bir class olusturun
2- https://www.google.com/ adresine gidin
3- cookies uyarisini kabul ederek kapatin
4- Sayfa basliginin “Google” ifadesi icerdigini test edin
5- Arama cubuguna “Nutella” yazip aratin
6- Bulunan sonuc sayisini yazdirin
7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
8- Sayfayi kapatin
     */

    WebDriver driver;

    @Before
    public void Tes01(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        System.out.println("before calisti");
    }

    @After
    public void Tes02(){
        driver.close();

        System.out.println("after calisti");
    }


    @Test
    public void Tes03(){
        //2- https://www.google.com/ adresine gidin
        //3- cookies uyarisini kabul ederek kapatin
        //Sayfa basliginin “Google” ifadesi icerdigini test edin

        driver.get(" https://www.google.com/");
        Assert.assertTrue(driver.getTitle().contains("Google"));

        System.out.println("test03 calisti");

    }

    @Test
    public void Tes04(){
        // Arama cubuguna “Nutella” yazip aratin
        // Bulunan sonuc sayisini yazdirin
        // sonuc sayisinin 10 milyon’dan fazla oldugunu test edin

        driver.get(" https://www.google.com/");

        WebElement aramaCubugu = driver.findElement(By.xpath("//input[@class='gLFyf']"));

        aramaCubugu.sendKeys("Nutella" + Keys.ENTER);
        WebElement sonucSayisi= driver.findElement(By.id("result-stats"));
        System.out.println(sonucSayisi.getText());
        //int ExpectedResult  = 10000000;
        //Assert.assertTrue(actualResult>ExpectedResult);

        System.out.println("test03 calisti");

    }





}
