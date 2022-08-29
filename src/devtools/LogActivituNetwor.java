package devtools;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v104.network.Network;
import org.openqa.selenium.devtools.v104.network.model.Request;
import org.openqa.selenium.devtools.v104.network.model.Response;

public class LogActivituNetwor {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\browser\\chromedriver.exe");       
		ChromeDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
	
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
	
		
		devTools.addListener(Network.requestWillBeSent(), request ->
		
				{
					Request req = request.getRequest();
					//System.out.println(req.getUrl());
				//System.out.println(req.getHeaders());
			
				});
	
		//Event will get fired-
		devTools.addListener(Network.responseReceived(), response ->
		
		{
			Response res = response.getResponse();
	//		System.out.println(res.getUrl() +" || "+res.getStatus()+ "||" + res.getResponseTime());
		
		//	System.out.println(res.getStatus());
			if(res.getStatus().toString().startsWith("4"))
			{
				System.out.println(res.getUrl()+"is failing with status code "+res.getStatus());
			}
			
			
			
		});
		

		
		driver.get("https://web.vepaar.com/?utm_campaign=header_cta&utm_medium=all&utm_source=vepaar_website#/login");
		
		driver.findElement(By.cssSelector("input[type='text']")).sendKeys("avadhraj@7span.com");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("a");
		driver.findElement(By.cssSelector("button[type='submit'] span[class='button__label']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[normalize-space()='Store']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[normalize-space()='Badges']")).click();
		driver.findElement(By.xpath("//th[@class='v-list-table__string v-list-table__name v-list-table__sortable']//div[@class='v-list-table__head']//*[name()='svg']")).click();
	//	driver.findElement(By.xpath("//a[normalize-space()='Pricing']")).click();
		
		//driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		
		
			driver.quit();	
		
	}
}

