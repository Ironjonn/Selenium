package SeleniumFirst;

import java.util.List;
import java.util.Arrays;
import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static java.util.concurrent.TimeUnit.SECONDS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class SynchronizationExplicitWait {
    
    WebDriver driver;
    // Mismo ejemplo de AddingItemtocart
    public void launchBrowser() {
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
        driver = new EdgeDriver();
        // Ejemplo de implicit wait es aplicado global mente cada vez que el webdriver
        // busque algun locator esperara esos segundos que tu indiques
        
        driver.manage().timeouts().implicitlyWait(5, SECONDS);

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
        JOptionPane.showMessageDialog(null, driver.findElement(By.xpath("//div[@class='promoWrapper']//span[text()='Code applied ..!']")).getText());  

    }
    
    public static void main(String[] args) {
        
    }
}
