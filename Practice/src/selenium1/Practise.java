package selenium1;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.util.Strings;

public class Practise {
	private static final TimeUnit SECONDS = null;

	//static webDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		int sum=0;
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
		// System.setProperty("webdriver.gecko.driver", "c:\\geckodriver.exe");
		WebDriver driver = new ChromeDriver();
		// WebDriver driver = new FirefoxDriver();

	

		
		

		 driver.get(" https://www.spicejet.com/");
		driver.manage().window().maximize();
		 
		 
		 
		 
		 

		   System.out.println(driver.getTitle());
		   
		    System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));//

		    driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).click();//round trip click
		  
		    System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

		    if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))

		    {

		         System.out.println("its enabled");

		         Assert.assertTrue(true);

		    }

		    else

		    {

		         Assert.assertTrue(false);

		    }
		    
		 // OriginStation(Dynamic Drop down)

			    driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();

			    driver.findElement(By.cssSelector("a[value='DEL']")).click();     

			// Destination

			driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).click();

			    driver.findElement(By.xpath("(//a[@value='HYD'])[2]")).click();
			    
			    //DATE TIME PECKER
		    
			    
			    while(!driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-right']//div[@class='ui-datepicker-title']")).getText().contains("September"))
			    {
			    	//driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			    	driver.findElement(By.cssSelector("[class='ui-icon ui-icon-circle-triangle-e']")).click();
			    	//System.out.println(driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).getText());
			    	 System.out.println(driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-right']//div[@class='ui-datepicker-title']")).getText());
			    }
			    
			    List<WebElement> dates= driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td"));//all date
				   //System.out.println(((WebElement) driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td"))).getText());
				    int count= dates.size();

				    for(int i=0; i<count; i++)

				    {

				    String txt = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td")).get(i).getText();
				    

				    if(txt.equalsIgnoreCase("28"))

				    {

				    driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td")).get(i).click();

				    System.out.println(txt);

				    break;

				    }

				    }
				    Thread.sleep(3000);

				    driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date2']")).click();

				    while(!driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-right']//div[@class='ui-datepicker-title']")).getText().contains("December"))

				    {

				     driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();

				   // driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']/span[@class='ui-icon ui-icon-circle-triangle-e']")).click();

				    System.out.println(driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-right']//div[@class='ui-datepicker-title']")).getText());

				    }

				    List<WebElement> MDates= driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td"));

				    int Mcount= dates.size();

				    for(int i=0; i<Mcount; i++)

				    {

				    String txt = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td")).get(i).getText();

				    if(txt.equalsIgnoreCase("30"))

				    {

				    driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td")).get(i).click();

				    System.out.println(txt);

				    break;
		    }

		    }
		    
		 // Select Passengers

		    Thread.sleep(4000);

		        driver.findElement(By.xpath(".//*[@id='divpaxinfo']")).click();//click on passenger box

		        Thread.sleep(4000);

		        WebElement Adults = driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_Adult']"));

		        Select adultsdrp = new Select(Adults);

		        adultsdrp.selectByValue("2");

		        WebElement childs = driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_Child']"));

		        Select childsdrp = new Select(childs);

		        childsdrp.selectByValue("2");

		        driver.findElement(By.xpath(".//*[@id='divpaxinfo']")).click();//after select all items box condiotoin see

		        System.out.println(driver.findElement(By.xpath(".//*[@id='divpaxinfo']")).getText());//box condition print

		        //Static Currency Dropdown

		        WebElement Currency =  driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));//data of currency

		        Select currencydrp = new Select(Currency);

		        currencydrp.selectByValue("USD");

		    Assert.assertEquals(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")).getAttribute("value"), "USD");

		    System.out.println(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")).getAttribute("value"));

		       
           System.out.println(driver.findElements(By.id("discount-checkbox")).size());
           
           System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

           WebElement select=driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")); 
			    
           select.click();
           System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		    
           Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
           //System.out.println(((List<WebElement>) driver.findElement(By.cssSelector("input[type='checkbox']"))).size());
	
         //scroling web page
  		 JavascriptExecutor js = (JavascriptExecutor)driver;
  		 js.executeScript("scrollBy(0, 4500)");

  		
 		
 		
 		//PRINT NUMBERS OF LINK IN THE FOOTER SECTION
 				WebElement footerdriver=driver.findElement(By.id("footer"));
 				System.out.println(footerdriver.findElements(By.tagName("a")).size());
 				//PRINT THE NUMBER OF LINK FIRST COLOUMN IN THE FOOTER SECTION
 				WebElement coloumndriver=footerdriver.findElement(By.xpath("//table[@id='footerTable']/tbody/tr[2]"));// for first coloumn 
 				System.out.println(coloumndriver.findElements(By.tagName("a")).size());
 				
 				//4- click on each link in the coloumn and check if the pages are opening-
 				for(int i=1;i<coloumndriver.findElements(By.tagName("a")).size();i++)
 				{
 					
 					String clickonlinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
 					
 					coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
 					Thread.sleep(5000L);
 					
 				}// opens all the tabs
 				Set<String> abc=driver.getWindowHandles();//Set is as data type,abc =4
 				Iterator<String> it=abc.iterator();
 				
 				while(it.hasNext())//wheter next index(0,1,2) is present or not (means if windowas is present)it=0,1,2,3,4
 				{
 					
 				   driver.switchTo().window(it.next());//(it.next )it moves to zero th index
 				   
 				   System.out.println(driver.getTitle());
 				   driver.close();
 			}
 				
 				
 				
 				//PRINT ALL THE LINK NUMBERS
 				 List <WebElement> Links=driver.findElements(By.tagName("a"));
 				  
 				  System.out.println("Total links are " + Links.size());
 				  
 				  for (int i = 0; i < Links.size(); i++) {
 				   WebElement ele = Links.get(i);
 				   String url = ele.getAttribute("href");
 				   verifyLinkActive(url);
 				  }
 				 }

 				 public static void verifyLinkActive(String linkUrl) throws InterruptedException {
 				  try {
 				   URL url = new URL(linkUrl);
 				   HttpURLConnection httpURLConnect = (HttpURLConnection)url.openConnection();
 				   httpURLConnect.setConnectTimeout(3000);
 				   httpURLConnect.connect();
 				   
 				   if(httpURLConnect.getResponseCode()==200) {
 				    System.out.println(linkUrl+ " - " + httpURLConnect.getResponseMessage());
 				   }
 				   if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND) {
 				    System.out.println(linkUrl + " - "+ httpURLConnect.getResponseMessage() + " - " + HttpURLConnection.HTTP_NOT_FOUND);
 				   }
 				  } catch (IOException e) {
 				   
 				  }
 				  
 		WebDriver driver = null;
		//windoe handle
	    String parent =driver.getWindowHandle();
	    System.out.println("parent window is"+parent);
	   
	   driver.findElement(By.id("highlight-gift-card")).click();
	   driver.findElement(By.xpath("//a[contains(text(),'Cargo')]")).click();
	    
		Set<String> allwindows=driver.getWindowHandles();
		int count1=allwindows.size();
		System.out.println("Total windows"+count1);
		for(String child:allwindows) {
			
			if(!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				//driver.findElement(By.name("q")).sendKeys("selenium");
				
				System.out.println("Child window title is"+driver.getTitle());
				Thread.sleep(3000);
				driver.close();
			}
			
		}
		driver.switchTo().window(parent);
		System.out.println("parent window title is"+driver.getTitle());
 				
 				
 				
	}
}
 				
 		
		
		
		
		
 		
		    

		 
		 
		 

		
		
		
	
		
	
		 
	

	






