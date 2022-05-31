package SeleniumFirst;

import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class FilterWebtable  {
    
    WebDriver driver; 

    public void launchBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\\\chromedriver.exe"); 

        driver = new ChromeDriver(); 

    }

    public void window(){
        driver.manage().window().maximize();
    }

    public void deletcokk(){
        driver.manage().deleteAllCookies();
    }

    public void reachUrl(){
        driver.navigate().to("https://rahulshettyacademy.com/seleniumPractise/#/offers");
    }

    public void handson() throws InterruptedException{

        String fruta = JOptionPane.showInputDialog(null, "Wich fruit or vegetable do you want to select ? "); 

        driver.findElement(By.xpath("//div/input[@id = 'search-field']")).sendKeys(fruta);
        Thread.sleep(2000);
        List <WebElement> vegetales = driver.findElements(By.xpath("//tr/td[1]"));
        System.out.println(vegetales.size());

        // vegetales.stream().map(s->s.getText()).forEach(s->System.out.println(s));;
        Thread.sleep(2000);
        List <WebElement> filtervegetales = vegetales.stream().filter(vegt->vegt.getText().contains(fruta)).collect(Collectors.toList());

        System.out.println(filtervegetales.size());
        Assert.assertEquals(vegetales.size(), filtervegetales.size());
    }
    public static void main(String[] args) throws InterruptedException {
        FilterWebtable obj = new FilterWebtable(); 
        obj.launchBrowser();
        obj.window();
        obj.deletcokk();
        obj.reachUrl();
        obj.handson();

    }
}
