package SeleniumFirst;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WindowHandle {

    WebDriver driver;

    public void launchBrowser() {
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void getUrl() {
        driver.navigate().to("https://rahulshettyacademy.com/loginpagePractise/#");
    }

    public void windowsActivities() {
        driver.manage().window().maximize();
    }

    public void example() throws InterruptedException {

        driver.findElement(By.cssSelector(".blinkingText")).click();

        // Aqui guardamos las ventanas en un string como si las guardaramos por index
        // como un array teniendolas en un orden padre siendo la 1 y child la 2 y asi
        // sucesibamente
        // sirve para cuando cambias de pagina y el driver le tienes que decir en que
        // pagina va buscar el locator
        
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        // driver.findElement(By.xpath("//a[@href =
        // 'https://rahulshettyacademy.com/#/documents-request']")).click();
        // driver.navigate().back();

        // Aqui abajo le decimos que cambie a la ventana dos de las que tienes abiertas
        // y que en esa ventana busque los locator y ya no este en la primera pagina
        driver.switchTo().window(childWindow);
        // En es css selector de abajo como tiene un espacio la palabra se le agrega un
        // punto para que funcione

        String emailAdress = driver.findElement(By.cssSelector(".im-para.red")).getText();

        System.out.print(emailAdress);
        Thread.sleep(2000);
        driver.switchTo().window(parentWindow);

        // Please email us at mentor@rahulshettyacademy.com with below template to
        // receive response

        // email us at mentor@rahulshettyacademy.com with below template to receive
        // response
        String[] emailarray = emailAdress.split(" ");
        // 0 index Please use temporary password
        // 1 index rahulshettyacademy' to Login.

        String email = emailarray[4];

        driver.findElement(By.xpath("//*[@id = 'username']")).sendKeys(email);

    }

    public static void main(String[] args) throws InterruptedException {
        WindowHandle obj = new WindowHandle();
        obj.launchBrowser();
        obj.getUrl();
        obj.windowsActivities();
        obj.example();
    }
}
