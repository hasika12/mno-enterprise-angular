package TestScriptDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import library.genlib;
import objectRepository.Pg_ChoosingApps;

import objectRepository.Pg_LogOutMaestrano;
import objectRepository.Pg_LoginMaestrano;



public class Module1 {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	
	
	@Test(description="This test case will log into Maestrano application")
	public void TC101_LoginMaestrano() throws Exception
	{
		report = new ExtentReports("F:\\Selenium Framework TM\\TMFV1.0\\Reports\\TestReport.html");
		
		logger=report.startTest("Verify Login");

		System.out.println("Launching Maestrano");
		boolean stepstatus;
						
		driver = genlib.launchBrowser("firefox", "");
		
		logger.log(LogStatus.INFO, "Browser Started");
		genlib.launchApplication("https://get.maestrano.com", driver);
		
		logger.log(LogStatus.INFO, "Appn is up and Running");
		
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		

        String ExpectedBrowserTitle=driver.getTitle();
        
        System.out.println("title is: "+ExpectedBrowserTitle);
        
        SoftAssert asst = new SoftAssert();
        asst.assertEquals("Maestrano", ExpectedBrowserTitle, "Browser Titles donot match");
        logger.log(LogStatus.PASS, "Title Verified");
		
		stepstatus=genlib.setText(Pg_LoginMaestrano.Edt_EmailID, "saii2882@gmail.com", driver);
		genlib.logEvent(stepstatus, "entered EmailID successfully", "unable to enter EmailID");
		
		stepstatus=genlib.setText(Pg_LoginMaestrano.Edt_Pwd, "Vanaja12.", driver);
		genlib.logEvent(stepstatus, "entered Password successfully", "unable to enter Password");
		
		stepstatus=genlib.clickElement(Pg_LoginMaestrano.Btn_SignIn, driver);
		genlib.logEvent(stepstatus, "clicked on SignIn button", "unable to click on Signin button");
		
		stepstatus=genlib.exists(Pg_LoginMaestrano.Btn_ChooseMyApps, driver);
		genlib.logEvent(stepstatus, "'Choose My Apps' button was found on LoginPage", "'Choose My Apps' button was not observed on LoginPage");
		
		//Thread.sleep(5000);
		
		stepstatus=genlib.clickElement(Pg_LogOutMaestrano.Lnk_ClickArrow, driver);
		genlib.logEvent(stepstatus, "clicked on arrow mark for signout", "unable to click on arrow mark for Signout");
		
		stepstatus=genlib.clickElement(Pg_LogOutMaestrano.Lnk_SignOut, driver);
		genlib.logEvent(stepstatus, "clicked on SignOut Link", "unable to click on SignOut Link");
		
		
		
		report.endTest(logger);
		report.flush();
		driver.get("F:\\Selenium Framework TM\\TMFV1.0\\Reports\\TestReport.html");
		
		//stepstatus=genlib.quitbrowser(driver);
		
		
		
		asst.assertAll();
		
		
	}


	@Test(description="This test case will login and choose the appns", enabled=true)
	public void TC102_ChoosingApplications() throws Exception
	{
		
		
		System.out.println("Launching Maestrano");
		boolean stepstatus;
						
		driver = genlib.launchBrowser("firefox", "");
		genlib.launchApplication("https://get.maestrano.com", driver);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
        String ExpectedBrowserTitle=driver.getTitle();
        
        System.out.println("title is: "+ExpectedBrowserTitle);
        
        SoftAssert asst = new SoftAssert();
        asst.assertEquals("Maestrano", ExpectedBrowserTitle, "Browser Titles donot match");
        
		
		stepstatus=genlib.setText(Pg_LoginMaestrano.Edt_EmailID, "saii2882@gmail.com", driver);
		genlib.logEvent(stepstatus, "entered EmailID successfully", "unable to enter EmailID");
		
		stepstatus=genlib.setText(Pg_LoginMaestrano.Edt_Pwd, "Vanaja12.", driver);
		genlib.logEvent(stepstatus, "entered Password successfully", "unable to enter Password");
		
		stepstatus=genlib.clickElement(Pg_LoginMaestrano.Btn_SignIn, driver);
		genlib.logEvent(stepstatus, "clicked on SignIn button", "unable to click on Signin button");
		
		stepstatus=genlib.exists(Pg_LoginMaestrano.Btn_ChooseMyApps, driver);
		genlib.logEvent(stepstatus, "'Choose My Apps' button was found on LoginPage", "'Choose My Apps' button was not observed on LoginPage");
		
		//Thread.sleep(5000);
		
		
		stepstatus=genlib.clickElement(Pg_LoginMaestrano.Btn_ChooseMyApps, driver);
		genlib.logEvent(stepstatus, "clicked on 'Choose My Apps' button", "unable to click on 'Choose My Apps' button");
		
		stepstatus=genlib.exists(Pg_ChoosingApps.Wbe_SelectingAppsHeading, driver);
		genlib.logEvent(stepstatus, "'Selecting the apps' header was observed on 'Select your applications Page'", "'Selecting the apps' header was not observed on 'Select your applications Page'");
		
		Select st=new Select(driver.findElement(By.xpath(".//*[@id='app-category']")));
		st.selectByVisibleText("Marketing");
		
		driver.findElement(By.xpath("(//img[@class='app-logo img-thumbnail'])[1]")).click();
		
		driver.findElement(By.xpath("//*[text()='Connect my apps!']")).click();
		
		driver.findElement(By.xpath("//*[text()='Go to my dashboard!']")).click();
		
		stepstatus=genlib.clickElement(Pg_LogOutMaestrano.Lnk_ClickArrow, driver);
		genlib.logEvent(stepstatus, "clicked on arrow mark for signout", "unable to click on arrow mark for Signout");
		
		stepstatus=genlib.clickElement(Pg_LogOutMaestrano.Lnk_SignOut, driver);
		genlib.logEvent(stepstatus, "clicked on SignOut Link", "unable to click on SignOut Link");
		
		stepstatus=genlib.quitbrowser(driver);
		
		asst.assertAll();
		
		
	}

	
	

}


