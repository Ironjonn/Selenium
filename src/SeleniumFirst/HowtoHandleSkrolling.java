package SeleniumFirst;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HowtoHandleSkrolling {


    WebDriver driver;

    public void launchBrowser() {
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
        driver = new EdgeDriver();
        // Implicit wait se aplica globalmente que espere tantos segundos en encontrar
        // el objecto
        

    }

    public void getUrl() {
        driver.navigate().to("https://www.amazon.com.mx/");
    }

    public void windowsActivities() {
        driver.manage().window().maximize();
    }

    public void example(){

    }
    public static void main(String[] args) {
        HowtoHandleSkrolling obj = new HowtoHandleSkrolling();
        obj.launchBrowser();
        obj.getUrl();
        obj.windowsActivities();
        obj.example();
    }
}
