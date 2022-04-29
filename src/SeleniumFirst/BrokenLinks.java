package SeleniumFirst;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class BrokenLinks extends MainJava {

    public void brokeenlink() throws InterruptedException, MalformedURLException, IOException {

        JavascriptExecutor act = (JavascriptExecutor) driver;

        act.executeScript("window.scrollBy(0,900)");

        WebElement footer = driver.findElement(By.xpath("//*[@class =' footer_top_agile_w3ls gffoot footer_style']"));

        List <WebElement> linklist = footer.findElements(By.tagName("a"));

        
        List<WebElement> oct = footer.findElements(By.xpath("//li[@class = 'gf-li']//a"));

        // Como Hacer click en new tab aqui abajo
        String clicklink = Keys.chord(Keys.CONTROL, Keys.ENTER);

        // for(int y =0; y<oct.size(); y++){
        // oct.get(y).getText();

        // Thread.sleep(1000);
        // System.out.println(oct.get(y).getText());

        // }

        Thread.sleep(2000);

        List<String> strings = new ArrayList<String>();

        for(WebElement e :linklist){
                                    
             strings.add(e.getAttribute("href"));
        }

        String [] linksarray = strings.toArray(new String[strings.size()]);

        System.out.println(linksarray.length);
        String array1 = linksarray[6];

        
        for(String array :linksarray){

            
        }
        
        HttpURLConnection conn = (HttpURLConnection) new URL(array1).openConnection();

        conn.setRequestMethod("HEAD");
        conn.connect();
        int response1 =  conn.getResponseCode();

        System.out.println(response1);


        for (WebElement resul : oct) {
            resul.sendKeys(clicklink);
            resul.getAttribute("href");
            // System.out.println(resul.getAttribute("href"));

            

        }

        // JOptionPane.showMessageDialog(null, );
        // for(int i = 0; i< pages.size(); i++){

        // String[] where = new String();

        // it.next();

        // }

        // for(int i = 0; i<linklist.size(); i++){
        // linklist.get(i).getText();
        // System.out.println(linklist.get(i).getText());
        // }

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
