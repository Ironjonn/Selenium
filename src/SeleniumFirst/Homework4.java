package SeleniumFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Homework4 {

    WebDriver driver;

    public void launchBrowser(){
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
        driver = new EdgeDriver();

    }

    public void getUrl(){
        driver.get("https://the-internet.herokuapp.com");
    }

    public void windowsActivities(){

        driver.manage().window().maximize();
    }

    public void exercise(){
        driver.findElement(By.xpath("//*[text()='Multiple Windows']")).click();

        driver.findElement(By.xpath("//*[@target='_blank']")).click();
    }
    public static void main(String[] args) {
        Homework4 obj = new Homework4();
        obj.launchBrowser();
        obj.getUrl();
        obj.windowsActivities();
        obj.exercise();
    }
}
