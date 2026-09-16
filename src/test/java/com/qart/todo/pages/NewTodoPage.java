package com.qart.todo.pages;

import com.qart.todo.base.BasePage;
import com.qart.todo.config.EndPoint;
import com.qart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewTodoPage extends BasePage {


    public NewTodoPage(WebDriver driver) {
        super(driver);
    }
public NewTodoPage load(){
        driver.get(ConfigUtils.getInstance().getBaseUrl()+ EndPoint.NEW_TODO_ENDPOINT);
        return this;
}

    @FindBy(css="[data-testid=\"new-todo\"]")
    WebElement  newTodo;

    @FindBy(css="[data-testid=\"submit-newTask\"]")
    WebElement submitNewTask;
    public TodoPage addNewTask(String task){
        newTodo.sendKeys(task);
        submitNewTask.click();
        return new TodoPage(driver);

    }

}

