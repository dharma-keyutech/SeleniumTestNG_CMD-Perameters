package Smoke_Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import Base.Basetest;
import Base.all_xpaths;

public class Click_Email_Nav_Home extends Basetest implements all_xpaths {
	
	private static final Logger logger = LogManager.getLogger(Click_Email_Nav_Home.class);
	public static String BrowserName=System.getProperty("Browsername");

	static WebDriver driver;
	@Test(groups={"Smoke"})
    public static void Contactus() throws IOException{
		
		// To read The Property File 
				Properties prop=new Properties();
				FileInputStream ip= new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/data.properties");
				prop.load(ip);
		
				// Launching Browser
		
	     launchBrowser(BrowserName);	
	     
	     // passing the URL
	     
		 sendURL(prop.getProperty("BaseUrl"));
		
		 // Performing Click on element
        click(Contactus);
        logger.info("Click on ContactUs Sucessfully");
        
        // Performing Click on element
        
        Basetest.click(Home); 
         logger.info("Navigating to Home ");
    	
         // Closing the browser 
         
         quitBrowser();
		 
		
	}
	
	
	

}
