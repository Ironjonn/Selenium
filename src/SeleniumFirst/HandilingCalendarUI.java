package SeleniumFirst;

import java.util.ArrayList;
//  import java.time.Duration;
import java.util.List;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HandilingCalendarUI {
    static WebDriver driver;

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

    public void gettingmonths() throws InterruptedException {

        
        driver.findElement(By.xpath("//*[@name = 'travel_date']")).click();

        String month = JOptionPane.showInputDialog(null, "Please select one Month to fly ");

        //While loop will keep executing until it becomes false 
        // lo que hace el ciclo while es que correra el codigo siempre que sea true pero cuando se convierta falso sale del ciclo 
        // en este caso revertimos el driver si es falso lo convertimos true con el ! pero cuando llegue a ser true se convierte en falso 
        while(!driver.findElement(By.xpath("//*[@class = 'datepicker-days'] //*[@class ='datepicker-switch']")).getText().contains(month)){
            driver.findElement(By.xpath("//*[@class = 'datepicker-days']//*[@class = 'next']")).click();
        }

        
        

    }

    

    public void gettingdays() throws InterruptedException {

        // driver.findElement(By.xpath("//*[@name = 'travel_date']")).click();
        // driver.findElement(By.xpath("//input[contains(@id,'friendsa')]")).click();
        String insertday = JOptionPane.showInputDialog(null,
                "Please insert the day you want to select in the calendar");

        List<WebElement> days = driver.findElements(By.xpath("//td[contains(@class,'day')]"));
        int dayssize = days.size();

        for (int i = 0; i < dayssize; i++) {
            String daysname = days.get(i).getText();

            if (daysname.equalsIgnoreCase(insertday)) {
                days.get(i).click();

                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        HandilingCalendarUI obx = new HandilingCalendarUI();
        obx.launchBrowser();
        obx.getUrl();
        obx.windowsActivities();

        obx.gettingmonths();

        obx.gettingdays();

    }
}
