import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class AmazonPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.className("gLFyf")).sendKeys("amazon");
		List<WebElement> search = driver.findElements(By.xpath("//div[@role='presentation']/ul/li"));
		for (int i = 0; i < search.size(); i++) {
			System.out.println(search.get(i).getText());
		}
		driver.get("https://www.amazon.in/");
		WebElement login = driver.findElement(By.xpath("//div[@class='nav-line-1-container']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(login).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='nav-al-signin'] //span[contains(text(),'Sign in')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("ap_email")).sendKeys("");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.name("password")).sendKeys("");
		driver.findElement(By.id("signInSubmit")).click();
		Thread.sleep(3000);
		WebElement combo = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		Thread.sleep(3000);
		Select sel = new Select(combo);
		Thread.sleep(3000);
		sel.selectByIndex(16);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("dell computers");
		Thread.sleep(3000);
		List<WebElement> value = driver.findElements(By.xpath("//div[@class='s-suggestion-container']/div"));
		for (int j = 0; j < value.size(); j++) {
			if (value.get(j).getText().equalsIgnoreCase("dell computers")) {
				value.get(j).click();
			}
		}
		driver.findElement(By.id("low-price")).sendKeys("30000");
		driver.findElement(By.id("high-price")).sendKeys("50000");
		Thread.sleep(3000);
		driver.findElement(By.id("a-autoid-1")).click();
		Thread.sleep(3000);
		List<WebElement> list = driver.findElements(By
				.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small'] //span[@class='a-price-whole']"));
		for (int i = 0; i < list.size(); i++) {
			String a = list.get(i).getText();
			System.out.println(a);
		}
		List<WebElement> rating = driver.findElements(By.xpath("//span[@class='a-declarative']/a //i[@class='a-icon a-icon-star-small a-star-small-4 aok-align-bottom']"));
		for(int i=0;i<rating.size();i++) {
			Thread.sleep(3000);
			ac.moveToElement(rating.get(i)).build().perform();
			Thread.sleep(3000);
			System.out.println(driver.findElement(By.xpath("//span[@data-hook='acr-average-stars-rating-text']")).getText());
		}
	}
}
