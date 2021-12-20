package SeleniumFirst;

import javax.swing.JOptionPane;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Locators3 {

    WebDriver driver;

    public void Setingbrowser() {
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();

    }

    public void GettibgURl() {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }

    public void testingXpath() {
        // ejemplos de xpath para viajas de padre a hijo y viseversa y de hermano a
        // hermano solo es posible en xpath no en css sirve para preguntas s
        // xpath parent to child and sibling to sibling
        JOptionPane.showMessageDialog(null,
                driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
        // xpath child to parent and sibling to sibling
        JOptionPane.showMessageDialog(null,
                driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());

    }

    public static void main(String[] args) {
        Locators3 Obj = new Locators3();
        Obj.Setingbrowser();
        Obj.GettibgURl();
        Obj.testingXpath();
    }

}