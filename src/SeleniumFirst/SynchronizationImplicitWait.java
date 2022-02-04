package SeleniumFirst;

//import static java.util.concurrent.TimeUnit.SECONDS;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SynchronizationImplicitWait {
    WebDriver driver;
    // Maneras de syncroinizar los tiempos en selenium
    // Implicit Wait
    // * It is defined globaly and you are tel;ling selenium hey wait for 3 seconds
    // before you throw exception espera 3 o los segundo sque quiereas para que
    // cvargue la pagina antes que mande el error un ejemplo si pones 5 segundos que
    // es el maximo tiempo y la pagina tarda en cargar 2 segundos no esperara hasta
    // los 5 segundos sino que continuara ya sea que tardo 3 segundos o 2 segundo lo
    // hara sin esperar el resto de segundos

    // Explicit Wait
    // Thread.Sleep
    // Fluent Wait

    // Mismo ejemplo de AddingItemtocart
    public void launchBrowser() {
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
        driver = new EdgeDriver();
        // Ejemplo de implicit wait es aplicado global mente cada vez que el webdriver
        // busque algun locator esperara esos segundos que tu indiques
        //el ejemplo primerod e abajo me da error como una advertencia si funciona como el otro de hecho esta impoprtado arriba 
        //driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    public void getUrl() {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

    }

    public void windowsActivities() {
        driver.manage().window().maximize();
    }

    public void addItems() throws InterruptedException {
        Thread.sleep(3000);
        // Array of mames to add in the cart
        String[] Vegetables = { "Cucumber", "Beans", "Brocolli", "Beetroot", "Corn", "Mushroom" };

        int exit = 0;

        List<WebElement> productos = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i = 0; i < productos.size(); i++) {

            String[] name = productos.get(i).getText().split("-");

            // Quitamos el estacion con el metodo trim
            String easynames = name[0].trim();
            
            // Convert array into arraylist for easy search
            List<String> VegetablesList = Arrays.asList(Vegetables);
            // Check wether name you extracted is present in arraylist or not

            if (VegetablesList.contains(easynames)) {
                exit++;
                //
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                // Cuando tienes una lista de arrays no puedes usar el brack porque se detiene
                // el codigo por eso esta comentado es un error de programacion
                // break;
                if (exit > Vegetables.length) {

                    break;
                }

            }

        }

    }

    public void example() {
        driver.findElement(By.xpath("//img[@alt='Cart']")).click();

        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        driver.findElement(By.cssSelector("input[placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
        
        driver.findElement(By.xpath("//div[@class='promoWrapper']//button[@class='promoBtn']")).click();
        JOptionPane.showMessageDialog(null, driver.findElement(By.xpath("//div[@class='promoWrapper']//span[@class='promoInfo']")).getText());  

    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizationImplicitWait Objecto = new SynchronizationImplicitWait();
        Objecto.launchBrowser();
        Objecto.getUrl();
        Objecto.windowsActivities();
        Objecto.addItems();
        Objecto.example();

    }
}
