package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MtvPages {
	
	
	WebDriver driver;
	
	public MtvPages(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH, using="//a[@class='has_arrow']")
	public WebElement shows_menu;
	
	@FindBy(how=How.XPATH, using="//div[@class='links']/div[@class='column']/a[2]")
	public WebElement shows_a_z;
	
	@FindBy(how=How.XPATH, using="//ul[contains(@class, 'L001_line_list')]/li[2]")
	public WebElement catfish_tv_show;
	
	@FindBy(how=How.XPATH, using="//div[contains(@class, 'toggleable_module_content')]/ul/li")
	public WebElement clips;
	
	@FindBy(how=How.XPATH, using="//div[contains(@class, 'toggleable_module_content')]/ul/li//h4")
	public WebElement seasonName;
	
	@FindBy(how=How.XPATH, using="//div[contains(@class, 'toggleable_module_content')]/ul/li//h3")
	public WebElement actorName;
	
	public void mouseHoverOnMenu() throws InterruptedException {
		Actions ac = new Actions(driver);
		ac.moveToElement(shows_menu).build().perform();
		Thread.sleep(3000);
	}
	
	public void clickOnShows() throws InterruptedException {
		shows_a_z.click();
		Thread.sleep(3000);
	}
	
	public void clickOncatFishTvShow() throws InterruptedException {
		catfish_tv_show.click();
		Thread.sleep(3000);
	}
	
	public void getTitleAndClick() {
		System.out.println("Season Name: "+seasonName.getText());
		System.out.println("Actor Name: "+actorName.getText());
		clips.click();
	}
}
