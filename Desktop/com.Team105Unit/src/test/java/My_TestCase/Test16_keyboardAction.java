package My_TestCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Test16_keyboardAction extends TestBase {

    @Test
    public void keyboard() throws InterruptedException {

        //2- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");

       // 3- Arama kutusuna actions method’larine kullanarak samsung A71 yazdirin ve
        // Enter’a basarak arama yaptirin
        Thread.sleep(3000);
        WebElement aramaMotoru = driver.findElement(By.xpath(" //*[@id=\"twotabsearchtextbox\"]"));
        WebElement aramacubugu = driver.findElement(By.xpath(" //*[@id=\"nav-search-submit-button\"]"));

        Actions actions = new Actions(driver);

        actions.clickAndHold(aramaMotoru).sendKeys("samsung A71").doubleClick(aramacubugu).perform();

     //   4- aramanin gerceklestigini test edin

    WebElement aramasonuclari = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[1]"));

        Assert.assertTrue(aramasonuclari.isDisplayed());


    }




}
