package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
	
		public static void main(String args[]) throws InterruptedException {
			
			ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.opencart.com/index.php?route=cms/demo");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	//Name locator
			/*	driver.findElement(By.name("newsletter")).sendKeys("text@gmail.com");
				
				System.out.println("Text entered"); */
				
	//TagName
				
			List<WebElement> count = driver.findElements(By.tagName("a"));
			
			System.out.println("link count = "+ count.size()); 
	
			
			// Find all the header menu items inside the <ul class="nav navbar-nav">
	        List<WebElement> menuItems = driver.findElements(By.cssSelector("ul.nav.navbar-nav > li"));

	        // Print the text of each menu item
	        for (WebElement item : menuItems) {
	            System.out.println(item.getText());
	        }
	        
	      //div[@id='cms-demo']/div/div/div[2]
	     //  driver.findElement(By.xpath("(//div[@class='demonstration-box'])[2]")).click();
	       driver.findElement(By.linkText("Features")).click();
	        System.out.println("Clicked on features"); 
	        
	      //div[@class='container']/ul[@class='nav nav-tabs']/li
	      /*  List<WebElement> Featurelinks =  driver.findElements(By.xpath("//div[@class='container']/ul[@class='nav nav-tabs']/li"));
	        System.out.println(Featurelinks.size());
	    	
	        for(WebElement links : Featurelinks)
	        {
	        	System.out.println(links.getText());
	     
	        	try
	        	{
	        	links.click();
	        	  System.out.println("Clicked on the link"); 
	        	 driver.navigate().back();
	        	  System.out.println("Navigated back"); 
	        	  Thread.sleep(1000);
	        	}
	        	catch(Exception e) {
	                System.out.println("Could not click: " + links.getText());
	        	
	        	
	        	} finally {
	        	    driver.quit(); 
	        }
	        
		//	driver.close();
	        }

}
} */
	     
	        List<WebElement> featureLinks = driver.findElements(By.xpath("//div[@class='container']/ul[@class='nav nav-tabs']/li"));
       //     System.out.println("Number of Feature Tabs: " + featureLinks.size());
            int totalLinks = featureLinks.size();
            System.out.println(totalLinks);
            /*
            // Step 3: Loop through each tab and click it
            for (int i = 0; i < featureLinks.size(); i++) {
                // Re-locate the tab list on each iteration to avoid StaleElementReferenceException
                featureLinks = driver.findElements(By.xpath("//div[@class='container']/ul[@class='nav nav-tabs']/li"));

                WebElement tab = featureLinks.get(i);
                String tabText = tab.getText();
                System.out.println("Trying to click on: " + tabText);

                try {
                    tab.click();
                    System.out.println("Clicked on: " + tabText);
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("Could not click on: " + tabText);
                
            }

         finally {
            // Close the browser after the loop is done
            driver.quit();
        }
            }
		}
}*/
	        
	    //    List<WebElement> links = driver.findElements(By.tagName("a"));
	   //     int totalLinks = links.size();

	        for (int i = 0; i < totalLinks; i++) {
	        	featureLinks = driver.findElements(By.tagName("a")); // Re-fetch links after navigation
	        	
	        	 
	            WebElement link = featureLinks.get(i);
	            String url = link.getAttribute("href");

	            if (url != null || !url.isEmpty()) {
	                driver.navigate().to(url);
	                Thread.sleep(1500);
	                System.out.println("Visited: " + url);
	                driver.navigate().back();
	                Thread.sleep(1500);
	                try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	        }
		}
}


