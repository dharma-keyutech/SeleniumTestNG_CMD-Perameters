package FullSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Basetest;
import Regression.Click_contactus_passData;
import Smoke_Test.home_page_with_all_links;

public class Keyutech extends Basetest {
	
	private static final Logger logger = LogManager.getLogger(Keyutech.class);
    
		@Test
		public static void keyutechSite() throws IOException, InterruptedException {
		
		// To read The Property File 
				Properties prop=new Properties();
				FileInputStream ip= new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/data.properties");
				prop.load(ip);
				  try {		
				//  Launching Browser 
				
				launchBrowser(prop.getProperty("Browser"));
				
				// Passing the URL
				
			    sendURL(prop.getProperty("BaseUrl"));
			    
			// Performing CLick On All visible Links	 
		         click(Aboutus);
		         logger.info("Clicking on About us");
		         click(Services);
		         logger.info("Clicking on Services");
		         click(Products);
		         logger.info("Clicking on Products");
		         click(TCoE);
		         logger.info("Clicking on TCoE");
		         click(Contactus); 
		         logger.info("Clicking on Contact us");
		         click(Home);
		         logger.info("Clicking on Home and navigating to home");
		         Thread.sleep(5000);
		         
		         
		      // Closing the browser
		         
		       quitBrowser();
		         
		       //Performing Click on  all links on Home Page 
		              Click_contactus_passData.EmailUs();
		              
		      // Gathering all links and clicking on all links
		              home_page_with_all_links.CLickLinks();
				  }
		              
		              catch (Exception e) {
		      			

						   /* logger.error("Test Fail", e);*/
						    onTestFailure();
						    driver.quit();
						   Assert.fail("");
							
						}

		              
		              
		           
	
		}
}
