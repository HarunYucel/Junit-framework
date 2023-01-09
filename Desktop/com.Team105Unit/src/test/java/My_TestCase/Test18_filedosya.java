package My_TestCase;

import com.github.dockerjava.api.model.Reachability;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test18_filedosya extends TestBase {

    /*
    1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
2. https://the-internet.herokuapp.com/download adresine gidelim.
3. LambdaTest.txt dosyasını indirelim
4. Dosyanın başarıyla indirilip indirilmediğini test edelim
     */

    @Test
    public void filetest() {

        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//a[text()='LambdaTest.txt']")).click();

        String dosyayolu = System.getProperty("user.home")+"\\Downloads\\LambdaTest.txt";



        Assert.assertTrue(Files.exists(Paths.get(dosyayolu)));






    }

}
