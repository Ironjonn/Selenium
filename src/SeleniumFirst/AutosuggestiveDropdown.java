package SeleniumFirst;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AutosuggestiveDropdown {
    WebDriver driver;

    public void launchbrowser() {
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
        driver = new EdgeDriver();
    }

    public void GetUrl() {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

    }

    public void Windowsactivities() {
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    public void Example() throws InterruptedException {
        // driver.findElement(By.xpath("//*[@id='autosuggest']")).click();;

        driver.findElement(By.xpath("//*[@id='autosuggest']")).sendKeys("ind");
        
        Thread.sleep(2000);
        List<WebElement> options =driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
       
        for(WebElement option :options){
            
            if(option.getText().equalsIgnoreCase("india")){
                option.click();
                break;
            }
            
        }
    }

    public static void main(String[] args) throws InterruptedException {

        AutosuggestiveDropdown Myobjct = new AutosuggestiveDropdown();
        Myobjct.launchbrowser();
        Myobjct.GetUrl();
        Myobjct.Windowsactivities();
        Myobjct.Example();

    }
}
