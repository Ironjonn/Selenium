package SeleniumFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class WindowHandle {

    WebDriver driver; 

    public void launchBrowser(){
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
        driver = new EdgeDriver();
    }

        public void getUrl(){
            driver.navigate().to("https://rahulshettyacademy.com/loginpagePractise/#");
        }

        public void windowsActivities(){
            driver.manage().window().maximize();
        }


        public void example () throws InterruptedException{
            Thread.sleep(3000);
           
            
                
             
             Thread.sleep(2000);
             driver.findElement(By.xpath("//a[@href = 'https://rahulshettyacademy.com/#/documents-request']")).click();
             //driver.navigate().back();
        }
    public static void main(String[] args) {
            WindowHandle obj = new WindowHandle();
            obj.launchBrowser();
            obj.getUrl();
            obj.windowsActivities();

    }
}
