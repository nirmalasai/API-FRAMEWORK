package POM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.genericUtilities.IConstants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginThenVerifyAndLogoutRMGYantra {
	
	
 public void verifyinPresentationLayer(String projectId) {
	 WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.get(IConstants.RmgUri);
		driver.findElement(By.id("usernmae")).sendKeys(IConstants.appUserName);
		driver.findElement(By.id("inputPassword")).sendKeys(IConstants.appPassword);
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		List<WebElement> projectIds = driver.findElements(By.xpath("//tr//td[1]"));
		boolean flag1=false;
		for (WebElement id : projectIds) {

			String proId = id.getText();

			if (proId.equalsIgnoreCase(projectId)) {
				flag1=true;
			}
		}
		if (flag1==true) {
			System.out.println("Project is available From Database!");
		}
		else {
			System.out.println("Project is not available From Database!");

		}
		driver.quit();

 }
}
