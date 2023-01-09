package My_TestCase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test05 {

    //a. Verilen web sayfasına gidin.
    //https://the-internet.herokuapp.com/checkboxes
    //b. Checkbox1 ve checkbox2 elementlerini locate edin.
    //c. Checkbox1 seçili değilse onay kutusunu tıklayın
    //d. Checkbox2 seçili değilse onay kutusunu tıklayın

    WebDriver driver;
    @Before
    public void Test01(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void Test02(){

    driver.close();

    }


    @Test
    public void Test03() throws InterruptedException {
        // https://the-internet.herokuapp.com/checkboxes
        // b. Checkbox1 ve checkbox2 elementlerini locate edin.
        //c. Checkbox1 seçili değilse onay kutusunu tıklayın
        //d. Checkbox2 seçili değilse onay kutusunu tıklayın
       driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']"));
        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']"));

        Thread.sleep(4000);

        WebElement onaykutusucheckbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
        onaykutusucheckbox1.click();



    }

    @Test
    public void Test04() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        Thread.sleep(4000);

        WebElement onayKtususucheckbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        onayKtususucheckbox2.click();

        Thread.sleep(4000);


    }




}
