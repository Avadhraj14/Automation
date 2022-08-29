package devtools;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;


public class JavascriptLog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\browser\\chromedriver.exe");       
		ChromeDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://vepaar.com/test-8yeev");
		
		driver.findElement(By.xpath("(//span[@class='button__label'][normalize-space()='Add To Cart'])[1]")).click();
		driver.findElement(By.xpath("(//*[name()='svg'][@class='w-full h-full'])[13]")).click();
		
		LogEntries entry= driver.manage().logs().get(LogType.BROWSER); //Get LogEntries object
		 List<LogEntry>logs = entry.getAll();  //LogEntryobject- getAll method return all logs in list
		 
		 for(LogEntry e : logs)//iterating through list and printing each log message
		 {
			 System.out.println(e.getMessage());  //Log4j
			
		 }


	}

}
