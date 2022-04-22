package SeleniumFirst;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Httpcertifications  {
    WebDriver driver;
    ChromeOptions options = new ChromeOptions();
    
    
    
    public void launchBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\\\chromedriver.exe");
        options.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(options);

         
    }

    public void geturl (){
        driver.navigate().to("https://expired.badssl.com/");
    }

    public void windowsActivities() {
        
        driver.manage().window().maximize();
    }


    
    public static void main(String[] args) {
        Httpcertifications obj = new Httpcertifications();
        obj.launchBrowser();
        obj.geturl();
        obj.windowsActivities();
        
    
        
       
        



    }

}
