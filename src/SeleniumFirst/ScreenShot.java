package SeleniumFirst;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.apache.commons.io.FileUtils;

public class ScreenShot extends MainJava{

    public void takescreen() throws InterruptedException, IOException{
        driver.findElement(By.xpath("//*[@id ='twotabsearchtextbox']")).sendKeys("iphone 13");
        Thread.sleep(4000);
        
        List<WebElement> options =  driver.findElements(By.xpath("//div[@class = 's-suggestion-container']"));
        WebElement sel = options.get(3);
        List<String> strings = new ArrayList<String>();
        
        for(WebElement e :options){
            strings.add(e.getText());
        }

       String iphone = strings.get(3); 

        Actions act = new Actions(driver);
        Thread.sleep(2000);

        for(int i = 0; i<options.size(); i ++){
            if (options.get(i).getText().contains(iphone)){
              
               act.moveToElement(sel).clickAndHold().build().perform();
               Thread.sleep(2000);
               act.release().build().perform();

            } break;
        }
        

        //   if(sel.getText().contains("iphone 13 pro")){

        //        act.moveToElement(sel).clickAndHold().build().perform();
        //        Thread.sleep(2000);
        //        act.release().build().perform();;
            
           
        // }

        Thread.sleep(5000);
         File screenshotobj = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         FileUtils.copyFile(screenshotobj, new File("C:\\Users\\Public\\scrennhot2.png"));
         
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        ScreenShot obj = new ScreenShot();
        obj.launchBrowser();
        obj.windowsActivities();
        obj.deleatecokkies();
        obj.reachUrl("https://Amazon.com.mx");
        obj.takescreen();
    }
}
  