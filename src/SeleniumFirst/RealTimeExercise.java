package SeleniumFirst;

import javax.print.attribute.standard.JobHoldUntil;
import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class RealTimeExercise {

    WebDriver driver; 

    public void launchBrowser(){
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
        driver = new EdgeDriver();

    }

    public void getUrl(){
        driver.navigate().to("https://www.rahulshettyacademy.com/AutomationPractice/");
    }

    public void windowsActivities(){
        driver.manage().window().maximize();
    }

    public void example (){
        int size = driver.findElements(By.tagName("a")).size();
        JOptionPane.showMessageDialog(null, size); 

        //limiting webdriver scope este ejemplo estamos seleccionando solo desde el tag footer de la pagina 
        WebElement dfooter =    driver.findElement(By.xpath("//div[@id ='gf-BIG']"));
        int size2 = dfooter.findElements(By.tagName("a")).size();
        System.out.println(size2);  
    }

    public static void main(String[] args) {
        RealTimeExercise obj = new RealTimeExercise();
        obj.launchBrowser();
        obj.getUrl();
        obj.windowsActivities();
        obj.example();
    }
}
