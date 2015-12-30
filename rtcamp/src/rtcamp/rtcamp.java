package rtcamp;
	
	import java.io.IOException;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.Select;

	public class rtcamp{
		public static void main(String args []) throws IOException, InterruptedException
		{
			WebDriver driver=new FirefoxDriver();
			String a ="Howdy, demo";
			driver.get("http://demo.rtcamp.com/rtmedia/");
			
			//login with valid credentials
			driver.manage().window().maximize();
			driver.findElement(By.xpath(".//*[@id='bp-login-widget-user-login']")).sendKeys("demo");
			driver.findElement(By.xpath(".//*[@id='bp-login-widget-user-pass']")).sendKeys("demo");
			driver.findElement(By.xpath(".//*[@id='bp-login-widget-submit']")).click();
			String b=driver.findElement(By.xpath(".//*[@id='wp-admin-bar-my-account']/a")).getText();
			if(b.equals(a));
			{
				System.out.println("Hello");
			}
			//login with invalid credentials
			driver.findElement(By.cssSelector(".logout")).click();
			driver.findElement(By.xpath(".//*[@id='bp-login-widget-user-login']")).sendKeys("andro");
			driver.findElement(By.xpath(".//*[@id='bp-login-widget-user-pass']")).sendKeys("ios");
			driver.findElement(By.cssSelector("#bp-login-widget-submit")).click();
			String x=driver.getTitle();
			String z="http://demo.rtcamp.com/rtmedia/wp-login.php";
			if(x.equals(z))
			{
				System.out.println("Username Password Mismatch");
			}
			
			//redirecting login with valid credentials
			driver.findElement(By.cssSelector("#user_login")).clear();
			Thread.sleep(5000);
			driver.findElement(By.cssSelector("#user_login")).sendKeys("demo");
			Thread.sleep(5000);
			driver.findElement(By.cssSelector("#user_pass")).sendKeys("demo");
			driver.findElement(By.cssSelector("#wp-submit")).click();
			System.out.println("ok");
			
			//posting a message
			driver.findElement(By.xpath(".//*[@id='whats-new']")).click();
			driver.findElement(By.cssSelector("#whats-new")).sendKeys("hello");
			
			//uploading image with AutoIT
			Thread.sleep(5000);
			WebElement e = driver.findElement(By.xpath(".//*[@id='rtmedia-add-media-button-post-update']"));
	        e.click();
	        Runtime.getRuntime().exec("F:/image.exe");
	        Thread.sleep(5000);
	       
	        //Changing privacy settings in the dropdown
	        WebElement element=driver.findElement(By.id("rtSelectPrivacy"));
			Select se=new Select(element);
			se.selectByVisibleText("Logged in Users");
			Thread.sleep(5000);
			
			//saving the changes
			driver.findElement(By.xpath(".//*[@id='whats-new']")).click();
			driver.findElement(By.cssSelector("#aw-whats-new-submit")).click();
			Thread.sleep(15000);
			
			//editing profile name
			driver.findElement(By.xpath(".//*[@id='wp-admin-bar-my-account']/a")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath(".//*[@id='field_1']")).clear();
			driver.findElement(By.xpath(".//*[@id='field_1']")).sendKeys("test");
			driver.findElement(By.xpath(".//*[@id='profile-group-edit-submit']")).click();
			
			
			
		}
	
	}
