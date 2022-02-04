package SeleniumFirst;

import java.util.List;
import java.util.Arrays;
import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SynchronizationExplicitWait {

    static WebDriver driver;

    // Mismo ejemplo de AddingItemtocart
    //Se utiliza solo para el locator que queremos que espere unos segundos en cargar y no en todos globalmente como implicity wait 
    public void launchBrowser() {
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
        driver = new EdgeDriver();
        // Explicit wait example se tiene que crear un objeto

    }

    public void getUrl() {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

    }

    public void windowsActivities() {
        driver.manage().window().maximize();
    }

    public void addItems(WebDriverWait obj) {

        // Array of mames to add in the cart
        String[] Vegetables = { "Cucumber", "Beans", "Brocolli", "Beetroot", "Corn", "Mushroom" };

        int exit = 0;

        obj.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("h4.product-name")));

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

    public void example(WebDriverWait obj) {
        driver.findElement(By.xpath("//img[@alt='Cart']")).click();

        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

        obj.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Enter promo code']")));
        driver.findElement(By.cssSelector("input[placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");

        driver.findElement(By.xpath("//div[@class='promoWrapper']//button[@class='promoBtn']")).click();

        obj.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='promoWrapper']//span[@class='promoInfo']")));

        JOptionPane.showMessageDialog(null,
                driver.findElement(By.xpath("//div[@class='promoWrapper']//span[@class='promoInfo']")).getText());

    }

    public static void main(String[] args) {
        SynchronizationExplicitWait objeto = new SynchronizationExplicitWait();

        objeto.launchBrowser();
        objeto.getUrl();
        objeto.windowsActivities();
        WebDriverWait obj;
        obj = new WebDriverWait(driver, 20);
        objeto.addItems(obj);

        objeto.example(obj);

    }
}
