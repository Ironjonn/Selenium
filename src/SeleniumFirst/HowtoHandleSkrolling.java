package SeleniumFirst;

import java.util.List;

import javax.print.attribute.standard.JobHoldUntil;
import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebElement;


public class HowtoHandleSkrolling {


    WebDriver driver;

    public void launchBrowser() {
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
        driver = new EdgeDriver();
        // Implicit wait se aplica globalmente que espere tantos segundos en encontrar
        // el objecto
        

    }

    public void getUrl() {
        driver.navigate().to("https://www.rahulshettyacademy.com/AutomationPractice/");
    }

    public void windowsActivities() {
        driver.manage().window().maximize();
    }

    public void example() throws InterruptedException{
        JavascriptExecutor objx = (JavascriptExecutor)driver;

        objx.executeScript("window.scrollBy(0,200)");
        Thread.sleep(2000);

        objx.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

        List<WebElement> table = driver.findElements(By.xpath("//*[@class = 'tableFixHead']//td[4]"));

        int sum = 0;
        
        for(int i = 0; i<table.size(); i++){
            
            String tablesize = table.get(i).getText();
          
          
            sum = sum + Integer.parseInt(tablesize);

            
            
        }
                    
        JOptionPane.showMessageDialog(null, sum);

        String name =  driver.findElement(By.xpath("//*[@class = 'totalAmount']")).getText();
        //Total Amount Collected: 296
        
        String[] namearray = name.split(":");
        String number =  namearray[1];
        String amount = number.trim();
        System.out.println(amount);

        String value =  String.valueOf(sum);
       
        if(amount.equals(value)){
            JOptionPane.showMessageDialog(null, "Your successfully loged in congrats ");
        }else{
            JOptionPane.showMessageDialog(null, "Your failed the completed amount ");
        }

        
        

    }
    public static void main(String[] args) throws InterruptedException {
        HowtoHandleSkrolling obj = new HowtoHandleSkrolling();
        obj.launchBrowser();
        obj.getUrl();
        obj.windowsActivities();
        obj.example();
    }
}
