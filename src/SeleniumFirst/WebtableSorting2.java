package SeleniumFirst;

import java.util.List;
import javax.swing.JOptionPane;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebtableSorting2 extends MainJava {
    
    public void table() throws InterruptedException{

        String fruta = JOptionPane.showInputDialog(null, "Please insert the fruit you want to chose ");

        int next = 0;
       List<WebElement> tabla =  driver.findElements(By.xpath("//tbody/tr/td[1]"));

       
        tabla =   driver.findElements(By.xpath("//tr//td[1]"));
        do {
            driver.findElement(By.xpath("//ul/li/a[@aria-label = 'Next']")).click();
            Thread.sleep(2000);
            tabla =   driver.findElements(By.xpath("//tr//td[1]"));
        }
        
        while(tabla.contains(fruta));
        
    
    

    
        //this one is wornin just need to simplify 
    // for(int i = 0; i<tabla.size(); i ++){
    //     tabla =  driver.findElements(By.xpath("//tbody/tr/td[1]"));
    //     WebElement o = tabla.get(i);       
            

    //    while(next< 3){
    //        next++;
    //     driver.findElement(By.xpath("//ul/li/a[@aria-label = 'Next']")).click();
    //     Thread.sleep(2000);
    //     tabla =  driver.findElements(By.xpath("//tbody/tr/td[1]"));
    //    }  

    //    if(tabla.get(i).getText().contains(fruta)){
    //     tabla =  driver.findElements(By.xpath("//tbody/tr/td[1]"));
    //     JOptionPane.showMessageDialog(null, "The price of " + fruta + " is " + o.findElement(By.xpath("following-sibling::td[1]")).getText()); 
    //    }
        
        
    //     }

        

       
    }



    public static void main(String[] args) throws InterruptedException {
        WebtableSorting2 objeto = new  WebtableSorting2(); 
        objeto.launchBrowser();
        objeto.windowsActivities();
        objeto.reachUrl("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        objeto.deleatecokkies();
        objeto.table();

        
    }
}
