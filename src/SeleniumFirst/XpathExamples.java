package SeleniumFirst;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class XpathExamples {
    WebDriver driver;

    public void launchBrowser(){
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
        driver = new EdgeDriver();
    }

    public void GetUrl(){
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    public void Windowactivities(){
        driver.manage().window().maximize();
    }

    public void XpathExampless() throws InterruptedException{
        Thread.sleep(1000);
        //Seleccionando un hijo del padre dandolo en el orden que lo necesitas 
        driver.findElement(By.xpath("(//input[@name ='ctl00$mainContent$rbtnl_Trip'])[1]")).click();

        //Seleccionando un locator que tenga muy largo el nombre o lo usemos para reducirlo usando solo 4 letras 
        driver.findElement(By.xpath("//input[contains(@id,'friendsa')]")).click();

        //Seleccionando el texto de algun lugar asi lo traes 
        JOptionPane.showMessageDialog(null, driver.findElement(By.xpath("//*[text()='Special Assistance']")).getText());  


        //Seleccionando el relative Xpath y con el *decimos cualquier tag que tenga el atributo dado 
        driver.findElement(By.xpath("//*[@id ='ctl00_mainContent_ddl_originStation1_CTXT']")).click();



        

        
    }
    public static void main(String[] args) throws InterruptedException {
        XpathExamples Obj = new XpathExamples();
        Obj.launchBrowser();
        Obj.GetUrl();
        Obj.Windowactivities();
        Obj.XpathExampless();

    }
}