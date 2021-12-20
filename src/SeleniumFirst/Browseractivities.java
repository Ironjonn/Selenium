package SeleniumFirst;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Browseractivities {

    WebDriver driver;

    public void setbrowser() {

        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
        driver = new EdgeDriver();

    }

    public void Windowactivities() {
        driver.manage().window().maximize();

    }

    public void Geturl() throws InterruptedException {
        driver.get("https://www.amazon.com.mx/");
        Thread.sleep(2000);
        driver.navigate().to("https://www.google.com.mx/");
        driver.navigate().back();
        driver.navigate().forward();
        ;

    }

    public static void main(String[] args) throws InterruptedException {
        Browseractivities Myobj = new Browseractivities();
        Myobj.setbrowser();
        Myobj.Windowactivities();
        Myobj.Geturl();

    }

}