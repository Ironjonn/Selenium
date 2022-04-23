package SeleniumFirst;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ScreenShot extends MainJava{

    public void takescreen() throws InterruptedException{
        driver.findElement(By.xpath("//*[@id ='twotabsearchtextbox']")).sendKeys("iphone 13");
        Thread.sleep(4000);
        
        List<WebElement> options =  driver.findElements(By.xpath("//div[@class = 's-suggestion-container']"));
        WebElement sel = options.get(3);

        System.out.println(sel.getText());
        Actions act = new Actions(driver);
        Thread.sleep(2000);
        
        

          if(sel.getText().contains("iphone 13 pro max")){

               act.moveToElement(sel).clickAndHold().build().perform();
               Thread.sleep(2000);
               act.release().build().perform();;
            
           
        }

         File screenshotobj = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

         
    }

    public static void main(String[] args) throws InterruptedException {
        ScreenShot obj = new ScreenShot();
        obj.launchBrowser();
        obj.windowsActivities();
        obj.deleatecokkies();
        obj.reachUrl("https://Amazon.com.mx");
        obj.takescreen();
    }
}
  