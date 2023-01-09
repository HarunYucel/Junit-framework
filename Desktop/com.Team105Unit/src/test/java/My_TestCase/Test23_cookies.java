package My_TestCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class Test23_cookies extends TestBase {

    /*
    Yeni bir class olusturun : cookiesAutomation
1- Amazon anasayfaya gidin
2- tum cookie’leri listeleyin
3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
olusturun ve sayfaya ekleyin
6- eklediginiz cookie’nin sayfaya eklendigini test edin
7- ismi skin olan cookie’yi silin ve silindigini test edin
8- tum cookie’leri silin ve silindigini test edin
     */
    /*
    - listeleyebilir
Driver.manage( ). method’u ile cookie’leri
- Isim ile cagirabilir
- Yeni cookie ekleyebilir
- Var olanlari ismi silebilir
- Var olan tum cookie’leri silebiliriz
     */



    @Test
    public void Testcookies(){
  //1- Amazon anasayfaya gidin
     driver.get("https://www.amazon.com/");

//2- tum cookie’leri listeleyin

  Set<Cookie>cookieSet = driver.manage().getCookies();
       int cookiessirano=1;

        for (Cookie eachCookie:cookieSet
             ) {
            System.out.println(cookiessirano + "-" + eachCookie);
                cookiessirano++;
        }

        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin

       Assert.assertTrue(cookieSet.size()>5);

        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin

        String cookiedegeri = "";
        for (Cookie eachCookie:cookieSet
        ) {
          if ( eachCookie.getName().equals("i18n-prefs")){

            cookiedegeri = eachCookie.getValue();

          }

        }
        String expectedvalue = "USD";
        String actualvalue  = cookiedegeri;
        Assert.assertEquals(expectedvalue,actualvalue);


  // 5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
        //olusturun ve sayfaya ekleyin

 Cookie sevdigimcookie = new Cookie("en sevdigim cookie","cikolatali");

 driver.manage().addCookie(sevdigimcookie);

 //6- eklediginiz cookie’nin sayfaya eklendigini test edin

      Assert.assertTrue(driver.manage().getCookies().contains(sevdigimcookie));

     //   7- ismi skin olan cookie’yi silin ve silindigini test edin

     // kısa ve 1. yontem bu 2. yontem asagıda  driver.manage().deleteCookieNamed("skin");

        Cookie silinecekcookie = new Cookie("","");
        for (Cookie eachCookie:cookieSet
        ) {
            if ( eachCookie.getName().equals("skin")){

            silinecekcookie=eachCookie;

            }

        }

        driver.manage().deleteCookie(silinecekcookie);

        Assert.assertFalse(driver.manage().getCookies().contains(silinecekcookie));

    //8- tum cookie’leri silin ve silindigini test edin


        driver.manage().deleteAllCookies();

        System.out.println("*********************************************");


        System.out.println(driver.manage().getCookies().size());

    }

}
