package SeleniumFirst;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Synchronization {
    WebDriver driver;

    public void launchBrowser(){
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
        driver = new EdgeDriver();
        
    }

    public void getUrl(){
        driver.get("url");
    }

    public void windowsActivities(){
        driver.manage().window().maximize();
    }
    public static void main(String[] args) {
        Synchronization Objecto = new Synchronization();
        Objecto.launchBrowser();
        Objecto.getUrl();
        Objecto.windowsActivities();
        
    }
}
