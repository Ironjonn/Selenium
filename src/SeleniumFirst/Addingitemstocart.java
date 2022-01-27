package SeleniumFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Addingitemstocart {
    WebDriver driver;

    public void launchBrowser(){
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
        driver = new EdgeDriver();

    }
    public void getUrl(){
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
    }

    public void windowsActivities(){
        driver.manage().window().maximize();

    }

    public void example(){
        
        driver.findElement(By.xpath("(//*[text()= 'ADD TO CART'])[3]")).click();
    }

    public static void main(String[] args) {
        Addingitemstocart Objeto = new Addingitemstocart();
        Objeto.launchBrowser();
        Objeto.getUrl();
        Objeto.windowsActivities();
        Objeto.example();
    }
}
