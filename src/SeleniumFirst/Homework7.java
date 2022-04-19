package SeleniumFirst;

import java.time.Duration;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework7 {
    WebDriver driver;

    public void launchBrowser() {

        System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public void getUrl() {
        driver.get("https://qaclickacademy.com");
    }

    public void windowsActivities() {
        driver.manage().window().maximize();
    }

    public void working() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        driver.findElement(By.xpath("//*[text() = 'NO THANKS']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@href='https://www.rahulshettyacademy.com/AutomationPractice']")).click();

        // Examples on one table getting the information from 1 webelement that you can
        // reeuse to create another webelement
        WebElement row1 = driver.findElement(By.xpath("//*[@class = 'table-display']"));

        // first row
        JOptionPane.showMessageDialog(null, row1.findElements(By.tagName("tr")).size());

        // Second row
        JOptionPane.showMessageDialog(null, row1.findElements(By.tagName("th")).size());

        // third row
        

        WebElement row3 = row1.findElement(By.xpath("//tr[3]"));

        for (int i = 0; i <= row1.findElements(By.xpath("//tr[3]")).size(); i++) {

            JOptionPane.showMessageDialog(null, row3.findElements(By.tagName("td")).get(i).getText());

            System.out.println(row3.findElements(By.tagName("td")).get(i).getText());
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Homework7 objeto = new Homework7();
        objeto.launchBrowser();
        objeto.getUrl();
        objeto.windowsActivities();
        objeto.working();
    }
}
