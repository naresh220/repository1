package com.squarepanda.seleniumUtility;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class SeleniumDriver {
	
	private static SeleniumDriver seleniumDriver;
	
    //initialize webdriver
    private static WebDriver driver;
   
    
    //initialize timeouts
    
    public final static int TIMEOUT = 30;
    public final static int PAGE_LOAD_TIMEOUT = 70;
    public final static int SLEEP = 70;

//	@SuppressWarnings("unused")
//	private WebDriverWait waitDriver;  
//	private  SeleniumDriver() {
//      waitDriver = new WebDriverWait(driver, TIMEOUT);
//        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//        String window=driver.getWindowHandle();
//        System.out.println("Window ->"+window);
//       
//    }
    public static void launchBrowser() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Naresh\\Downloads\\chromedriver_v85\\chromedriver.exe");
    	driver = new ChromeDriver();
    	System.out.println(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        System.out.println("loaded");
    	
    }

    public static void openPage(String url) {
    	launchBrowser();
    	System.out.println(url);
    	driver.get(url);
        
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setUpDriver() {
       if (seleniumDriver == null)
            seleniumDriver = new SeleniumDriver();
      
    }

    public static void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
        seleniumDriver = null;
    }
    public static void waitForPageToLoad()
    {
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}


