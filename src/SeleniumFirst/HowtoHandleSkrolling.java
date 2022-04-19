package SeleniumFirst;

import java.util.List;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.Assert;

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

    public void example() throws InterruptedException {
        JavascriptExecutor objx = (JavascriptExecutor) driver;

        objx.executeScript("window.scrollBy(0,200)");
        Thread.sleep(2000);

        objx.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

        List<WebElement> table = driver.findElements(By.xpath("//*[@class = 'tableFixHead']//td[4]"));

        int sum = 0;

        for (int i = 0; i < table.size(); i++) {

            String tablesize = table.get(i).getText();

            sum = sum + Integer.parseInt(tablesize);

        }

        JOptionPane.showMessageDialog(null, sum);

        String name = driver.findElement(By.xpath("//*[@class = 'totalAmount']")).getText();
        // Total Amount Collected: 296

        String[] namearray = name.split(":");
        String number = namearray[1];
        String amount = number.trim();
        System.out.println(amount);

        String value = String.valueOf(sum);

        if (amount.equals(value)) {
            JOptionPane.showMessageDialog(null, "Your successfully loged in congrats ");
        } else {
            JOptionPane.showMessageDialog(null, "Your failed the completed amount ");
        }

    }
    public static  int total1;
    private void secondtable() {
        List<WebElement> table2 = driver.findElements(By.xpath("//table[@class = 'table-display']//td[3]"));

        int summ = 0;
        for (int t = 0; t < table2.size(); t++) {
            String tablefull = table2.get(t).getText();

            summ = summ + Integer.parseInt(tablefull);
        }

        JOptionPane.showMessageDialog(null, summ);

        this.total1 = summ;

        // Assert.assertEquals(summ, total);
    }

    public static int total2;
    
    public int total(){
        
        List<WebElement> table2 = driver.findElements(By.xpath("//table[@class = 'table-display']//td[3]"));
         int sume = 0;
        for(int y =0; y<table2.size(); y++){
            String totale = table2.get(y).getText();

            sume = sume + Integer.parseInt(totale);


            this.total2 = sume;
            
        }
        return total2;
        
    }

    

    public static void main(String[] args) throws InterruptedException {
        HowtoHandleSkrolling obj = new HowtoHandleSkrolling();
        obj.launchBrowser();
        obj.getUrl();
        obj.windowsActivities();
        obj.example();

        obj.secondtable();

        obj.total();

        Assert.assertEquals(total1, total2);
    }
}
