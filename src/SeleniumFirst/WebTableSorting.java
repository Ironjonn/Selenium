package SeleniumFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebTableSorting extends MainJava {
    
    public void Table(){
       WebElement topDeals =  driver.findElement(By.xpath("//*[@class = 'cart']"));
        topDeals.findElement(By.xpath("//*[@class = 'cart-header-navlink'][1]")).click();
    }
    
    
    public static void main(String[] args) {
        WebTableSorting obj = new WebTableSorting();
        obj.launchBrowser();
        obj.windowsActivities();
        obj.reachUrl("https://rahulshettyacademy.com/seleniumPractise/#/");
        obj.deleatecokkies(); 
        obj.Table();   
    }
}
