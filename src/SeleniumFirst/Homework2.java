package SeleniumFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Homework2 {

    WebDriver driver; 
    
    public void launchBrowser(){
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
        driver = new EdgeDriver();

    }

    public void Geturl(){
        driver.get("https://www.cleartrip.com/");
    }

    public void Windowactivities(){
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    public void Example(){
        driver.findElement(By.xpath("/*[@id='']")).click();
    }

    public void close() throws InterruptedException{
        Thread.sleep(3000);
        driver.close();
    }
    public static void main(String[] args) throws InterruptedException {
        Homework2 objeto = new Homework2();
        objeto.launchBrowser();
        objeto.Geturl();
        objeto.Windowactivities();
        
        objeto.close();
        
    }
}
