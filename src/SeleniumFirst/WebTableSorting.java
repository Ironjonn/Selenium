package SeleniumFirst;

import java.time.Duration;

import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebTableSorting extends MainJava {

    public void Table() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        List<WebElement> ls = driver.findElements(By.xpath("//tr/td[1]"));

        List<String> list = ls.stream().map(s->s.getText()).collect(Collectors.toList());



        // for (WebElement numb : ls) {
        //     System.out.println(numb.getText());
        // }


        for(int i = 0; i <ls.size(); i++){
            
            System.out.println(ls.get(i).getText());
        }

        // Click on column
        WebElement Column = driver.findElement(By.xpath("//thead/tr/th[1]"));

        Column.click();
        Thread.sleep(2000);

        // Capture all WebElements into a list
        List<WebElement> ls2 = driver.findElements(By.xpath("//tr/td[1]"));

        List<String> newlist =   ls2.stream().map(s->s.getText()).collect(Collectors.toList());

             
        
        System.out.println(newlist);

        for (int x = 0; x <newlist.size(); x++){
            System.out.println(newlist.get(x));
        }

        // for(int x = 0; x < ls2string.size(); x++){

        //     ls2string.get(i)
            
        // }

       //ls2.stream().map(s->s.getText()).forEach(s-> System.out.println(s));

       
        
        // for (WebElement numb : ls2) {
        //     System.out.println(numb.getText());
        // }

        //capture text of all webelements into new (original )list 
        Stream<String> Fulllist =  Stream.concat(list.stream(), newlist.stream());

        Fulllist.sorted().forEach(s->JOptionPane.showMessageDialog(null, s));

        

    }

    public static void main(String[] args) throws InterruptedException {
        WebTableSorting obj = new WebTableSorting();
        obj.launchBrowser();
        obj.windowsActivities();
        obj.reachUrl("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        obj.deleatecokkies();
        obj.Table();
    }
}
