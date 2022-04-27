package SeleniumFirst;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class BrokenLinks extends MainJava {

    public void brokeenlink() throws InterruptedException{
        
        JavascriptExecutor act =  (JavascriptExecutor)driver;
            
        act.executeScript("window.scrollBy(0,900)");
        

        WebElement footer =  driver.findElement(By.xpath("//*[@class =' footer_top_agile_w3ls gffoot footer_style']"));
         
        // List <WebElement> linklist = footer.findElements(By.tagName("a"));
        List <WebElement> oct =  footer.findElements(By.xpath("//li[@class = 'gf-li']//a"));

        //Como Hacer click en new tab aqui abajo 
        String clicklink = Keys.chord(Keys.CONTROL, Keys.ENTER);



        // for(int y =0; y<oct.size(); y++){
        //     oct.get(y).getText();
            
            
        //     Thread.sleep(1000);
        //     System.out.println(oct.get(y).getText());          
            
        // }

        Thread.sleep(2000);
        for (WebElement resul : oct) {
            resul.sendKeys(clicklink);
        }

        Thread.sleep(2000);
       Set <String> pages = driver.getWindowHandles();
       System.out.println(pages.size());


        // for(int i = 0; i<linklist.size(); i++){
        //     linklist.get(i).getText();
        //     System.out.println(linklist.get(i).getText());
        // }

         


    }
    public static void main(String[] args) throws InterruptedException {
        BrokenLinks obx = new BrokenLinks();
        obx.launchBrowser();
        obx.windowsActivities();
        obx.reachUrl("https://rahulshettyacademy.com/AutomationPractice/");
        obx.deleatecokkies();
        obx.brokeenlink();

    }
}
