package SeleniumFirst;

import java.util.Iterator;
import java.util.Set;

import javax.swing.JOptionPane;


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

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();

        driver.switchTo().window(childWindow);
        String text = driver.findElement(By.xpath("//div[@class='example']")).getText();
        JOptionPane.showMessageDialog(null, text); 

        driver.switchTo().window(parentWindow);
        String secondText = driver.findElement(By.xpath("//h3[text() = 'Opening a new window']")).getText();

        JOptionPane.showMessageDialog(null, secondText);

    }
    public static void main(String[] args) {
        Homework4 obj = new Homework4();
        obj.launchBrowser();
        obj.getUrl();
        obj.windowsActivities();
        obj.exercise();
    }
}
