package SeleniumFirst;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class StaticDropDown {
    WebDriver driver;

    public void launchbrowser() {
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");

        driver = new EdgeDriver();

    }

    public void GettibgURl() {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    public static void main(String[] args) {
        StaticDropDown Obj = new StaticDropDown();
        Obj.launchbrowser();
        Obj.GettibgURl();

    }
}
