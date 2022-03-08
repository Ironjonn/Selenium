package SeleniumFirst;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.edge.EdgeDriver;


public class ActionsDemo {
    WebDriver driver;
    public void launchBrowser(){
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
        driver = new EdgeDriver();

        
    }
    public void getUrl(){
        driver.get("https://www.amazon.com.mx/");
    }
    public void windowsActivities(){
        driver.manage().window().maximize();
    }

    public static void main(String[] args) {
        ActionsDemo myobjt = new ActionsDemo();
        myobjt.launchBrowser();
        myobjt.getUrl();
        myobjt.windowsActivities();
    }
}
