package SeleniumFirst;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Checkbox {
    
    WebDriver driver;

    public void launchBrowser(){
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");

        driver = new EdgeDriver();

    }

    public void GetUrl(){
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    public void Windowsactivities(){

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

    }
    
    public void Example(){
        JOptionPane.showMessageDialog(null , driver.findElement(By.xpath("//*[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
        driver.findElement(By.xpath("//*[contains(@id,'SeniorCitizenDiscount')]")).click();
        JOptionPane.showMessageDialog(null , driver.findElement(By.xpath("//*[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
    }

    public void Example2(){
        JOptionPane.showMessageDialog(null, driver.findElements(By.xpath("//input[@type='checkbox']")).size());
        
    }


    public static void main(String[] args) {
        Checkbox MyObjts = new Checkbox();
        MyObjts.launchBrowser();
        MyObjts.GetUrl();
        MyObjts.Windowsactivities();
        MyObjts.Example();
        MyObjts.Example2();

    }
}
