package SeleniumFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class BrokenLinks extends MainJava {

    public void brokeenlink() throws InterruptedException{
        
        JavascriptExecutor act =  (JavascriptExecutor)driver;
            
        act.executeScript("window.scrollBy(0,900)");
         Thread.sleep(2000);

        WebElement footer =  driver.findElement(By.xpath("//*[@class =' footer_top_agile_w3ls gffoot footer_style']"));
        System.out.println(footer.findElements(By.tagName("a")).size()); 


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
