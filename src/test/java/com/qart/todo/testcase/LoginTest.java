package com.qart.todo.testcase;

import com.qart.todo.base.BaseTest;
import com.qart.todo.factory.DriverFactory;
import com.qart.todo.pages.LoginPage;
import com.qart.todo.pages.TodoPage;
import com.qart.todo.utils.ConfigUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
@Feature("Auth featche")
public class LoginTest extends BaseTest {
    @Story("login with Email and password")
    @Description("This test verifies that the user can login successfully")
    @Test(description = "Test login functionality")
    public void ShouldBeAbleToLoginWithEmailAndPassword(){
        LoginPage loginpage = new LoginPage(driver);
        boolean WelcomeMessage =loginpage
                .load()
                .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                .WelcomeMessageIsDisplayed();

        Assert.assertTrue(WelcomeMessage);
    }
}
