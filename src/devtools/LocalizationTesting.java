package devtools;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class LocalizationTesting {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\browser\\chromedriver.exe");       
		ChromeDriver driver=new ChromeDriver();
		
	//	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		Map<String,Object> coordinates = new HashMap<String,Object>();
		coordinates.put("latitude", 35.6762); //32 139
		coordinates.put("longitude", 139.6503);
		coordinates.put("accuracy", 1);
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride",coordinates);
		
		driver.get("https://google.com/");
		
		driver.findElement(By.name("q")).sendKeys("Amazon", Keys.ENTER);
		driver.findElement(By.xpath("//h3[normalize-space()='アマゾン: Amazon | 本, ファッション, 家電から食品まで']")).click();
		

		//Thread.sleep(3000);
		driver.quit();
	}
}
