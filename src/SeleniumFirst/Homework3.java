package SeleniumFirst;


import java.util.List;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

public class Homework3 {

    static WebDriver driver;

    public void launchBrowser() {
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
        driver = new EdgeDriver();
    }

    public void getUrl() {
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
    }

    public void windowsActivities() {
        driver.manage().window().maximize();
    }

    public String extractingusername() {
        String extractingusername;
        extractingusername = driver.findElement(By.xpath("//div[@class='form-group']//i[text()]")).getText();

        // driver.switchTo().alert().accept();
        return extractingusername;
    }

    public String extractingpassword() {
        String extractingpassword;
        extractingpassword = driver.findElement(By.xpath("//p[@class='text-center text-white']/b[2]")).getText();

        return extractingpassword;
    }

    public void sendingusername(String sendingsername) {

        driver.findElement(By.cssSelector("input[id = 'username']")).sendKeys(sendingsername);
    }

    public void sendingpassword(String sendingpassword) {
        driver.findElement(By.xpath("//input[@id= 'password']")).sendKeys(sendingpassword);
    }

    public void selectinguser(WebDriverWait obj) {

        driver.findElement(By.xpath("//div[@class ='form-check-inline']/label[2]/span[1]")).click();

        obj.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[id='okayBtn']"))).click();

    }

    public void selectingdropdown() {
        WebElement staticdropdow = driver.findElement(By.cssSelector("select[class ='form-control']"));
        Select dropdown = new Select(staticdropdow);

        dropdown.selectByIndex(2);

    }

    public void agreeterms() {
        driver.findElement(By.cssSelector("input[id='terms']")).click();
        driver.findElement(By.xpath("//*[@id='signInBtn']")).click();
    }

    public void addingitemstocart(WebDriverWait obj) {

        obj.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class= 'btn btn-info']")));

        List<WebElement> lista = driver.findElements(By.xpath("//button[@class= 'btn btn-info']"));

        for (int i = 0; i < lista.size(); i++) {

            lista.get(i).click();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Homework3 objx = new Homework3();
        objx.launchBrowser();
        objx.getUrl();
        objx.windowsActivities();

        String gettingusername = objx.extractingusername();
        objx.sendingusername(gettingusername);

        String gettingpassword = objx.extractingpassword();
        objx.sendingpassword(gettingpassword);
        WebDriverWait obj;
        obj = new WebDriverWait(driver, 5);
        objx.selectinguser(obj);
        objx.selectingdropdown();
        objx.agreeterms();

        objx.addingitemstocart(obj);
    }
}
