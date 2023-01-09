package My_TestCase;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;



public class Test30javascret extends TestBase {

    /*
    wisequarter anasayfasina gidin once contact butonuna basın sonra
     alt kisimda bulunan “Go To Career Page”
butonuna kadar asagi inin ve bu butona click yapin
     */




    @Test
    public void Testjavascret(){

        JavascriptExecutor jse= (JavascriptExecutor) driver;

        driver.get("https://www.wisequarter.com");

        WebElement element = driver.findElement(By.xpath("//*[@id=\"menu-item-3925\"]/a"));

        jse.executeScript("arguments[0].click;",element);

        WebElement element1 = driver.findElement(By.cssSelector("#post-1324 > div > div > div > div > section.elementor-section.elementor-top-section.elementor-element.elementor-element-1ace6dd.elementor-section-content-middle.elementor-section-boxed.elementor-section-height-default.elementor-section-height-default > div > div > div > div > div > div > div > div > div > a"));

        jse.executeScript("arguments[0].scrollIntoView();",element1);
        jse.executeScript("arguments[0].click;",element1);


    }

}

