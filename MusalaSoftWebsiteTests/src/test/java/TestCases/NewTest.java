package TestCases;

import org.testng.annotations.Test;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class NewTest {
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
	public void PrimeraPrueba() throws InterruptedException {
		System.out.println("primera prueba");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(5000);
		js.executeScript("window.scroll(0,1000)");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@type='button']/span[text()='Contact us']")).click();
		driver.findElement(By.id("cf-1")).sendKeys("Ailyn");
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("55431068");
		driver.findElement(By.cssSelector("input[name='your-subject']")).sendKeys("First test");
		driver.findElement(By.cssSelector("textarea[name='your-message']")).sendKeys("This is the message of the first test");
		File file=new File("C:\\Users\\Geider\\git\\repository\\MusalaSoftWebsiteTests\\src\\test\\java\\TestCases\\invalidaddresses.txt");
		String path=file.getAbsolutePath();
		driver.get(path);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("test@test");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String errorMessage=driver.findElement(By.xpath("//span[@class='wpcf7-not-valid-tip']")).getText();
		Assert.assertTrue(errorMessage.equals("The e-mail address entered is invalid."), "The error message displayed is not as expected.");
	}

	@Test
	public void SegundaPrueba() {
		System.out.println("segunda prueba>>>>>>>>>");
	}

}
