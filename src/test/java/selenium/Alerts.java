package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");
		driver.manage().window().maximize();
		//	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='alertexamples']"))).click();

		driver.switchTo().alert().accept();
		System.out.println("accepted alert box");

		//clicking on simple alert 
		WebElement a = driver.findElement(By.xpath("//p[@class=\"inline-explanation\" and @id=\"alertexplanation\"]"));
		String TextResult = a.getText();
		if (TextResult.equals("You triggered and handled the alert dialog")) {
			System.out.println("Text is correct");
		} else {
			System.out.println("Text is incorrect");
		}

		//confirmation Alert [Scroll into view]
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement confirmBtn = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.id("confirmexample")));
		js.executeScript("arguments[0].scrollIntoView(true);", confirmBtn);
		Thread.sleep(500); // let scroll settle
		js.executeScript("arguments[0].click();", confirmBtn); // JS click for off-screen

		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		System.out.println( "Accepted confirmation alert");


		js.executeScript("arguments[0].scrollIntoView(true);", confirmBtn);
		Thread.sleep(500); // let scroll settle
		js.executeScript("arguments[0].click();", confirmBtn); // JS click for off-screen

		driver.switchTo().alert().dismiss();
		System.out.println("dismissed confrimation alert");


		WebElement promptBtn = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//button[@id='promptexample']")));
		js.executeScript("arguments[0].scrollIntoView(true);", promptBtn);
		Thread.sleep(500); // let scroll settle
		js.executeScript("arguments[0].click();", promptBtn);

		wait.until(ExpectedConditions.alertIsPresent());
		String text = driver.switchTo().alert().getText();
		System.out.println(text);
		driver.switchTo().alert().sendKeys("Entering 123");
		System.out.println("Entered text into prompt alert");
		driver.switchTo().alert().accept();
		System.out.println("Accepted prompt alert");

	}

}
