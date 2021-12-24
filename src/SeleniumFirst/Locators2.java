package SeleniumFirst;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Locators2 {
	WebDriver driver;

	String name = "Jonathan";
	String name2 = "Jony";
	String password1 = "rahulshettyacademy";

	public void launchbrowser() {

		System.setProperty("webdriver.edge.driver", "C:\\\\Selenium\\\\edgedriver_win32\\\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	public void getUrl() {

		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys(name);

		driver.findElement(By.xpath("//*[@type='password']")).sendKeys(password1);

		driver.findElement(By.xpath("//*[@type='submit']")).click();

	}

	public void Testing() throws InterruptedException {
		Thread.sleep(2000);
		String tag;
		tag = driver.findElement(By.tagName("p")).getText();

		System.out.println(driver.findElement(By.tagName("p")).getText());

		Assert.assertEquals(tag, "You are successfully logged in.");
		driver.findElement(By.xpath("//*[@class='logout-btn']")).click();

		/*
		 * if ("You are successfully logged in." == tag) {
		 * JOptionPane.showMessageDialog(null, "Pass test"); }
		 * 
		 * else { JOptionPane.showMessageDialog(null, "Wrong Test"); }
		 * 
		 * Thread.sleep(2000); driver.close();
		 */

	}

	public String getPassword() throws InterruptedException {
		// el xpath de abajo lo busque solo agregando el texto de del nombre del
		// boton/link, solo sirve para los botones que tienen texto o href links ejemplo
		// abajo
		driver.findElement(By.xpath("//*[text()='Forgot your password?']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

		Thread.sleep(2000);
		String passwordtext;
		passwordtext = driver.findElement(By.xpath("//*[@class='infoMsg']")).getText();
		// Please use temporary password 'rahulshettyacademy' to Login.
		String[] passwordarray = passwordtext.split("'");
		// 0 index Please use temporary password
		// 1 index rahulshettyacademy' to Login.

		String[] passwordarray2 = passwordarray[1].split("'");
		// 0 index rahulshettyacademy
		// 1 index to Login.

		String password2 = passwordarray2[0];
		return password2;
	}

	public void Loggein() {
		driver.findElement(By.xpath("//*[@class= 'go-to-login-btn']")).click();

	}

	public void singIn(String sendingpass) throws InterruptedException {

		driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys(name2);
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys(sendingpass);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@type='submit']")).click();

	}

	public void exit() throws InterruptedException {
		driver.manage().wait(1000);
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {

		Locators2 Object = new Locators2();
		Object.launchbrowser();
		Object.getUrl();
		Object.Testing();
		String password = Object.getPassword();
		Object.Loggein();
		Object.singIn(password);
		Object.exit();
	}

}
