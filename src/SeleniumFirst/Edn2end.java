package SeleniumFirst;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Edn2end {
    WebDriver driver;

    public void launchBrowser() {
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
        driver = new EdgeDriver();
    }

    public void Windowactivities() {
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

    }

    public void Geturl() {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    public void SelectiingAllLocators() throws InterruptedException {
        driver.findElement(By.cssSelector("input[id='autosuggest']")).sendKeys("ind");
        Thread.sleep(2000);

        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

        for (WebElement option : options) {

            if (option.getText().equalsIgnoreCase("india")) {
                option.click();
                break;
            }

        }

        

        driver.findElement(By.xpath("//*[contains(@value,'RoundT')]")).click();
        driver.findElement(By.xpath("//*[@id='ctl00_mainContent_chk_StudentDiscount']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.cssSelector("a[value='DEL']")).click();
        Thread.sleep(2000);
        // locator de abajo seleccionando la segunda opcion
        driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).click();
        // o puede ser de padre a hijo como se muestra en el de abajo
        // driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']
        // //a[@value='MAA']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".ui-state-highlight")).click();
        // calendario diferente forma de seleccionar el locator el dia que quieres 3
        // formas diferentes
        // driver.findElement(By.xpath("//*[contains(@class,'ui-state-highlight')]")).click();
        // driver.findElement(By.xpath("//*[text()='14']")).click();

        driver.findElement(By.xpath("//*[@id='ctl00_mainContent_view_date2']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='29']")).click();

        driver.findElement(By.xpath("//*[@id='divpaxinfo']")).click();
        Thread.sleep(2000);
        int i = 1;

        while (i < 5) {

            driver.findElement(By.xpath("//*[@id='hrefIncAdt']")).click();
            Thread.sleep(1000);
            i++;
        }

        driver.findElement(By.cssSelector("input[value='Done']")).click();
        Thread.sleep(2000);

        WebElement staticDropdown = driver.findElement(By.xpath("//*[@id = 'ctl00_mainContent_DropDownListCurrency']"));
        Select dropdown = new Select(staticDropdown);

        dropdown.selectByIndex(3);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id='ctl00_mainContent_btn_FindFlights']")).click();
    }

    public void closing() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    public static void main(String[] args) throws InterruptedException {
        Edn2end objeto = new Edn2end();
        objeto.launchBrowser();
        objeto.Geturl();
        objeto.Windowactivities();
        objeto.SelectiingAllLocators();
        //objeto.closing();
    }

}
