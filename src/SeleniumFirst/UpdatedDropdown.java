package SeleniumFirst;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class UpdatedDropdown {
    WebDriver driver;

    public void launchbrowser() {
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");

        driver = new EdgeDriver();

    }

    public void GettibgURl() {

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    public void Windowactivities() {
        driver.manage().window().maximize();
    }

    public void testing() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='divpaxinfo']")).click();
        Thread.sleep(2000L);
        
        int i =1;

        while (i<5) {
            
            driver.findElement(By.xpath("//*[@id='hrefIncAdt']")).click();
            Thread.sleep(1000);
            i++;
        }
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@class='buttonN']")).click();;
        Thread.sleep(1000);

        JOptionPane.showMessageDialog(null , driver.findElement(By.xpath("//*[@id='divpaxinfo']")).getText());

    }

    public static void main(String[] args) throws InterruptedException {
        UpdatedDropdown Object = new UpdatedDropdown();
        Object.launchbrowser();
        Object.GettibgURl();
        Object.Windowactivities();
        Object.testing();

    }
}
