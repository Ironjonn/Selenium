package SeleniumFirst;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Homework3 {

    WebDriver driver;

    public void launchBrowser() {
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
        driver = new EdgeDriver();
    }

    public void getUrl() {
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
    }

    public void windowsActivities() {
        driver.manage().window().maximize();
    }

    public String extractingusername() {
        String extractingusername;
        extractingusername = driver.findElement(By.xpath("//div[@class='form-group']//i[text()]")).getText();
        JOptionPane.showMessageDialog(null, extractingusername);
        // driver.switchTo().alert().accept();
        return extractingusername;
    }

    public String extractingpassword() {
        String extractingpassword;
        extractingpassword = driver.findElement(By.xpath("//p[@class='text-center text-white']/b[2]")).getText();
        JOptionPane.showMessageDialog(null, extractingpassword);

        return extractingpassword;
    }

    public void sendingusername(String sendingsername) {

        driver.findElement(By.cssSelector("input[id = 'username']")).sendKeys(sendingsername);
    }

    public void sendingpassword(String sendingpassword) {
        driver.findElement(By.xpath("//input[@id= 'password']")).sendKeys(sendingpassword);
    }

    public static void main(String[] args) {
        Homework3 objx = new Homework3();
        objx.launchBrowser();
        objx.getUrl();
        objx.windowsActivities();
        objx.extractingusername();

        String gettingusername = objx.extractingusername();
        objx.sendingusername(gettingusername);

        String gettingpassword = objx.extractingpassword();
        objx.sendingpassword(gettingpassword);
    }
}
