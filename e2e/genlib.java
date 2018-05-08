package library;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class genlib 
{
	public static WebDriver launchBrowser(String BrowserName,String BrowserServerPath)
	{
		WebDriver Tempdriver = null;
		switch(BrowserName.toLowerCase())
		{
			case "firefox":
			{
				if(BrowserServerPath.length()>0)
				{
					System.setProperty("webdriver.gecko.driver", BrowserServerPath);
					Tempdriver = new FirefoxDriver();
				}
				else
				{
					Tempdriver = new FirefoxDriver();
				}
				break;
			}
			case "ie":
			case "internetexplorer":
			{
				System.setProperty("webdriver.ie.driver", BrowserServerPath);
				Tempdriver = new InternetExplorerDriver();
				break;
			}
			case "chrome":
			{
				System.setProperty("webdriver.chrome.driver",BrowserServerPath);
				Tempdriver = new ChromeDriver();
				break;
			}
			default:
			{
				System.out.println("please Select the correct browser");
			}
			
			
		}
		Tempdriver.manage().window().maximize();
		return Tempdriver;
	}
//======================================================================================
	public static boolean launchApplication(String URL,WebDriver driver)
	{
		boolean stepstatus;
		try
		{
			driver.get(URL);
			stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
//======================================================================================
	public static boolean setText(By ele,String StrValue, WebDriver driver)
	{
		boolean stepstatus;
		try
		{
			driver.findElement(ele).sendKeys(StrValue);
			driver.findElement(ele).sendKeys(Keys.ESCAPE);
			stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	
//======================================================================================
	public static boolean clickElement(By ele,WebDriver driver)
	{
		boolean stepstatus;
		try
		{
			driver.findElement(ele).click();
			stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
//======================================================================================
	public static boolean setDateinCalender(By ele, String StrDate,WebDriver driver)
	{
		boolean stepstatus;
		try
		{
			driver.findElement(ele).click();
			driver.findElement(ele).sendKeys(StrDate);
			driver.findElement(ele).sendKeys(Keys.ESCAPE);
			Thread.sleep(1000);
			stepstatus=true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
//======================================================================================
	public static boolean setOptionInSelect(By eleSelect, By eleOption,WebDriver driver)
	{
		boolean stepstatus = false;
		try
		{
			driver.findElement(eleSelect).findElement(eleOption).click();
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
//======================================================================================
	public static boolean setOptionSelect(By eleSelectAndOption,WebDriver driver)
	{
		boolean stepstatus = false;
		try
		{
			driver.findElement(eleSelectAndOption).click();
			stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
//======================================================================================	
	public static boolean exists(By ele, WebDriver driver)
	{
		boolean stepstatus;
		try
		{
			driver.findElement(ele);
			stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	
//======================================================================================	
	public static boolean quitbrowser(WebDriver driver)
	{
		boolean stepstatus;
		try
		{
			driver.quit();
			stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	
	public static String getLinkText(By ele, WebDriver driver)
	{
		String value = "";
		try
		{
			value = driver.findElement(ele).getText();
		}
		catch(Exception e)
		{
		}
		return value;
	}
	public static String getAttributeValue(By ele,String AttributeName, WebDriver driver)
	{
		String value = "";
		try
		{
			value = driver.findElement(ele).getAttribute(AttributeName);
		}
		catch(Exception e)
		{
		}
		return value;
	}
	public static boolean mouseHover(By ele, WebDriver driver)
	{
		boolean stepstatus;
		try
		{
			Actions a1 = new Actions(driver);
			a1.moveToElement(driver.findElement(ele));
			a1.build().perform();
			stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	public static boolean rightClick(By ele, WebDriver driver)
	{
		boolean stepstatus;
		try
		{
			Actions a1 = new Actions(driver);
			a1.contextClick(driver.findElement(ele));
			a1.build().perform();
			stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	public static boolean doubleClick(By ele, WebDriver driver)
	{
		boolean stepstatus;
		try
		{
			Actions a1 = new Actions(driver);
			a1.doubleClick(driver.findElement(ele));
			a1.build().perform();
			stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	public static boolean dragAndDrop(By drag,By drop, WebDriver driver)
	{
		boolean stepstatus;
		try
		{
			Actions a1 = new Actions(driver);
			a1.dragAndDrop(driver.findElement(drag), driver.findElement(drop));
			a1.build().perform();
			stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	
	public static String getData(String FieldName)
	{
		String FieldValue = "";
		try
		{
			StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
			StackTraceElement stackTraceElement = stackTraceElements[2];
			String TestCaseName = stackTraceElement.getMethodName();
			
			File f1 = new File("TestData.xlsx");
			FileInputStream fis = new FileInputStream(f1);
			XSSFWorkbook wb1 = new XSSFWorkbook(fis);
			
			XSSFSheet ws1 = wb1.getSheet("TestData");
			
			int rowcount = ws1.getLastRowNum();
			
			for(int r = 0;r<=rowcount;r++)
			{
				String Excel_TestCaseName = ws1.getRow(r).getCell(0).getStringCellValue();
				if(Excel_TestCaseName.equalsIgnoreCase(TestCaseName))
				{
					int cellcount = ws1.getRow(r).getLastCellNum();
					for(int c = 0;c<cellcount;c++)
					{
						String Excel_CellValue = ws1.getRow(r).getCell(c).getStringCellValue();
						String []ArrExcelValue = Excel_CellValue.split(":=");
						String ExcelFieldName = ArrExcelValue[0];
						if(ExcelFieldName.equalsIgnoreCase(FieldName))
						{
							FieldValue = ArrExcelValue[1];
							break;
						}
					}
				}
			}
			fis.close();
			wb1.close();
		}
		catch(Exception e)
		{
			FieldValue = "NA";
		}
		return FieldValue;
	}
	public static String putData(String FieldName,String FieldValue)
	{
		try
		{
			StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
			StackTraceElement stackTraceElement = stackTraceElements[2];
			String TestCaseName = stackTraceElement.getMethodName();
			
			File f1 = new File("TestData.xlsx");
			FileInputStream fis = new FileInputStream(f1);
			XSSFWorkbook wb1 = new XSSFWorkbook(fis);
			
			XSSFSheet ws1 = wb1.getSheet("TestData");
			
			int rowcount = ws1.getLastRowNum();
			
			for(int r = 0;r<=rowcount;r++)
			{
				String Excel_TestCaseName = ws1.getRow(r).getCell(0).getStringCellValue();
				if(Excel_TestCaseName.equalsIgnoreCase(TestCaseName))
				{
					int cellcount = ws1.getRow(r).getLastCellNum();
					for(int c = 0;c<cellcount;c++)
					{
						String Excel_CellValue = ws1.getRow(r).getCell(c).getStringCellValue();
						String []ArrExcelValue = Excel_CellValue.split(":=");
						String ExcelFieldName = ArrExcelValue[0];
						if(ExcelFieldName.equalsIgnoreCase(FieldName))
						{
							Excel_CellValue = ExcelFieldName + ":=" + FieldValue;
							break;
						}
					}
				}
			}
			fis.close();
			
			FileOutputStream fos = new FileOutputStream(f1);
			wb1.write(fos);
			
			fos.close();
			wb1.close();
		}
		catch(Exception e)
		{
			FieldValue = "NA";
		}
		return FieldValue;
	}
	
	public static boolean getExecuteStatus(String mthName)
	{
		boolean flag=false;
		
		try
		{
			XSSFRow rww;
			XSSFCell cll;
			
			File fi=new File("RunManager.xlsx");
			FileInputStream fin=new FileInputStream(fi);
			
			XSSFWorkbook wrk=new XSSFWorkbook(fin);
			XSSFSheet shet=wrk.getSheet("TestCaseDetails");
			
			rww=shet.getRow(1);
			for(int i=0;i<=shet.getLastRowNum();i++)
			{
				rww=shet.getRow(i+1);
				if(rww==null || rww.getCell(0)==null )
				continue;
				cll=rww.getCell(1);
				if(cll.getStringCellValue().equals(mthName))
				{
					cll=rww.getCell(2);
					flag=cll.getBooleanCellValue();
				}
			}
			wrk.close();
			fin.close();
		}
		catch(Exception e)
		{
			
		}
		return flag;
	}
	
	public static int getPriority(String mthName)
	{
		int priority=0;
		
		try
		{
			XSSFWorkbook wrk;
			XSSFSheet shet;
			XSSFRow rww;
			XSSFCell cll;
			
			File fi=new File("RunManager.xlsx");
			FileInputStream fin=new FileInputStream(fi);
			
			wrk=new XSSFWorkbook(fin);
			shet=wrk.getSheet("TestCaseDetails");
			rww=shet.getRow(1);
			for(int i=0;i<=shet.getLastRowNum();i++)
				
			{
				rww=shet.getRow(i+1);
				if(rww==null || rww.getCell(4)==null)
				continue;
				cll=rww.getCell(1);
				if(cll.getStringCellValue().equals(mthName))
				{
					cll=rww.getCell(3);
					String result=cll.getStringCellValue();
					priority=Integer.parseInt(result);
				}
			}
			
			wrk.close();
			fin.close();
		}
		catch(Exception e)
		{
			
		}
		return priority;
		
	}
	
	
	public static boolean JsclickElement(By ele,WebDriver driver)
	{
		boolean stepstatus;
		try
		{
			WebElement element = driver.findElement(ele);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", element);
			stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	public static boolean JssetText(By ele,String StrValue,WebDriver driver)
	{
		boolean stepstatus;
		try
		{
			WebElement element = driver.findElement(ele);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].value='" + StrValue + ";", element);
			stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	public static boolean JsScrollToWebElement(By ele,WebDriver driver)
	{
		boolean stepstatus;
		try
		{
			WebElement element = driver.findElement(ele);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
			stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	public static boolean JsHighlight(By ele,WebDriver driver)
	{
		boolean stepstatus;
		try
		{
			WebElement element = driver.findElement(ele);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			for(int i = 1;i<=3;i++)
			{
				js.executeScript("arguments[0].style.border='solid 4px black'", element);
				Thread.sleep(300);
				js.executeScript("arguments[0].style.border=''", element);
				Thread.sleep(300);
			}
			stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	public static boolean acceptAlert(By ele,WebDriver driver)
	{
		boolean stepstatus;
		try
		{
			Alert a1 = driver.switchTo().alert();
			a1.accept();
			stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	public static boolean dismissAlert(By ele,WebDriver driver)
	{
		boolean stepstatus;
		try
		{
			Alert a1 = driver.switchTo().alert();
			a1.dismiss();
			stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	public static boolean alertExist(By ele,WebDriver driver)
	{
		boolean stepstatus;
		try
		{
			driver.switchTo().alert();
			stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	public static String alertGetText(By ele,WebDriver driver)
	{
		String StrValue = "";
		try
		{
			Alert a1 = driver.switchTo().alert();
			StrValue = a1.getText();
		}
		catch(Exception e)
		{
			
		}
		return StrValue;
	}
	
	public static boolean isWindowExists(String URL,WebDriver driver)
	{
		boolean stepstatus = false;
		try
		{
			Set<String> allhandles = driver.getWindowHandles();
			for(String handle:allhandles)
			{
				driver.switchTo().window(handle);
				String CurrentURL = driver.getCurrentUrl();
				if(CurrentURL.contains(URL))
				{
					stepstatus = true;
					break;
				}
			}
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	
	
	
	
	public static WebDriver SwitchtoWindow(String URL,WebDriver driver)
	{
		try
		{
			Set<String> allhandles = driver.getWindowHandles();
			for(String handle:allhandles)
			{
				driver.switchTo().window(handle);
				String CurrentURL = driver.getCurrentUrl();
				if(CurrentURL.contains(URL))
				{
					break;
				}
			}
		}
		catch(Exception e)
		{
			
		}
		return driver;
	}
	public static WebDriver SwitchtoFrame(WebElement FrameRef,WebDriver driver)
	{
		try
		{
			driver.switchTo().frame(FrameRef);
		}
		catch(Exception e)
		{
			
		}
		return driver;
	}
	public static WebDriver SwitchtoParentDocument(String FrameRef,WebDriver driver)
	{
		try
		{
			driver.switchTo().defaultContent();
		}
		catch(Exception e)
		{
			
		}
		return driver;
	}
	public static WebDriver closeWindow(String URL,WebDriver driver)
	{
		try
		{
			Set<String> allhandles = driver.getWindowHandles();
			for(String handle:allhandles)
			{
				driver.switchTo().window(handle);
				String CurrentURL = driver.getCurrentUrl();
				if(CurrentURL.contains(URL))
				{
					driver.close();
					break;
				}
			}
		}
		catch(Exception e)
		{

		}
		return driver;
	}
	
	public static boolean RobotKeysFileUpload(String Filepath)
	{
		boolean stepstatus;
		try
		{
		   wait(2);
		   StringSelection selection = new StringSelection(Filepath);
	       Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	       clipboard.setContents(selection,selection);

			
			Robot robo = new Robot();   
			robo.keyPress(KeyEvent.VK_CONTROL);
	     	robo.keyPress(KeyEvent.VK_V);
	      	robo.keyRelease(KeyEvent.VK_V);
	      	robo.keyRelease(KeyEvent.VK_CONTROL);

	  		wait(2);
	      	robo.keyPress(KeyEvent.VK_ENTER);
	      	robo.keyRelease(KeyEvent.VK_ENTER);
	    	robo.keyPress(KeyEvent.VK_ENTER);
	      	robo.keyRelease(KeyEvent.VK_ENTER);
	      	wait(2);
	      	stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	
	public static boolean wait(int timeInSec)
	{
		boolean stepStatus;
		try
		{
			Thread.sleep(timeInSec*1000);
			stepStatus = true;
		}
		catch(Exception e)
		{
			stepStatus = false;
		}		
		return stepStatus;
	}
	public static void logEvent(boolean stepstatus,String Passlog,String FailLog)
	{
		if(stepstatus==true)
		{
			System.out.println("<<PASS>> " + Passlog);
		}
		else
		{
			System.out.println("<<FAIL>>  " + FailLog);
		}
	}
	public static boolean dynamicWait(By by,WebDriver driver,int waittimeinsec)
	{
			boolean status = false;
			int counter = 0;
			while(counter<=waittimeinsec)
			{
				try
				{
					driver.findElement(by);
					status = true;
					break;
				}
				catch(Exception e)
				{
					try 
					{
						Thread.sleep(1000);
					} catch (Exception e1) 
					{
						
					}
					counter = counter+ 1;
				}
			 }
			 if(counter>waittimeinsec)
			 {
				 status = false;
			 }
			 return status;
	}
	
	public static WebDriver SetImplicitWait(int TimeInSec,WebDriver driver)
    {
        try
        {
        	driver.manage().timeouts().implicitlyWait(TimeInSec, TimeUnit.SECONDS);
        }
        catch (Exception e)
        {
        }
        return driver;
    }
	public static String getTimeStamp() 
	{
		DateFormat dateTimeInstance = SimpleDateFormat.getDateTimeInstance();
	    String DateTimeStamp = dateTimeInstance.format(Calendar.getInstance().getTime());
	    DateTimeStamp = DateTimeStamp.replace(",", "");
	    DateTimeStamp = DateTimeStamp.replace(" ", "_");
	    DateTimeStamp = DateTimeStamp.replace(":", "-");
		return  DateTimeStamp;
	}
	public static String getscreenshot(WebDriver driver,String Dest)
	{
		  try
		  {
			StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
			StackTraceElement stackTraceElement = stackTraceElements[3];
			String CurrentTestCase = stackTraceElement.getMethodName();
			CurrentTestCase = CurrentTestCase.replace(".java", "");
			
			TakesScreenshot ts =(TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File destinationfile = new File(Dest);
			FileUtils.copyFile(source, destinationfile);
			return Dest;
		  }
		  catch(Exception e)
		  {
			  return e.getMessage();
		  }
	}

	public static String createresultsfolder(String ResultsFolderPath) 
	{
		DateFormat dateTimeInstance = SimpleDateFormat.getDateTimeInstance();
	    String DateTimeStamp = dateTimeInstance.format(Calendar.getInstance().getTime());
	    DateTimeStamp = DateTimeStamp.replace(",", "");
	    DateTimeStamp = DateTimeStamp.replace(" ", "_");
	    DateTimeStamp = DateTimeStamp.replace(":", "-");
	    ResultsFolderPath = System.getProperty("user.dir") + "//" + ResultsFolderPath;
		File dir = new File(ResultsFolderPath + "//" +  DateTimeStamp);
		dir.mkdir();
		File dir2 = new File(ResultsFolderPath + "//" +  DateTimeStamp + "//Screenshots");
		dir2.mkdir();
		return ResultsFolderPath + "//" + DateTimeStamp;
	}
	public static boolean AutoITFileUpload(String AutoITFilePath,String Filepath)
    {
        Boolean stepStatus = true;
        try
        {
        	Runtime.getRuntime().exec(AutoITFilePath + " " + Filepath);
        }
        catch (Exception e)
        {
            stepStatus = false;
        }
        return stepStatus;
    }
	public static boolean AutoITFileUpload(String AutoITFilePath)
    {
        Boolean stepStatus = true;
        try
        {
        	Runtime.getRuntime().exec(AutoITFilePath);
        }
        catch (Exception e)
        {
            stepStatus = false;
        }
        return stepStatus;
    }

}
