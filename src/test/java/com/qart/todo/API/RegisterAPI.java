package com.qart.todo.API;

import com.qart.todo.config.EndPoint;
import com.qart.todo.objects.User;
import com.qart.todo.utils.UserUtils;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

import java.util.List;

public class RegisterAPI {

    User user = UserUtils.generateRandomUser();
    private List<Cookie> restCookies;
    private  String token ;

    private  String  UserId;
    private  String  FirstName;
    public void register() {

        Response response = RestAssured.given()
                .baseUri("https://qacart-todo.herokuapp.com")
                .body(user)
                .header("Content-Type", "application/json")
                .when()
                .post(EndPoint.API_REGISTER_ENDPOINT)
                .then()
                .log().all()
                .extract().response();

        if(response.statusCode() != 201){
            throw new RuntimeException("wrong with request");
        }


        restCookies = response.detailedCookies().asList();
        token=response.path("access_token");
        FirstName=response.path("firstName");
        UserId=response.path("userID");


    }

    public String getToken(){

        return token;
    }
    public String getUserId(){

        return UserId;
    }
    public String getFirstName(){

        return FirstName;
    }
    public List<Cookie> getCookies(){

        return restCookies;
    }

}
