package TestCases;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestCase2 {
	protected WebDriver driver;
	
	@BeforeClass
	@Parameters({ "URL", "BrowserType" })
	public void beforeClass(String url, String BrowserType) throws Exception {
		switch (BrowserType) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "Firefox":
			System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		default:
			throw new Exception("Navegador" + BrowserType + " no soportado");
		}
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Test
	public void company() throws InterruptedException {
		driver.findElement(By.xpath("//div[@id='menu']/ul[@id='menu-main-nav-1']/li[1]/a")).click();
		System.out.println(driver.getCurrentUrl());		
	}

}
