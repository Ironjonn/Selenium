package SeleniumFirst;

import org.openqa.selenium.WebDriver;
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

    public void example(){

    }
    public static void main(String[] args) {
        HandilingCalendarUI obx = new HandilingCalendarUI();
        obx.launchBrowser();
        obx.getUrl();
        obx.windowsActivities();
        obx.example();

    }
}
