package SeleniumFirst;

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

        // // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // String insertmonth = JOptionPane.showInputDialog(null, "Please insert the month you want to select in the calendar");

        // String monthss = driver.findElement(By.xpath("//*[@class = 'datepicker-months']//[contains(@class ='month')]")).getText();

        // JOptionPane.showMessageDialog(null , monthss);
        
         
        

        // driver.findElement(By.xpath("//*[@class = 'datepicker-days'] //th[@class = 'datepicker-switch']")).click();


        

        // List<WebElement> months = driver.findElements(By.xpath("//*[contains(@class, 'month')]"));
        // int monthssize = months.size();
        
        // System.out.print(monthssize);
        

        // Thread.sleep(2000);

        // for (int m = 0; m < monthssize; m++) {
        //     String monthsname = months.get(m).getText();

        //     if (monthsname.equalsIgnoreCase(insertmonth)) {
        //         months.get(m).click();
        //     }
        // }
        driver.findElement(By.xpath("//*[@name = 'travel_date']")).click();

        String month = JOptionPane.showInputDialog(null, "Please select one Month top fly ");

        while(!driver.findElement(By.xpath("//*[@class = 'datepicker-days'] //th[@class = 'datepicker-switch']")).getText().contains(month)){
            driver.findElement(By.xpath("//*[@class = 'datepicker-days'] //th[@class= 'next']")).click();
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
