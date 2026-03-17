package selenium;


	import java.time.Duration;
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class Bootstrap {
	    public static void main(String[] args) throws InterruptedException {

	        ChromeDriver driver = new ChromeDriver();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        driver.get("https://getbootstrap.com/docs/4.0/components/dropdowns/");
	        driver.manage().window().maximize();

	        // Step 1: Find the dropdown button and click it directly
	        WebElement dropdownBtn = wait.until(
	            ExpectedConditions.elementToBeClickable(
	                By.xpath("//button[@id='dropdownMenuButton']")));

	        // ✅ Use moveToElement instead of moveByOffset
	        Actions actions = new Actions(driver);
	        actions.moveToElement(dropdownBtn).click().perform();

	        System.out.println("Clicked dropdown button");

	        // Step 2: Wait for dropdown menu to appear AFTER clicking
	        wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//div[contains(@class,'dropdown-menu') and contains(@class,'show')]")));

	        // Step 3: Now collect the options
	        List<WebElement> dropdown_options = driver.findElements(
	            By.xpath("//div[@class='dropdown-menu show']//a[@class='dropdown-item']"));

	        System.out.println("Total options found: " + dropdown_options.size());

	        // Step 4: Iterate and click the desired option
	        for (WebElement op : dropdown_options) {
	            String text = op.getText().trim();
	            System.out.println("Option: " + text);

	            if (text.equals("Action")) {
	                wait.until(ExpectedConditions.elementToBeClickable(op)).click();
	                System.out.println("Clicked on: Action");
	                break;
	            }
	            
				driver.quit();

	        }
	    }
	}


