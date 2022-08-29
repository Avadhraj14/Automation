package devtools;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v104.emulation.Emulation;

public class CdpCommandtools {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\browser\\chromedriver.exe");       
		ChromeDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		Map<String,Object> deviceMatrics = new HashMap<String,Object>();
		deviceMatrics.put("width", 600);
		deviceMatrics.put("height", 1000);
		deviceMatrics.put("deviceScaleFactor", 50);
		deviceMatrics.put("mobile", true);
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMatrics);
		
		driver.get("https://vepaar.com/");
		driver.findElement(By.xpath("//button[@class='button--sm button--link button--primary button--humberger ml-2']//*[name()='svg']")).click();

		driver.findElement(By.xpath("//a[@class='button button--nav'][normalize-space()='CRM']")).click();
		//Thread.sleep(3000);
		//driver.quit();
	}

}
