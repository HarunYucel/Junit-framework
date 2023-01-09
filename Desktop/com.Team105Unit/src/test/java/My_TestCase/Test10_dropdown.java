package My_TestCase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Test10_dropdown {
    /*
    ● Bir class oluşturun: DropDown
● https://the-internet.herokuapp.com/dropdown adresine gidin.
1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve
yazdırın
4.Tüm dropdown değerleri(value) yazdırın
5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True ,
degilse False yazdırın.
     */

    static WebDriver driver;
    @BeforeClass
    public static void before(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void Teardown(){

      driver.close();

    }
    @Test
    public void Test01() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/dropdown");

        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        WebElement option = driver.findElement(By.xpath("//*[@id='dropdown']"));

        Select select = new Select(option);
        select.selectByIndex(1);                    //
        Thread.sleep(3000);
        select.selectByValue("2");
        Thread.sleep(3000);

        //Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        select.selectByVisibleText("Option 1");
        Thread.sleep(3000);


        //Tüm dropdown değerleri(value) yazdırın

    List<WebElement> OptionListesi  = select.getOptions();

        for (WebElement each:OptionListesi
             ) {
            System.out.println(each.getText());


        }

        // Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True ,
        //degilse False yazdırın.

        if (option.getSize().equals(4)){
            System.out.println("TRUE");

        }else System.out.println("FALSE");


    }




}
