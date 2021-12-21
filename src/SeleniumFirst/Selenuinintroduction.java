package SeleniumFirst;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Selenuinintroduction {

	public static void main(String[] args) {
		

		System.setProperty("webdriver.edge.driver", "C:\\Selenium\\edgedriver_win32\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.amazon.com.mx/");

	}

}
