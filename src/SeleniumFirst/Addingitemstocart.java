package SeleniumFirst;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Addingitemstocart {
    WebDriver driver;
    String[] name = {};

    public void launchBrowser() {
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
        driver = new EdgeDriver();

    }

    public void getUrl() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        Thread.sleep(2000);
    }

    public void windowsActivities() {
        driver.manage().window().maximize();

    }

    public void example() throws InterruptedException {
        //Array of mames to add in the cart 
        String[] Vegetables = { "Cucumber", "Beans", "Brocolli", "Beetroot", "Corn", "Mushroom"};
        Thread.sleep(2000);
        int exit = 0;

      // driver.findElement(By.xpath("(//div[@class='product-action'])[13]")).click();

        List<WebElement> productos = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i = 0; i < productos.size(); i++) {

            
            //Format into actual vegetable name 
            //Separamos el string real que es = Cucumber - 1 Kg y lo convertimos en un array para buscarlo mejor arriba 
            String[] name = productos.get(i).getText().split("-");

            //Quitamos el espacion con el metodo trim 
            String easynames = name[0].trim();
            
            // Convert array into arraylist for easy search
            List <String> VegetablesList = Arrays.asList(Vegetables);
            // Check wether name you extracted is present in arraylist or not

            if (VegetablesList.contains(easynames)) {
                exit++;
                //
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                
                //Cuando tienes una lista de arrays no puedes usar el brack porque se detiene el codigo por eso esta comentado es un error de programacion 
                //break;
                if(exit >Vegetables.length){
                    
                    break;
                }
                
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Addingitemstocart Objeto = new Addingitemstocart();
        Objeto.launchBrowser();
        Objeto.getUrl();
        Objeto.windowsActivities();
        Objeto.example();
    }
}
