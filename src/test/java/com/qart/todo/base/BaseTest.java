package com.qart.todo.base;

import com.qart.todo.factory.DriverFactory;
import com.qart.todo.utils.CookiesUtils;
import io.qameta.allure.Allure;
import io.restassured.http.Cookie;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BaseTest {
    protected  WebDriver driver;


    @BeforeMethod
    public void Setup(){
       driver = new DriverFactory().InitializeDriver();
    }

   @AfterMethod
   public void Teardow(ITestResult result) throws IOException {

//        String methodName=result.getMethod().getMethodName();
//        File desFile= new File("screenshots"+ File.separator +methodName+".png");
//        takeScreenShot(desFile);

        String TCname = result.getMethod().getMethodName();
        File TCfile = new File("screenshoot"+File.separator+TCname+".png");
     File file=  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
     FileUtils.copyFile(file,TCfile);



       driver.quit();
   }



   public void injectCookiesToBrowser(List<Cookie> restAssuredCookies){
       List<org.openqa.selenium.Cookie> SelenuimCookies= CookiesUtils.convertRestAssuredCookiesToSeleniumCookies(restAssuredCookies);
       for(org.openqa.selenium.Cookie cookie : SelenuimCookies){
           driver.manage().addCookie(cookie);
       }

   }

   public  void takeScreenShot(File desFile){

       File file=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       try {
           FileUtils.copyFile(file,desFile);

           InputStream is=new FileInputStream(desFile);
           Allure.addAttachment("ScreenShot",is);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
   }








}
