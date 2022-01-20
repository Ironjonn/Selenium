package SeleniumFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Homework2 {

    WebDriver driver;

    public void launchBrowser() {
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
        driver = new EdgeDriver();

    }

    public void Geturl() {
        driver.get("https://www.cleartrip.com/");
    }

    public void Windowactivities() {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    public void Example() throws InterruptedException {

        driver.findElement(By.xpath("//div[@class='flex flex-middle p-relative homeCalender']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@aria-label='Thu Jan 20 2022']")).click();

        Thread.sleep(1000);

        WebElement Adults = driver.findElement(By.xpath("(//*[@class='bc-neutral-100 bg-transparent']) [1]"));

        Select A = new Select(Adults);

        Thread.sleep(1000);

        A.selectByIndex(1);

        WebElement Childrens = driver.findElement(By.xpath("(//*[@class='bc-neutral-100 bg-transparent']) [2]"));

        Select C = new Select(Childrens);

        Thread.sleep(1000);

        C.selectByIndex(2);

        driver.findElement(By.cssSelector("a[href='javascript:void(0);']")).click();

        driver.findElement(By.xpath("//input[contains(@placeholder,'Airline name')]")).sendKeys("Air India");

        driver.findElement(By.cssSelector(
                "button[class='px-7 bg-primary-500 hover:bg-primary-600 c-white bc-transparent c-pointer w-100p py-2 px-5 h-10 fs-4 fw-600 t-all button bs-solid tp-color td-500 bw-1 br-4 lh-solid box-border']"))
                .click();

        System.out.println(
                driver.findElement(By.xpath("//span[contains(text(),'Select Departure and Arrival airports/cities.')]"))
                        .getText());

    }

    public void close() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    public static void main(String[] args) throws InterruptedException {
        Homework2 objeto = new Homework2();
        objeto.launchBrowser();
        objeto.Geturl();
        objeto.Windowactivities();
        objeto.Example();

        // objeto.close();

    }
}
