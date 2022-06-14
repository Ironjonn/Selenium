package SeleniumFirst;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebelementPartialScreenShot {

    WebDriver driver; 

    public void invokebrowser(){
        System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\\\chromedriver.exe"); 
        driver = new ChromeDriver(); 
    
    }

    public void windowsActivities(){
        driver.manage().window().maximize();
    }

    public void reachUrl(){
        driver.get("https://rahulshettyacademy.com/angularpractice/");
    }

    public void takescreenshot() throws IOException{

       WebElement first =  driver.findElement(By.xpath("//form/div[1]/input"));
        first.sendKeys("Welcome to selenium");
        //Get Screenshot of the WebElement
       File file =  first.getScreenshotAs(OutputType.FILE); 
       FileUtils.copyFile(file, new File("logo3.png"));

        //Get HEight & Wiidth
        System.out.println(first.getRect().getDimension().getHeight());
        System.out.println(first.getRect().getDimension().getWidth());
    }
    public static void main(String[] args) throws IOException {
        
        WebelementPartialScreenShot obj = new WebelementPartialScreenShot(); 
        obj.invokebrowser();
        obj.windowsActivities();
        obj.reachUrl();
        obj.takescreenshot();
        

    }
}
