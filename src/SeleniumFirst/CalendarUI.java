package SeleniumFirst;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CalendarUI {

    WebDriver mydriver; 

    public void launchBrowser(){
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
        mydriver = new EdgeDriver();
    }

    public void GetUrl ( ){
        mydriver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    public void Windowactivities(){
        mydriver.manage().deleteAllCookies();
        mydriver.manage().window().maximize();
    }

    public void Example() throws InterruptedException{
        mydriver.findElement(By.xpath("//*[@id='ctl00_mainContent_view_date1']")).click();
        Thread.sleep(2000);
      System.out.println(mydriver.findElement(By.cssSelector("a[.ui-state-defaultui-state-highlight]")).getText());  
        
    }
    public static void main(String[] args) throws InterruptedException {
        CalendarUI objeto = new CalendarUI();
        objeto.launchBrowser();
        objeto.GetUrl();
        objeto.Windowactivities();
       objeto.Example();
        System.out.println("Hola mundo desde Visualstudiocode");
    }
}
