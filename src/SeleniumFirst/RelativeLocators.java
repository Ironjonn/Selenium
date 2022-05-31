package SeleniumFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import javax.swing.JOptionPane;

public class RelativeLocators extends MainJava {

    //Selenium relative locator, friendly locator 
    //relative locator doesnot reconice flex tag 

    //Methods to use 
    //above(): element located above with respect to the specific element 
    //Below(): element located Below with respect to the specific element 
    //toLeftOf(): element located to the left of  specific element   
    //toRightOf(): element located to the right of  specific element   

    //Syntaxis 
    // driver.findElement(with(By.TagName("XX")).above(WebElement))


    public static void main(String[] args) {
        RelativeLocators obj = new RelativeLocators(); 

        obj.launchBrowser();
        obj.windowsActivities();
        obj.reachUrl("https://rahulshettyacademy.com/angularpractice/");
        obj.deleatecokkies();

       WebElement locator1 =  obj.driver.findElement(By.xpath("//form//div//input[@name = 'name']"));
       WebElement locatorfather = obj.driver.findElement(with(By.tagName("label")).above(locator1));

       JOptionPane.showMessageDialog(null, locatorfather.getText()); 

        System.out.println(obj.driver.findElement(By.xpath("//label[text() = 'Name']")).getText()); 

        WebElement calendaravobe = obj.driver.findElement(By.xpath("//form//div//label[@for= 'dateofBirth']")); 

        WebElement InsertDay = obj.driver.findElement(with(By.tagName("input")).below(calendaravobe));

        InsertDay.click();

        WebElement check =  obj.driver.findElement(By.xpath("//div/label[@for ='exampleCheck1']"));
        WebElement checkleft = obj.driver.findElement(with(By.tagName("input")).toLeftOf(check));
        checkleft.click();

        WebElement buttonRadio =  obj.driver.findElement(By.xpath("//div/input[@id= 'inlineRadio1']"));

        WebElement rightToButton = obj.driver.findElement(with(By.tagName("label")).toRightOf(buttonRadio)); 
        JOptionPane.showMessageDialog(null, rightToButton.getText()); 
    }

    
}
