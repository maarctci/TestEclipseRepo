package Practice1;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AllBasicSeleniumTask 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\jdk-17.0.2\\bin\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//Opening URL
		driver.get("https://seleniumbase.io/demo_page");
		
		//Reading Page Name and URL
		System.out.println("\nTesting Page Name : " + driver.getTitle());
		System.out.println("Current Web Page URL : " + driver.getCurrentUrl());
		Thread.sleep(3000);
		
		//Move backward to the page and reading Page Name and URL
		driver.navigate().back();
		System.out.println("\nBack Page Title : " + driver.getTitle() + "\nBack Page URL : " + driver.getCurrentUrl());
		Thread.sleep(3000);
		
		//Move forward to the Page 
		driver.navigate().forward();
		Thread.sleep(3000);
		
		//Locating elements by ID, NAME, CLASSNAME and XPATH
		WebElement element1 = driver.findElement(By.id("myTextInput"));
		System.out.println(element1);
		
		WebElement element2 = driver.findElement(By.name("preText2"));
		System.out.println(element2);
		
		//WebElement element3 = driver.findElement(By.className("textareaClass area1"));
		//System.out.println(element3);
		
		WebElement element4 = driver.findElement(By.xpath("//*[@id=\"placeholderText\"]"));
		System.out.println(element4);
		
		//Read value from input field
		Thread.sleep(3000);
		String value1 = element4.getAttribute("value");
		System.out.println("\nReaded Value from input field : " + value1);
		
		//Clear value from input field
		element4.clear();
		System.out.println("Input field cleared...");
		
		//Conditional Commands
		System.out.println("\nelement4 is displayed : " + element4.isDisplayed());
		System.out.println("element4 is enabled : " + element4.isEnabled());
		
		WebElement element5 = driver.findElement(By.id("checkBox1"));
		System.out.println("Element is selected : " + element5.isSelected());
		element5.click();
		System.out.println("Element is selected : " + element5.isSelected());
		Thread.sleep(3000);
		
		//Drag and Drop Controls
		WebElement drag = driver.findElement(By.id("drop1"));
		WebElement drop = driver.findElement(By.id("drop2"));
		Actions action = new Actions(driver);
		action.dragAndDrop(drag, drop).perform();
		Thread.sleep(3000);
		
		//Drop_Down Control
		Select s = new Select(driver.findElement(By.id("mySelect")));
		System.out.println(s.getFirstSelectedOption().getAccessibleName());
		System.out.println(s.getFirstSelectedOption().getAttribute("value"));
		Thread.sleep(3000);
		s.selectByValue("100%");
		System.out.println(s.getFirstSelectedOption().getAttribute("value"));
		System.out.println(s.getFirstSelectedOption().getDomAttribute("value"));
		Thread.sleep(3000);
		s.selectByIndex(2);
		System.out.println(s.getFirstSelectedOption().getText());
		System.out.println(s.getFirstSelectedOption().getTagName());
		Thread.sleep(3000);
		//s.selectByVisibleText("set to 25%");
		
		//Link Controls (Tag Name, linkText, partiallinkText)
		WebElement link1 = driver.findElement(By.tagName("a"));
		System.out.println(link1);
		WebElement element = driver.findElement(By.linkText("seleniumbase.com"));
		element.click();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		WebElement elements = driver.findElement(By.partialLinkText("selenium"));
		elements.click();
		Thread.sleep(3000);
		driver.navigate().back();
		
		//Closing current window
		Thread.sleep(3000);
		driver.close();
		
		//----------------------------------------------------------------------
		//Alert Controls
		ChromeDriver driver1 = new ChromeDriver();
		driver1.get("https://the-internet.herokuapp.com/");
		driver1.manage().window().maximize();

		Thread.sleep(2000);

		WebElement alert = driver1.findElement(By.linkText("JavaScript Alerts"));
		alert.click();

		Thread.sleep(2000);
		WebElement alert1 = driver1.findElement(By.xpath("/html/body/div[2]/div/div/ul/li[1]/button"));
		alert1.click();
		Thread.sleep(2000);
		driver1.switchTo().alert().accept();
		Thread.sleep(2000);

		WebElement alert2 = driver1.findElement(By.xpath("/html/body/div[2]/div/div/ul/li[2]/button"));
		alert2.click();
		Thread.sleep(2000);
		driver1.switchTo().alert().accept();
		Thread.sleep(2000);
		WebElement alert3 = driver1.findElement(By.xpath("/html/body/div[2]/div/div/ul/li[3]/button"));
		alert3.click();
		Thread.sleep(2000);
		driver1.switchTo().alert().sendKeys("Hello World");
		Thread.sleep(2000);
		driver1.switchTo().alert().accept();
		Thread.sleep(2000);
		driver1.close();
		
		//----------------------------------------------------------------------
		//Frame Controls
		ChromeDriver driver2 = new ChromeDriver();
		driver2.get("https://w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		Thread.sleep(3000);
		driver2.switchTo().frame("iframeresult");
		Thread.sleep(3000);
		WebElement elementsJSButton = driver2.findElement(By.xpath("/html/body/button"));
		Thread.sleep(3000);
		elementsJSButton.click();
		Thread.sleep(3000);
		driver2.switchTo().alert().accept();
		driver2.close();
		
		//----------------------------------------------------------------------
		//Window Handles
		ChromeDriver driver3 = new ChromeDriver();
		driver3.get("https://the-internet.herokuapp.com/windows");
		Thread.sleep(3000);
		System.out.println(driver3.getTitle());
		driver3.findElement(By.id("//*[@id='content']/div/a")).click();
		Thread.sleep(5000);

		Set<String> windowhandles = driver3.getWindowHandles();
		System.out.println(windowhandles);
		Thread.sleep(3000);
		Iterator<String> iterator = windowhandles.iterator();
		String handles1 = iterator.next();
		System.out.println(handles1);
		String handles2 = iterator.next();
		Thread.sleep(3000);
		WebElement textElement = driver3.findElement(By.xpath("/html/body/div/h3"));
		System.out.println(textElement.getText());
		System.out.println(handles2);
		
		driver3.close();
		Thread.sleep(3000);
		driver3.quit();
		
		
		//----------------------------------------------------------------------
		//Scrolling Page
		ChromeDriver driver4 = new ChromeDriver();
		driver4.get("https://en.wikipedia.org/wiki/Python_(programming_language)");
		Thread.sleep(3000);

		driver4.executeScript("window.scrollBy(0,3000)" + "");
		Thread.sleep(3000);

		WebElement ele = driver4.findElement(By.id("Programming_examples"));
		driver4.executeScript("arguments[0].scrollIntoView()" + ele);

		Thread.sleep(3000);
		driver4.executeScript("window.scrollBy(0, document.body.scrollHeight)");

		Thread.sleep(3000);
		driver4.executeScript("window.scrollTo(0, 0)" + "");

		Thread.sleep(3000);
		driver4.close();
		
		//----------------------------------------------------------------------
		//Mouse Actions
		ChromeDriver driver5 = new ChromeDriver();
		driver5.get("https://seleniumbase.io/demo_page");
		Thread.sleep(3000);

		Actions action1 = new Actions(driver5);
		WebElement ele1 = driver5.findElement(By.id("myDropdown"));
		WebElement elementOption1  = driver5.findElement(By.id("dropOption1"));
		WebElement elementOption2  = driver5.findElement(By.id("dropOption2"));
		WebElement elementOption3  = driver5.findElement(By.id("dropOption3"));
		Thread.sleep(3000);

		action1.moveToElement(ele1).moveToElement(elementOption1).click().perform();
		Thread.sleep(3000);

		action1.moveToElement(ele1).moveToElement(elementOption2).click().perform();
		Thread.sleep(2000);

		action1.moveToElement(ele1).moveToElement(elementOption3).click().perform();
		Thread.sleep(2000);

		action1.doubleClick(driver5.findElement(By.id("myButton"))).perform();
		Thread.sleep(2000);

		WebElement eleButton = driver5.findElement(By.id("myButton"));
		action1.doubleClick(eleButton).perform();
		Thread.sleep(2000);

		action1.contextClick().perform();

		Thread.sleep(3000);
		driver5.close();
		
		//----------------------------------------------------------------------
		//Drag and drop Controls
		ChromeDriver driver6 = new ChromeDriver();
		driver6.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver6.manage().window().maximize();
		Thread.sleep(2000);
		String source = "box";
		String target = "box10";
		for (int i = 1; i <= 9 ; i++)
		{
		    WebElement drag1 = driver6.findElement(By.id(source + i));
		    WebElement drop1 = driver6.findElement(By.id(target + i));
	
		    Actions act = new Actions(driver6);
		    act.dragAndDrop(drag1, drop1).perform();
		    Thread.sleep(1000);
		}
		System.out.println("Hello");
		driver6.close();
		//Hello World
	}
}
