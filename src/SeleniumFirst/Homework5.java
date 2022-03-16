package SeleniumFirst;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Homework5 {

    WebDriver driver;

    public void launchBrowser(){
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
        driver = new EdgeDriver();
    }

    public void getUrl(){
        driver.navigate().to("https://the-internet.herokuapp.com");
    }

    public void windowsActivities(){
        driver.manage().window().maximize();
    }

    public void homework(){
        driver.findElement(By.xpath("//*[text() = 'Frames']")).click();

        driver.findElement(By.xpath("//*[text() = 'Nested Frames']")).click();

        driver.switchTo().frame("frame-top").switchTo().frame("frame-middle");

        String frameName = driver.findElement(By.xpath("//div[text() = 'MIDDLE']")).getText();
       JOptionPane.showMessageDialog(null, frameName); 
    }

    public static void main(String[] args) {
        Homework5 obx = new Homework5();
        obx.launchBrowser();
        obx.getUrl();
        obx.windowsActivities();
        obx.homework();

    }
}
