package SeleniumFirst;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Elementsdisableorenambel {
    WebDriver mydriver;

    public void launchBrowser(){
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
        mydriver = new EdgeDriver();

    }
    public void Geturl(){
        mydriver.get("https://rahulshettyacademy.com/dropdownsPractise/");

    }

    public void Windowactivities(){
        mydriver.manage().deleteAllCookies();
        mydriver.manage().window().maximize();
    }

    public void Example(){
        mydriver.findElement(By.xpath("//*[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();
    }

    public static void main(String[] args) {
        Elementsdisableorenambel objeto = new Elementsdisableorenambel();
        objeto.launchBrowser();
        objeto.Geturl();
        objeto.Windowactivities();
        objeto.Example();

    }
}
