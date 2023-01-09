package My_TestCase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test06_beforeAfterclass {

   static WebDriver driver;
   @BeforeClass
    public static  void Test01 (){
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       driver.get("https://facebook.com");
       System.out.println("before class");

    }

    @AfterClass
    public static  void Test02 (){
        System.out.println("after class");

    }


    @After
    public void Test04 (){
        System.out.println("after ");

    }


    @Before
    public void Test05 (){
        System.out.println("before");

    }
    @Test
    public void Test03 (){

        driver.get("https://facebook.com");
        System.out.println("test class");

    }






}
