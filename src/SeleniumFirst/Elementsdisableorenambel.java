package SeleniumFirst;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Elementsdisableorenambel {
    WebDriver mydriver;

    public void launchBrowser() {
        System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
        mydriver = new EdgeDriver();

    }

    public void Geturl() {
        mydriver.get("https://rahulshettyacademy.com/dropdownsPractise/");

    }

    public void Windowactivities() {
        mydriver.manage().deleteAllCookies();
        mydriver.manage().window().maximize();
    }

    public void Example() {
        // en los mensajes de joptionpain vemos como seleccionamos la segunda fecha que
        // sale trasparente o como si estuviera disable y despues la seleccionamos
        // enable
        JOptionPane.showMessageDialog(null, mydriver.findElement(By.xpath("//*[@id='Div1']")).getAttribute("style"));

        mydriver.findElement(By.xpath("//*[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();

        JOptionPane.showMessageDialog(null, mydriver.findElement(By.xpath("//*[@id='Div1']")).getAttribute("style"));

        //Identify the method used in Selenium WebDriver to verify the presence of a web element within the web page. need an example 
    }

    public static void main(String[] args) {
        Elementsdisableorenambel objeto = new Elementsdisableorenambel();
        objeto.launchBrowser();
        objeto.Geturl();
        objeto.Windowactivities();
        objeto.Example();

    }
}
