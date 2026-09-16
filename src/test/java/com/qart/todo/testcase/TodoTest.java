package com.qart.todo.testcase;

import com.qart.todo.API.RegisterAPI;
import com.qart.todo.API.TaskAPI;
import com.qart.todo.base.BaseTest;
import com.qart.todo.factory.DriverFactory;
import com.qart.todo.pages.LoginPage;
import com.qart.todo.pages.NewTodoPage;
import com.qart.todo.pages.TodoPage;
import com.qart.todo.utils.ConfigUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.http.Cookie;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
@Feature("Todo featche")
public class TodoTest extends BaseTest {
    @Story("Able to Add New Todo")
    @Description("This test verifies that the user can successfully add a new todo item")
    @Test(description = "Test add New Todo")
    public  void shouldBeAbleToAddNewTodo()  {
        RegisterAPI registerAPI = new RegisterAPI();
        registerAPI.register();
        List<Cookie> restAssuredCookies=registerAPI.getCookies();

        NewTodoPage newTodoPage = new NewTodoPage(driver);
        newTodoPage.load();
        injectCookiesToBrowser(restAssuredCookies);
        String ActualAdd= newTodoPage.load()
                .addNewTask("Selenuim")
                .getTodoItem();
        Assert.assertEquals(ActualAdd,"Selenuim");
    }
//
@Story("Able to Delete Todo")
@Description("This test verifies that the user can successfully delete a todo item ")
@Test(description = "Test Delete Todo")
    public void shouldBeAbleToDeleteTodo(){
       RegisterAPI registerAPI = new RegisterAPI();
       registerAPI.register();
       List<Cookie> restAssuredCookies=registerAPI.getCookies();

       TaskAPI taskAPI = new TaskAPI();
       taskAPI.addTask(registerAPI.getToken());

        TodoPage todoPage = new TodoPage(driver);
        todoPage.load();
        injectCookiesToBrowser(restAssuredCookies);

       TodoPage Noitemsdiv = todoPage
                .load()
                .clickDeleteButton();
//
//        Assert.assertTrue(Noitemsdiv);



    }
}
