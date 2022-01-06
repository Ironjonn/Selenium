package SeleniumFirst;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

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
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
        //Assert.assertFalse(true);JOptionPane.showMessageDialog(null , driver.findElement(By.xpath("//*[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
        
        driver.findElement(By.xpath("//*[contains(@id,'SeniorCitizenDiscount')]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
        //JOptionPane.showMessageDialog(null , driver.findElement(By.xpath("//*[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
    }

    public void Checkbossieze(){
        //como checar cuantos elementos hay de checkbox en el padre 
        JOptionPane.showMessageDialog(null, driver.findElements(By.xpath("//input[@type='checkbox']")).size());
        
    }


    public static void main(String[] args) {
        Checkbox MyObjts = new Checkbox();
        MyObjts.launchBrowser();
        MyObjts.GetUrl();
        MyObjts.Windowsactivities();
        MyObjts.Example();
        MyObjts.Checkbossieze();

    }
}
