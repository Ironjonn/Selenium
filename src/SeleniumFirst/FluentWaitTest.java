package SeleniumFirst;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FluentWaitTest {

    WebDriver driver; 
    
    public void launchBrowser(){
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
        driver = new EdgeDriver();

    }

    public void getUrl(){
        driver.get("https://the-internet.herokuapp.com/");
    }

    public void windowsActivities(){
        driver.manage().window().maximize();
    }

    public static void main(String[] args) {
        FluentWaitTest obj = new FluentWaitTest();
        obj.launchBrowser();
        obj.getUrl();
        obj.windowsActivities();
    }
}
