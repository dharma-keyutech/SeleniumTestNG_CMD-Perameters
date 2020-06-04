package Smoke_Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Base.Basetest;
import Base.all_xpaths;



public class home_page_with_all_links  extends Basetest implements all_xpaths{
	private static final Logger logger = LogManager.getLogger(home_page_with_all_links.class);
	public static String BrowserName=System.getProperty("Browsername");


	@Test(groups={"Smoke"})
	public static void CLickLinks() throws IOException, InterruptedException{
	
	// To read The Property File 
		Properties prop=new Properties();
		/*FileInputStream ip= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\data.properties");*/
		FileInputStream ip= new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/data.properties");
		prop.load(ip);
	
      launchBrowser(BrowserName);	 
	sendURL(prop.getProperty("BaseUrl"));
   

	//Get list of web-elements with tagName  - a
	 List<WebElement> allLinks = driver.findElements(By.tagName("a"));
	  
	 // printingtext along with link address
	 for(WebElement link:allLinks){
	 System.out.println(link.getText() + " - " + link.getAttribute("href"));
	 }
	  
	 
	 for(int i=0;i<allLinks.size();i++)
     {
         if((allLinks.get(i).isDisplayed()))
         {
        	 
        	 allLinks.get(i).click();
        
        	 logger.info("Click Operation Performend on Links" );
         Thread.sleep(3000);
    
       
         driver.navigate().back();
        
         allLinks=driver.findElements(By.tagName("a"));
         }  
     
     
	}  
	 quitBrowser();
  }
}
	
	


