package SeleniumFirst;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import java.util.List;




import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class BrokenLinks extends MainJava {

    public void brokeenlink() throws InterruptedException, MalformedURLException, IOException {
        // for(int y =0; y<oct.size(); y++){
        // oct.get(y).getText();

        // Thread.sleep(1000);
        // System.out.println(oct.get(y).getText());

        // }
        //How to scroll down the window example     
        JavascriptExecutor act = (JavascriptExecutor) driver;
        act.executeScript("window.scrollBy(0,900)");
        
        //How to get the webelement of the footyer section that contains the links that i will check 
        WebElement footer = driver.findElement(By.xpath("//*[@class =' footer_top_agile_w3ls gffoot footer_style']"));
       
        //How to get the list of links by using the foother Webelement
        List<WebElement> oct = footer.findElements(By.xpath("//li[@class = 'gf-li']//a"));
        //  List <WebElement> list = footer.findElements(By.tagName("a"));
        //  footer.findElements(By.cssSelector("li[class = 'gf=li']a"));

        // Como Hacer click y que se abra en una nueva tab
        String clicklink = Keys.chord(Keys.CONTROL, Keys.ENTER);

        Thread.sleep(2000);    
        //Creatring a object of sofassert 
        SoftAssert a = new SoftAssert();

        
        for (WebElement resul : oct) {
           
            resul.sendKeys(clicklink);
            resul.getAttribute("href");
            
            String url = resul.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();

            conn.setRequestMethod("HEAD");
            conn.connect();
            int response1 =  conn.getResponseCode();
            //This below example is an assertion that works as if statment
            a.assertTrue(response1<400, "The Link with Teaxt " + resul.getText() + "Is Broken with code " + response1);  
            
        }
        //For this assertion you have to call the method 
        a.assertAll();

        List<String> strings = new ArrayList<String>();

        for(WebElement e :oct){
                                    
             strings.add(e.getAttribute("href"));

        }

        String [] linksarray = strings.toArray(new String[strings.size()]);

       
        System.out.println("Number of links on the page = " + strings);
        

    }

    public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
        BrokenLinks obx = new BrokenLinks();
        obx.launchBrowser();
        obx.windowsActivities();
        obx.reachUrl("https://rahulshettyacademy.com/AutomationPractice/");
        obx.deleatecokkies();
        obx.brokeenlink();

    }
}
