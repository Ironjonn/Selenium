package SeleniumFirst;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MainJava {
    WebDriver driver;

    public void launchBrowser(){
        // ChromeOptions options = new ChromeOptions();
        // options.setAcceptInsecureCerts(true);
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
