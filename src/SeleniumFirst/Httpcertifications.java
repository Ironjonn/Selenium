package SeleniumFirst;


import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Httpcertifications {
    // For more information you can go to
    // https://chromedrivger.chromium.org/capabilities you can set where you want to
    // donwload any thing or set the proxy this is yous an example of the class
    // ChromeOptions, also block pop ups ventanitas que no quieres 

    WebDriver driver;
    ChromeOptions options = new ChromeOptions();

    Proxy proxy = new Proxy();


    public void launchBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\\\chromedriver.exe");
        options.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(options);

        proxy.setHttpProxy("ipaddres:4444");
        options.setCapability("proxy", proxy); 
        Map <String, Object> pref = new HashMap <String, Object>();

        pref.put("download.default_directory", "/directory/path");

    }

    public void geturl() {
        driver.navigate().to("https://expired.badssl.com/");
    }

    public void windowsActivities() {

        driver.manage().window().maximize();
    }

    public static void main(String[] args) {
        Httpcertifications obj = new Httpcertifications();
        obj.launchBrowser();
        obj.geturl();
        obj.windowsActivities();

    }

}
