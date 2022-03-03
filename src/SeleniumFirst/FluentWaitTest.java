package SeleniumFirst;

import java.time.Duration;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FluentWaitTest {

    WebDriver driver; 
    
    public void launchBrowser(){
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
        driver = new EdgeDriver();

        //Implicit waith defined as global variable 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

    }

    public void getUrl(){
        driver.get("https://the-internet.herokuapp.com/");
    }

    public void windowsActivities(){
        driver.manage().window().maximize();
    }

    public void example(){
        driver.findElement(By.xpath("//*[text()='Dynamic Loading']")).click();


        driver.findElement(By.xpath("//*[@href='/dynamic_loading/1']")).click();
        driver.findElement(By.xpath("//div[@id ='start']//button[text()='Start']")).click();

        WebDriverWait obj;
        obj = new WebDriverWait(driver, 20);
        obj.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4[text()='Hello World!']")));

        String obtenida = driver.findElement(By.xpath("//div[@id='finish']//h4[text()='Hello World!']")).getText();
        JOptionPane.showMessageDialog(null, obtenida);      
    }

    public static void main(String[] args) {
        FluentWaitTest obj = new FluentWaitTest();
        obj.launchBrowser();
        obj.getUrl();
        obj.windowsActivities();
        obj.example();
    }
}
