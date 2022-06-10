package SeleniumFirst;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class IvokingMultipleWindows extends MainJava {

    public void handson() throws InterruptedException {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://rahulshettyacademy.com");
        Thread.sleep(2000);
        List<WebElement> lista = driver.findElements(By.xpath("//div[@id = 'courses-block']//h2/a[@href][1]"));
        String cursename = lista.get(0).getText();

        Set<String> pages = driver.getWindowHandles();
        Iterator<String> num = pages.iterator();
        String parentWindow = num.next();
        String childwindow = num.next();

        

        driver.switchTo().window(parentWindow);

         lista = driver.findElements(By.xpath("//div[@id = 'courses-block']//h2/a[@href][1]"));
        Thread.sleep(2000);

        System.out.println(cursename);
        WebElement uno = driver.findElement(By.xpath("//label[text()='Name']"));
        // WebElement uno = driver.findElement(By.xpath("//label[text() = 'Email']"));

        Thread.sleep(2000);
        driver.findElement(with(By.tagName("input")).near(uno)).sendKeys(cursename);
        

        // dos.sendKeys(cursename);

        
    }

    public static void main(String[] args) throws InterruptedException {

        IvokingMultipleWindows obj = new IvokingMultipleWindows();
        obj.launchBrowser();
        obj.windowsActivities();
        obj.reachUrl("https://rahulshettyacademy.com/angularpractice/");
        obj.deleatecokkies();
        obj.handson();

    }
}
