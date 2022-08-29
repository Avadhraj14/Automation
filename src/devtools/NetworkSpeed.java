package devtools;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v104.network.Network;
import org.openqa.selenium.devtools.v104.network.model.ConnectionType;
public class NetworkSpeed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\browser\\chromedriver.exe");       
		ChromeDriver driver=new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		//Network.emulateNetworkConditions
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		//diff. network to check the website loading :: change false to true
		devTools.send(Network.emulateNetworkConditions(false, 3000, 20000, 100000, Optional.of(ConnectionType.CELLULAR2G)));
		
		//internet off and check
		
		devTools.addListener(Network.loadingFailed(), loadingFailed->
		{
			System.out.println(loadingFailed.getErrorText());
			System.out.println(loadingFailed.getTimestamp());
			
			
		});
		
		
		long startTime = System.currentTimeMillis();
		driver.get("https://vepaar.com/");
		driver.findElement(By.xpath("//a[normalize-space()='Pricing']")).click();
		System.out.println(driver.getTitle());

		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		driver.close();
		
	}

	}


