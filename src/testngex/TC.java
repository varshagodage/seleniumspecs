package testngex;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.xerces.impl.xpath.regex.Match;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import net.sourceforge.htmlunit.corejs.javascript.ast.ForInLoop;

public class TC {
	 private static WebDriver driver = null;
	 
	public static void main(String[] args) throws Exception{
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
		
		for(int i=1;i<5;i++){
			String model=ExcelUtils.getCellData(i, 1);
			String brand=ExcelUtils.getCellData(i, 0);
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Ganu\\Downloads\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
	 
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        
	        
	        System.out.println("model number is "+brand+" "+model);
	        driver.get("http://www.google.com");
	        driver.manage().window().maximize();
	        driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div/div[1]/div/div[1]/input")).sendKeys(brand+" "+model+" specs"+Keys.ENTER);
	        String str1=driver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div[1]/div/div[1]/div[2]/div[2]/div/span")).getText();
	        System.out.println("str1 is "+str1);
	        driver.findElements(By.partialLinkText("gsmarena")).get(0).click();
	        String url=driver.getCurrentUrl();
	        /*driver.findElement(By.xpath("//*[@id='qcCmpButtons']/button")).click();
	        String str=driver.findElement(By.xpath("//*[@id='specs-list']/table[4]/tbody/tr[3]/td[2]")).getText();
	        */
	        Pattern p=Pattern.compile("\\d{4}\\sx\\s\\d{4}");
	        Matcher m=p.matcher(str1);
	        String resolution="";
	        while(m.find()){
	        System.out.println("Resolution is "+m.group());
	        resolution=m.group();
	        }
	        ExcelUtils.setCellData(resolution, i, 2);
	        ExcelUtils.setCellData(url, i, 3);
	        driver.quit();
	 
		}
		
		
		
        //This is to send the PASS value to the Excel sheet in the result column.
 
        //ExcelUtils.setCellData("Pass", 1, 3);
	}
}
