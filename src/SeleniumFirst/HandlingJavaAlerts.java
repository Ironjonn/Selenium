package SeleniumFirst;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HandlingJavaAlerts {
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

    public void examples() {
        String Text;
        Text = JOptionPane.showInputDialog(null, "Enter your name please ");

        driver.findElement(By.xpath("//*[@id = 'name']")).sendKeys(Text);

        driver.findElement(By.xpath("//*[@id ='alertbtn']")).click();
        JOptionPane.showMessageDialog(null, driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();
        driver.findElement(By.xpath("//*[@id='confirmbtn']")).click();
        JOptionPane.showMessageDialog(null, driver.switchTo().alert().getText());

        driver.switchTo().alert().dismiss();
        

    }

    public static void main(String[] args) {
        HandlingJavaAlerts Myobj = new HandlingJavaAlerts();
        Myobj.launchBrowser();
        Myobj.GetUrl();
        Myobj.Windowactivities();
        Myobj.examples();

    }
}
