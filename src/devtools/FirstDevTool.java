package devtools;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v104.emulation.Emulation;

public class FirstDevTool {
	
	public static void main(String args[]) throws InterruptedException
	{
	
	System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\browser\\chromedriver.exe");       
	ChromeDriver driver=new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	
	driver.manage().window().maximize();
	DevTools devTools = driver.getDevTools();
	devTools.createSession();
	devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
	driver.get("https://vepaar.com/");
	driver.findElement(By.xpath("//button[@class='button--sm button--link button--primary button--humberger ml-2']//*[name()='svg']")).click();

	driver.findElement(By.xpath("//a[@class='button button--nav'][normalize-space()='CRM']")).click();
	Thread.sleep(3000);
	driver.quit();
	}
}
