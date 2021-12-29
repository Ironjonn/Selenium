package SeleniumFirst;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AutosuggestiveDropdown{
    WebDriver driver; 

    public void launchbrowser(){
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
        driver = new EdgeDriver();
    }

    public void GetUrl(){
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

    
    }
    
     


    


    public static void main(String[] args) {
        
        AutosuggestiveDropdown Myobjct = new AutosuggestiveDropdown();
        Myobjct.launchbrowser();
    }
}
