package SeleniumFirst;

import java.util.List;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework8 {
    WebDriver driver;

    public void launchBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    public void gettingurl() {
        driver.navigate().to("https://qaclickacademy.com");
    }

    public void windowsActivities() {
        driver.manage().window().maximize();
    }

    public void work() throws InterruptedException{
        driver.findElement(By.xpath("//*[text()='NO THANKS']")).click();

        driver.findElement(By.xpath("//*[@href='https://www.rahulshettyacademy.com/AutomationPractice']")).click();

       String country =  JOptionPane.showInputDialog(null, "Please insert the country you want to search ");
        driver.findElement(By.xpath("//*[@class = 'inputs ui-autocomplete-input']")).sendKeys(country);
        Thread.sleep(2000);

        List <WebElement> options = driver.findElements(By.xpath("//*[@class = 'ui-menu-item']"));

        

        for(WebElement option :options){

           if (option.getText().equalsIgnoreCase(country)){
                option.click();
                break;
           } 


        }
    }

    public static void main(String[] args) throws InterruptedException {
        Homework8 object = new Homework8();
        object.launchBrowser();
        object.gettingurl();
        object.windowsActivities();
        object.work();

    }
}
