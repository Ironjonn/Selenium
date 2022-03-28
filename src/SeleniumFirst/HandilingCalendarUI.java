package SeleniumFirst;

import java.util.List;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HandilingCalendarUI {
    WebDriver driver;

    public void launchBrowser() {
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
        driver = new EdgeDriver();

    }

    public void getUrl() {
        driver.navigate().to("https://www.path2usa.com/travel-companions");

    }

    public void windowsActivities() {
        driver.manage().window().maximize();
    }

    public void gettingdays(){
        
        String insertday = JOptionPane.showInputDialog(null, "Please insert the day you want to select in the calendar");


        driver.findElement(By.xpath("//*[@name = 'travel_date']")).click();
        //driver.findElement(By.xpath("//input[contains(@id,'friendsa')]")).click();

       List <WebElement> days = driver.findElements(By.xpath("//td[contains(@class,'day')]"));
       int dayssize = days.size();
       System.out.println(dayssize);
       for(int i = 0; i<dayssize; i++){
          String daysname =   days.get(i).getText();

          if(daysname.equalsIgnoreCase(insertday)){
            days.get(i).click();

            break;
          }
       }
    }

    public void gettingmonths (){
        
    }
    public static void main(String[] args) {
        HandilingCalendarUI obx = new HandilingCalendarUI();
        obx.launchBrowser();
        obx.getUrl();
        obx.windowsActivities();
        obx.gettingdays();

    }
}
