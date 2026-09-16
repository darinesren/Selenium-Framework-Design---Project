package com.qart.todo.pages;

import com.qart.todo.base.BasePage;
import com.qart.todo.config.EndPoint;
import com.qart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoPage extends BasePage {

    public TodoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="[data-testid=\"welcome\"]")
    WebElement WelcomeMessage;

    @FindBy(css="[data-testid=\"add\"]")
    WebElement addButton;

    @FindBy(css="[data-testid=\"todo-item\"]")
    WebElement todoItem;

    @FindBy(css="[data-testid=\"delete\"]")
    WebElement deleteButton;

    @FindBy(css="[data-testid=\"no-todos\"]")
    WebElement noTodosMessage;


    public boolean WelcomeMessageIsDisplayed(){
        return WelcomeMessage.isDisplayed();
    }

    public NewTodoPage clickOnPlusButton(){
        addButton.click();
        return new NewTodoPage(driver);
    }
    public String getTodoItem(){
        return todoItem.getText();
    }
    public TodoPage load(){
        driver.get(ConfigUtils.getInstance().getBaseUrl()+ EndPoint.TODO_ENDPOINT);
        return this;
    }
    public TodoPage clickDeleteButton(){
        deleteButton.click();
        return  this;
    }

    public boolean noTodosMessageIsDisplayed(){
        return noTodosMessage.isDisplayed();
    }
}
