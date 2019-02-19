package Steps;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.MtvPages;

public class CatFishTest {
	
	WebDriver driver;
	MtvPages mtv;
	
	@BeforeTest
	public void launchBrowser() {
		
		String path = System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver", path+"\\driver\\chromedriver.exe");
		
	}

	@Test()
	@Parameters({"browser"})
	public void catfishtest(String browser) throws InterruptedException {
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("ie")) {
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.mtv.com/");
		driver.manage().window().maximize();
		mtv = new MtvPages(driver);
		
		try {	
			mtv.mouseHoverOnMenu();
			
			mtv.clickOnShows();
			
			mtv.clickOncatFishTvShow();
			
			mtv.getTitleAndClick();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
}
