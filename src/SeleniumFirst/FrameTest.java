package SeleniumFirst;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameTest {
    //checa el homework 5 hay vienen los nasted frames para que sepas como trabajar con ellos 
    WebDriver driver; 
    
    public void launchBrowser(){
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
        driver = new EdgeDriver();
    }

    public void getUrl(){
        driver.navigate().to("https://jqueryui.com/droppable/");
    }

    public void windowsActivities(){
        driver.manage().window().maximize();
    }

    public void example (){
        //Esto sirve para identificar primero al frame en la pagina ya que es aparte del html y si lo buscas antes sin encontrar el frame el driver no entrara al mismo 
       // driver.switchTo().frame(driver.findElement(By.xpath("//*[@class = 'demo-frame']")));
        //puedes buscar el frame por index en una pagina ejemplo el 1 es el 2 porque el primero es 0 esto es ejemplo pero convieme mejor bucarlo como arriba por el webelement ya que si un programador agrega mas frames cambia el orden 
        driver.switchTo().frame(0);
        //este sirve para buscar el frame por su id cuando lo tiene es mas rapido en mi caso no habia asi que lo busque por webelement 
        //driver.switchTo().frame("nameOrId");

        int sizeFrame = driver.findElements(By.tagName("iframe")).size();
        JOptionPane.showMessageDialog(null, sizeFrame);  
    
       WebElement source  =  driver.findElement(By.xpath("//*[@id ='draggable']"));
       WebElement target = driver.findElement(By.xpath("//*[@id ='droppable']"));

       
        

        Actions a = new Actions(driver);
        a.dragAndDrop(source, target).build().perform();
        
        //una vez que termines de trabajar con el frame tienes que salir de el driver ejemplo seguir trabajando con otro contenido 
       driver.switchTo().defaultContent();
        


    }

    public static void main(String[] args) {
        FrameTest objc = new FrameTest();
        objc.launchBrowser();
        objc.getUrl();
        objc.windowsActivities();
        objc.example();
        
    }
}
