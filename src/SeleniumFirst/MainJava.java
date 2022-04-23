package SeleniumFirst;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class MainJava {
    WebDriver driver;

    public void launchBrowser(){
        
        System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\\\chromedriver.exe");
         driver = new ChromeDriver();
         
    }    

    public void reachUrl(String url ){
        driver.get(url);
    }

    public void windowsActivities() {
        
        driver.manage().window().maximize();
    }
}   
