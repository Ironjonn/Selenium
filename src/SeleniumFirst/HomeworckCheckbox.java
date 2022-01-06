package SeleniumFirst;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class HomeworckCheckbox {

    WebDriver driver;

    public void launchBrowser() {
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
        driver = new EdgeDriver();

    }

    public void GetUrl() {

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

    }

    public void Windowactivities() {

        driver.manage().window().maximize();

    }

    public void Tarea() throws InterruptedException {
        // Check the first Checkbox and verify if it is successfully checked and Uncheck
        // it again to verify if it is successfully Unchecked
        driver.findElement(By.xpath("//*[@id = 'checkBoxOption1']")).click();
        Thread.sleep(2000L);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id = 'checkBoxOption1']")).isSelected());
        driver.findElement(By.xpath("//*[@id = 'checkBoxOption1']")).click();
        Thread.sleep(2000L);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id = 'checkBoxOption1']")).isSelected(), false);

        // el joption pain sirve para saber que todo lo de arriba esta bien como si
        // fuera un assert
        JOptionPane.showMessageDialog(null, driver.findElement(By.xpath("//*[@id = 'checkBoxOption1']")).getText());
        Thread.sleep(1000);

        // How to get the Count of number of check boxes present in the page
        JOptionPane.showMessageDialog(null, driver.findElements(By.xpath("//*[@type='checkbox']")).size());
    }

    public static void main(String[] args) throws InterruptedException {
        HomeworckCheckbox Object = new HomeworckCheckbox();
        Object.launchBrowser();
        Object.GetUrl();
        Object.Windowactivities();
        Object.Tarea();

    }
}
