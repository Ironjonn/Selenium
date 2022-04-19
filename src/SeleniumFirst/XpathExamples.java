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
        driver.findElement(By.xpath("(//input[@name ='ctl00$mainContent$rbtnl_Trip'])[2]")).click();

        //Seleccionando un hijo del padre sin index con xpath 
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

        //Seleccionando un locator que tenga muy largo el nombre o lo usemos para reducirlo usando solo 4 letras 
        driver.findElement(By.xpath("//input[contains(@id,'friendsa')]")).click();

        //Seleccionando el texto de algun lugar que no cambie el texto lo puedes usar haciendo click trllendo texto etx 
        JOptionPane.showMessageDialog(null, driver.findElement(By.xpath("//*[text()='Special Assistance']")).getText());  


        //Seleccionando el relative Xpath y con el *decimos cualquier tag que tenga el atributo dado 
        driver.findElement(By.xpath("//*[@id ='ctl00_mainContent_ddl_originStation1_CTXT']")).click();

        //Como viajar de un xpath padre a un hijo en la segunda posicion este de abajo no es de esta pagina solo es ejemplo no funciona aqui 
        driver.findElement(By.xpath("//p[@class='text-center text-white']/b[2]")).getText();

        //Como viajar en un xpath padre a hijo y de hijo a nieto usando herencia en el xpath este ejemplo es de la clase Homework3 aqui no funciona
        driver.findElement(By.xpath("//div[@class ='form-check-inline']/label[2]/span[1]")).click();

        //Seleccionando un link de algunma pagina con el href ejemplo no es de esta clase 
        driver.findElement(By.xpath("//*[@href='/dynamic_loading/1']")).click();


        //Seleccionando el elemento navegando por los tags nota que td[1] lo selecciona porque en el tag hay mas td 1, 2 o 3 que seleccionamos el index delprimero 
        //nota solo es ejemplo aqui no funciona 
        driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));

        //Los elementos de abajo se usan cuando creas un web element de alguna parte de la pagina y despues llamas a sus tags etc dentro de ese elemento usando xpath 

        //dhead.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]/input")).click();

        // JOptionPane.showMessageDialog(null, row1.findElement(By.xpath("//tr[3]//td[3]")).getText());

        // WebElement row3 = row1.findElement(By.xpath("//tr[3]"));


        

        
    }
    public static void main(String[] args) throws InterruptedException {
        XpathExamples Obj = new XpathExamples();
        Obj.launchBrowser();
        Obj.GetUrl();
        Obj.Windowactivities();
        Obj.XpathExampless();

    }
}
