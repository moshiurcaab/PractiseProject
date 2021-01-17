package selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class prastice2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
		// System.setProperty("webdriver.gecko.driver", "c:\\geckodriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
				 int a = driver.findElements(By.xpath("//input[@name='radioButton' and @type='radio']")).size();
				System.out.println(a);
				 for(int i=1;i<=a;i++)

				 {

				 driver.findElements(By.xpath("//input[@name='radioButton']")).get(0).click();
				 }
				 driver.findElement(By.id("autocomplete")).sendKeys("Bangladesh");

				// bootstrap dropdowan
				Select dropdown = new
				 Select(driver.findElement(By.id("dropdown-class-example")));
				 dropdown.selectByVisibleText("Option1");
				// or
				// driver.findElement(By.xpath("//option[@value='option1']")).click();

				// checkbox select
				 WebElement select =driver.findElement(By.id("checkBoxOption1"));
				 select.click();
				 System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
				 
				 
				//IMPLICIT WAIT
					//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					
					

					/*WebDriverWait w =new WebDriverWait(driver,5);



					String[] itemsNeeded= {"Cucumber","Brocolli","Beetroot"};





					driver.get("https://rahulshettyacademy.com/seleniumPractise/");

					Thread.sleep(3000);

					addItems(driver,itemsNeeded);

					driver.findElement(By.cssSelector("img[alt='Cart']")).click();

					driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

					w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));



					driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
					
					driver.findElement(By.cssSelector("button.promoBtn")).click();

					//explicit wait



					w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

					System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());











					}

					public static  void addItems(WebDriver driver,String[] itemsNeeded)

					{

					int j=0;
					String[] itemsNeeded1= {"Cucumber","Brocolli","Beetroot"};
					//driver.get("https://rahulshettyacademy.com/seleniumPractise");
					List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
					
					for(int i=0;i<products.size();i++) {
						String[] name=products.get(i).getText().split("-");
						String formatedName=name[0].trim();
						//convert arry into array list
						List itemsNeededList=Arrays.asList(itemsNeeded1);
						if(itemsNeededList.contains(formatedName))
						{
							j++;
							driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
						if(j==itemsNeeded1.length) {
							break;
						}
					}
					

					}*/
					
					
					//FLUENT WAIT
					
					/*driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
					driver.findElement(By.cssSelector("[id='start'] button")).click();
					Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, SECONDS)
						       .pollingEvery(3, SECONDS)
						       .ignoring(NoSuchElementException.class);
					 WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
					     public WebElement apply(WebDriver driver) {
					    	 if(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed()) {
					    		 return driver.findElement(By.cssSelector("[id='finish'] h4"));
					    	 }
					    	 else
					    		 return null;
					       
					     }
					   });

					System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).getText());*/
					
					/*driver.get("https://www.amazon.com/");
					//MOUSE HOWOVER
					Actions a=new Actions(driver);
					a.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).build().perform();
					//or
					WebElement move=driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
					
					//CAPITAL LETER CONVERT IN A SEARCH BOX
					a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
					//GET INSPECT SELECTION
					a.moveToElement(move).contextClick().build().perform();*/
					
					//MULTIPLE WINDOWS HANDLE
					
					/*driver.get("http://seleniumpractise.blogspot.com/2017/");
				    String parent =driver.getWindowHandle();
				    System.out.println("parent window is"+parent);
				    driver.findElement(By.name("link1")).click();
					Set<String> allwindows=driver.getWindowHandles();
					int count=allwindows.size();
					System.out.println("Total windows"+count);
					for(String child:allwindows) {
						
						if(!parent.equalsIgnoreCase(child)) {
							driver.switchTo().window(child);
							driver.findElement(By.name("q")).sendKeys("selenium");
							
							System.out.println("Child window title is"+driver.getTitle());
							Thread.sleep(3000);
							driver.close();
						}
						
					}
					driver.switchTo().window(parent);
					System.out.println("parent window title is"+driver.getTitle());*/
					
					
					/*driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
					
					//PRINT ALL THE LINK NUMBERS
					System.out.println(driver.findElements(By.tagName("a")).size());//number of links is 27  
					//PRINT NUMBERS OF LINK IN THE FOOTER SECTION
					WebElement footerdriver=driver.findElement(By.id("gf-BIG"));
					System.out.println(footerdriver.findElements(By.tagName("a")).size());//number of links in footer section is 20
					//PRINT THE NUMBER OF LINK FIRST COLOUMN IN THE FOOTER SECTION
					WebElement coloumndriver=footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));//all element in first coloumn
					System.out.println(coloumndriver.findElements(By.tagName("a")).size());// numbers is 5
					
					//4- click on each link in the coloumn and check if the pages are opening-
					for(int i=1;i<coloumndriver.findElements(By.tagName("a")).size();i++)
					{
						
						String clickonlinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
						
						coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
						Thread.sleep(5000L);
						
					}// opens all the tabs
					/*Set<String> abc=driver.getWindowHandles();//Set is as data type,abc =4
					Iterator<String> it=abc.iterator();
					
					while(it.hasNext())//wheter next index(0,1,2) is present or not (means if windowas is present)it=0,1,2,3,4
					{
						
					   driver.switchTo().window(it.next());//(it.next )it moves to zero th index
					   
					   System.out.println(driver.getTitle());
				}

					
					/*driver.get("http://www.cricbuzz.com/live-cricket-scorecard/18970/pak-vs-sl-2nd-t20i-pakistan-v-sri-lanka-in-uae-2017");

					WebElement table=driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
					int rowcount= table.findElements(By.cssSelector("cb-col cb-col-100 cb-scrd-itms")).size();
					int count=table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();

					
					/*for(int i=0;i<count-2;i++)
					{
				    System.out.println(table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText());	
					
					}
					System.out.println(driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText());
					
					System.out.println(driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText());*/
					
					
					//OR
					
					/*for(int i=0;i<count-2;i++)
					{
				    System.out.println(table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText());//extra runs	
					String value=table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
					int valueinteger=  Integer.parseInt(value);
					sum=sum+valueinteger;//103
					}
					//System.out.println(sum);

					String Extras=driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
					int extrasValue=Integer.parseInt(Extras);
					int TotalSumValue=sum+extrasValue;
					System.out.println(TotalSumValue);//total runs

					
					String ActualTotal=driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
					int ActualTotalVAlue=Integer.parseInt(ActualTotal);
					if(ActualTotalVAlue==TotalSumValue)
					{
					System.out.println("Count Matches");
					}
					else
					{
					System.out.println("count fails");
					}*/
					
					
					/*
					driver.get("https://www.ksrtc.in");
					driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys("BENG");
					Thread.sleep(2000);

					driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);

					System.out.println(driver.findElement(By.xpath("//input[@id='fromPlaceName']")).getText());

					//Javascript DOM can extract hidden elements
					//because selenium cannot identify hidden elements - (Ajax implementation)
					//investigate the properties of object if it have any hidden text

					//JavascriptExecutor
					JavascriptExecutor js= (JavascriptExecutor)driver;

					String script = "return document.getElementById(\"fromPlaceName\").value;";
					String text=(String) js.executeScript(script);
					System.out.println(text);
					int i =0;
					//BENGALURU INTERNATION AIPORT
					while(!text.equalsIgnoreCase("BENGALURU INTATION AIPORT"))
					{
					i++;
					driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);

					text=(String) js.executeScript(script);
					System.out.println(text);
					if(i>10)
					{
					break;
					}

					}

					if(i>10)
					{
					System.out.println("Element not found");
					}
					else
					{
					System.out.println("Element  found");*/
					}
			
				 

		

	}


