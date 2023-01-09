package My_TestCase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test09 {

    /*
    a. Verilen web sayfasına gidin.
https://the-internet.herokuapp.com/checkboxes
b. Checkbox1 ve checkbox2 elementlerini locate edin.
c. Checkbox1 seçili değilse onay kutusunu tıklayın
d. Checkbox2 seçili değilse onay kutusunu tıklayın

     */
  WebDriver driver;
    @Test
    public void Test01() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

   driver.get(" https://the-internet.herokuapp.com/checkboxes");

   WebElement Checkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
   WebElement Checkbox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        Thread.sleep(4000);

        if (!(Checkbox1.isSelected())){
            Checkbox1.click();
            Assert.assertTrue(Checkbox1.isSelected());
        }
        if (!(Checkbox2.isSelected())){
            Checkbox2.click();
            Assert.assertTrue(Checkbox2.isSelected());
        }
        Thread.sleep(4000);

    }


}
