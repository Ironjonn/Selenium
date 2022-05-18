package SeleniumFirst;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;



public class ActionsDemo {
    // acctions es usado para monitorear el mouse doble click hover etc para otras
    // funciones
    WebDriver driver;

    public void launchBrowser() {
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
        driver = new EdgeDriver();
        // Implicit wait se aplica globalmente que espere tantos segundos en encontrar
        // el objecto
        

    }

    public void getUrl() {
        driver.navigate().to("https://www.amazon.com.mx/");
    }

    public void windowsActivities() {
        driver.manage().window().maximize();
    }

    public void example() {

        Actions a = new Actions(driver);
        WebElement move = driver.findElement(By.xpath("//*[@class ='nav-a nav-a-2   nav-progressive-attribute']"));

        WebElement movei = driver.findElement(By.xpath("//*[@id ='twotabsearchtextbox']"));

        // context click es el right click
        a.moveToElement(move).contextClick().build().perform();
        a.moveToElement(movei).click().keyDown(Keys.SHIFT).sendKeys("hellows").doubleClick().build().perform();
        
    }

    public void example2() throws InterruptedException {
        Thread.sleep(3000);
        
        driver.navigate().to("https://rahulshettyacademy.com/loginpagePractise/#");;
        
        driver.findElement(By.cssSelector(".blinkingText")).click();
        Set <String> windows = driver.getWindowHandles();
        Iterator <String> it =  windows.iterator();
        //String parentID = it.next();
        String childID = it.next();
        driver.switchTo().window(childID);
        
        System.out.print(driver.findElement(By.xpath("//*[@class='im-para red']")).getText());  
        //driver.findElement(By.xpath("//*[text()= 'Free Access to InterviewQues/ResumeAssistance/Material']")).click();
        // driver.navigate().back();
        //driver.findElement(By.xpath("//a[@href = 'https://rahulshettyacademy.com/#/documents-request']")).click();


    }

    public static void main(String[] args) throws InterruptedException {
        ActionsDemo myobjt = new ActionsDemo();
        myobjt.launchBrowser();
        myobjt.getUrl();
        myobjt.windowsActivities();
        myobjt.example();

        myobjt.example2();

    }
}
