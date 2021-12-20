package SeleniumFirst;

import java.sql.Driver;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Locators3 {

    WebDriver driver;
   

 public void Setingbrowser(){
    System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
    driver = new EdgeDriver();

 }   

public void GettibgURl (){
    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
}

public void testingXpath (){
    //xpath parent to child and sibling to sibling 
     JOptionPane.showMessageDialog(null, driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
}

public static void main(String[] args) {
    Locators3 Obj = new Locators3();
    Obj.Setingbrowser();
    Obj.GettibgURl();
    Obj.testingXpath();
}

}