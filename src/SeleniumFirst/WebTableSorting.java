package SeleniumFirst;

import java.time.Duration;

import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class WebTableSorting extends MainJava {

    public void Table() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        List<WebElement> ls = driver.findElements(By.xpath("//tr/td[1]"));

        List<String> list = ls.stream().map(s -> s.getText()).collect(Collectors.toList());

        // for (WebElement numb : ls) {
        // System.out.println(numb.getText());
        // }

        for (int i = 0; i < ls.size(); i++) {

            System.out.println(ls.get(i).getText());
        }

        // Click on column
        WebElement Column = driver.findElement(By.xpath("//thead/tr/th[1]"));

        Column.click();
        Thread.sleep(2000);

        // Capture all WebElements into a list
        List<WebElement> ls2 = driver.findElements(By.xpath("//tr/td[1]"));

        List<String> newlist = ls2.stream().map(s -> s.getText()).collect(Collectors.toList());

        System.out.println(newlist);

        for (int x = 0; x < newlist.size(); x++) {
            System.out.println(newlist.get(x));
        }

        // for(int x = 0; x < ls2string.size(); x++){

        // ls2string.get(i)

        // }

        // ls2.stream().map(s->s.getText()).forEach(s-> System.out.println(s));

        // for (WebElement numb : ls2) {
        // System.out.println(numb.getText());
        // }

        // capture text of all webelements into new (original )list

        Thread.sleep(2000);
        Stream<String> Fulllist = Stream.concat(list.stream(), newlist.stream());

        Fulllist.sorted().forEach(s -> JOptionPane.showMessageDialog(null, s));

        // scan the name column and get text -> get Rice and then print price of that
        // one

        Thread.sleep(3000);

        WebElement dropdowns = driver.findElement(By.xpath("//select[@id = 'page-menu']"));

        Select dropdowntable = new Select(dropdowns);

        dropdowntable.selectByVisibleText("20");

        Thread.sleep(2000);

        List<WebElement> newlist2 = driver.findElements(By.xpath("//tbody/tr/td[1]"));

        for (WebElement riceElement : newlist2) {
            String rice = "Rice";

            if (riceElement.getText().equalsIgnoreCase(rice)) {

                String ricePrice = driver.findElement(By.xpath("//tr[4]//td[2]")).getText();

                System.out.println("The price of " + rice + " Is " + ricePrice);
            }
        }

        Boolean con = newlist2.stream().anyMatch(s -> s.getText().equalsIgnoreCase("Rice"));

        Assert.assertTrue(con);

    }

    public void whileloop(){
        driver.navigate().refresh();

        List<String> price;
        

        do{
            List<WebElement> List = driver.findElements(By.xpath("//tbody/tr/td[1]"));
            price = List.stream().filter(s->s.getText().contains("Mango")).map(s->getPrivatePrice(s)).collect(Collectors.toList());

            price.forEach(a->JOptionPane.showMessageDialog(null, a));

            if(price.size()<1){

                driver.findElement(By.xpath("//a[@aria-label='Next']")).click();

            }
        }while(price.size()<1);


    }

    private static String getPrivatePrice(WebElement s) {

        String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return pricevalue;
    }

    public static void main(String[] args) throws InterruptedException {
        WebTableSorting obj = new WebTableSorting();
        obj.launchBrowser();
        obj.windowsActivities();
        obj.reachUrl("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        obj.deleatecokkies();
        obj.Table();
        obj.whileloop();
    }
}
