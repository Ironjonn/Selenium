package SeleniumFirst;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JOptionPane;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;


public class RealTimeExercise {

    static WebDriver driver;

    public void launchBrowser() {
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
        driver = new EdgeDriver();

    }

    public void getUrl() {
        driver.navigate().to("https://www.rahulshettyacademy.com/AutomationPractice/");
        JOptionPane.showMessageDialog(null, driver.getTitle()); 
    }

    public void windowsActivities() {
        driver.manage().window().maximize();
    }

    public void example() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // requirments example
        // 1 give me the count of links on the page

        int size = driver.findElements(By.tagName("a")).size();
        JOptionPane.showMessageDialog(null, size);

        // 2 give me the cout os links of the footer section
        // limiting webdriver scope este ejemplo estamos seleccionando solo desde el tag
        // footer de la pagina
        WebElement dfooter = driver.findElement(By.xpath("//div[@id ='gf-BIG']"));
        int size2 = dfooter.findElements(By.tagName("a")).size();
        JOptionPane.showMessageDialog(null, size2);

        // 3 give me the count of the first section os the footer section
        // limiting the scope just the first section os the footer section
        WebElement dfooter1 = driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        int size3 = dfooter1.findElements(By.tagName("a")).size();
        JOptionPane.showMessageDialog(null, size3);

        //4 click on each link in the column and check if the pages are opening 

        for(int i = 1; i<size3; i++){

            String clickonlinktab = Keys.chord(Keys.CONTROL,Keys.ENTER);

            
            
            Thread.sleep(2000);
            dfooter1.findElements(By.tagName("a")).get(i).sendKeys(clickonlinktab);
            Set<String> windows = driver.getWindowHandles();
            Iterator<String> it = windows.iterator();
            String parentWindow = it.next();
            String childWindow = it.next();

           
            driver.switchTo().window(childWindow);
            String childname = driver.getTitle();
            System.out.print(childname);
            driver.switchTo().window(parentWindow);

            
            

            


        }

    }

    public static void main(String[] args) throws InterruptedException {
        RealTimeExercise obj = new RealTimeExercise();
        obj.launchBrowser();
        obj.getUrl();
        obj.windowsActivities();
        
        obj.example();
    }
}
