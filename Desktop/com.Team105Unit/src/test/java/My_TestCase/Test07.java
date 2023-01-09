package My_TestCase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class Test07 {

    /*
a. Verilen web sayfasına gidin.
https://facebook.com
b. Cookies’i kabul edin
c. Create an account buton’una basin
d. Radio button elementlerini locate edin ve size uygun olani secin
 */
    static WebDriver driver;

    @BeforeClass
    public static void Test01() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @Test
    public void Test02() {

        driver.get("https://facebook.com");
        WebElement sifreunuttun = driver.findElement(By.xpath("//*[@id=\"u_0_2_Uz\"]/div[3]/a"));


    }
}