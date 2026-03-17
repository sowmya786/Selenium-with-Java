package selenium;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Authentication_popup {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://testpages.herokuapp.com/styled/auth/basic-auth-test.html");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[@href='/pages/auth/basic-auth/basic-auth-results.html']")).click();

		System.out.println("Clicked on the link");

		driver.get("https://admin:admin123@testpages.herokuapp.com/styled/auth/basic-auth-test.html");

		System.out.println("Autentication sucess");
		
		driver.quit();
	}
}