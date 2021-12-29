package SeleniumFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DropDown {
    WebDriver driver;

    public void launchbrowsers() {
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
        driver = new EdgeDriver();

    }

    public void GettibgURl() {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

    }

    public void Windowactivities() {

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

    }

    public void TestingDropDown() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
        Thread.sleep(2000L);
        // en estos dropdowns se abre el dopdown y las mismas opciones que muestra el
        // primero las muestra el segundo por eso el xpath de abajo selecciona el
        // segundo pero es el mismo dropdow seleccionando ciudades correlo para ver
        // ejemplo
        driver.findElement(By.xpath("//a[@value='BLR']")).click();

        Thread.sleep(2000L);
        // driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

        // El siguiente locator lo encontre buscando al padre despues el hijo parent child relashimship Xpath
        // sirve mucho cuando tu jefe no quiere que utilices el index de arriba es el
        // mismo xpath del dropdown
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

    }

    public static void main(String[] args) throws InterruptedException {
        DropDown myObj = new DropDown();
        myObj.launchbrowsers();
        myObj.GettibgURl();
        myObj.Windowactivities();
        myObj.TestingDropDown();

    }
}
