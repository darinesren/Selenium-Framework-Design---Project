package com.qart.todo.pages;

import com.qart.todo.base.BasePage;
import com.qart.todo.utils.ConfigUtils;
import com.qart.todo.utils.PropertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public LoginPage load()
    {
//        PropertiesUtils propertiesUtils =new PropertiesUtils();
//        Properties properties= propertiesUtils.loadProperties("src/test/java/com/qart/todo/config/producation.properties");
//        driver.get(properties.getProperty("baseUrl"));

        driver.get(ConfigUtils.getInstance().getBaseUrl());
        return this;
    }

    @FindBy(css = "[data-testid=\"email\"]")
    WebElement emailInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(css = "[data-testid=\"submit\"]")
    WebElement submitInput;

    public TodoPage login(String email, String pass) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(pass);
        submitInput.click();
        return new TodoPage(driver);
    }



}
