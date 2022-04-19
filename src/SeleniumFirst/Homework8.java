package SeleniumFirst;

import java.util.List;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

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

    public void work() throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='NO THANKS']")).click();

        driver.findElement(By.xpath("//*[@href='https://www.rahulshettyacademy.com/AutomationPractice']")).click();

        String country = JOptionPane.showInputDialog(null, "Please insert the country you want to search ");

        driver.findElement(By.xpath("//*[@class = 'inputs ui-autocomplete-input']")).sendKeys(country);
        Thread.sleep(2000);

        List<WebElement> options = driver.findElements(By.xpath("//*[@id = 'ui-id-1']/li[@class='ui-menu-item']"));

        WebElement usa = driver.findElement(By.xpath("//*[@id = 'ui-id-1']/li[@class = 'ui-menu-item'][6]"));

        
        Actions movingmouse = new Actions(driver);
        Thread.sleep(2000);

        // This is an example of (for each) is declared as below example,
        // You create a variable as same type as the array or in this case array list
        // webelement in this case and it will travel all the arraylist and assign the
        // value
        // into the variable that we created in this case option
        for (WebElement option : options) {

            if (option.getText().contains(country)) {
                
                movingmouse.moveToElement(usa).clickAndHold().build().perform();
                Thread.sleep(1000);

                movingmouse.release().build().perform();
                
            }
            break;
        }
        Thread.sleep(2000);
        String countryselected = driver.findElement(By.xpath("//*[text() = 'United States (USA)']")).getText();
         JOptionPane.showMessageDialog(null, countryselected);
    }

    public static void main(String[] args) throws InterruptedException {
        Homework8 object = new Homework8();
        object.launchBrowser();
        object.gettingurl();
        object.windowsActivities();
        object.work();

    }
}
