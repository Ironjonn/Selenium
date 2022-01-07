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

    public void FromTo() throws InterruptedException {
        mydriver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_originStation1_CTXTaction']")).click();
        Thread.sleep(2000);
        mydriver.findElement(By.xpath("//a[@value='GOI']")).click();
        Thread.sleep(2000);
        mydriver.findElement(By.xpath("(//a[@value='JAI'])[2]")).click(); 
        Thread.sleep(1000L); 
        mydriver.findElement(By.cssSelector(".ui-state-defaultui-state-highlightui-state-active")).click();
        

    }

    public void Example(){
        
        mydriver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
        
       //System.out.println(mydriver.findElement(By.cssSelector("a[.ui-state-defaultui-state-highlight]")).getText());  
        
    }
    public static void main(String[] args) throws InterruptedException {
        CalendarUI objeto = new CalendarUI();
        objeto.launchBrowser();
        objeto.GetUrl();
        objeto.Windowactivities();
        objeto.FromTo();
        //Thread.sleep(2000);
       // objeto.Example();
        System.out.println("Hola mundo desde Visualstudiocode");
    }
}
