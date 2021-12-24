package SeleniumFirst;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown {
    WebDriver driver;

    public void launchbrowser() {
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");

        driver = new EdgeDriver();

    }

    public void GettibgURl() {

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    public void Windowactivities() {
        driver.manage().window().maximize();
    }

    public void FirstDropDown() {

        WebElement staticDropdown = driver.findElement(By.xpath("//*[@id = 'ctl00_mainContent_DropDownListCurrency']"));
        Select dropdown = new Select(staticDropdown);

        dropdown.selectByIndex(3);
        JOptionPane.showMessageDialog(null, dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("AED");
        JOptionPane.showMessageDialog(null, dropdown.getFirstSelectedOption().getText());
        dropdown.selectByValue("INR");
        JOptionPane.showMessageDialog(null, dropdown.getFirstSelectedOption().getText());

    }

    public static void main(String[] args) {
       StaticDropDown Obj = new StaticDropDown();
        Obj.launchbrowser();
        Obj.Windowactivities();
        Obj.GettibgURl();
        Obj.FirstDropDown();
        

    }
}
