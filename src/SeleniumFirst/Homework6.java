package SeleniumFirst;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;

public class Homework6 {
    
    WebDriver driver;

    public void launchBrowser() {
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
        driver = new EdgeDriver();

    }

    public void getUrl() {
        driver.navigate().to("https://www.rahulshettyacademy.com/AutomationPractice/");
        
    }

    public void windowsActivities() {
        driver.manage().window().maximize();
    }

    public void example () throws InterruptedException{
        WebElement dhead = driver.findElement(By.xpath("//div[@id ='checkbox-example']"));
        dhead.findElement(By.xpath("//*[@id = 'checkBoxOption2']")).click();
        
        String name = dhead.findElement(By.xpath("//label[@for='benz']")).getText();
        JOptionPane.showMessageDialog(null, name);

        
        Thread.sleep(2000);

        WebElement dropdown = driver.findElement(By.xpath("//*[@id ='dropdown-class-example']"));
        Select dri = new Select(dropdown);

        dri.selectByIndex(2);

    }
    public static void main(String[] args) throws InterruptedException {
        Homework6 obj = new Homework6();
        obj.launchBrowser();
        obj.getUrl();
        obj.windowsActivities();
        obj.example();
        
    }
}
