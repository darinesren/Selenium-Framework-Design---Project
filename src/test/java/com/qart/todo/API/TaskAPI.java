package com.qart.todo.API;

import com.qart.todo.config.EndPoint;
import com.qart.todo.objects.Task;
import com.qart.todo.utils.ConfigUtils;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TaskAPI {

    public void addTask(String token){
        Task task = new Task("JAVA",false);
       Response response=
               given().
                baseUri(ConfigUtils.getInstance().getBaseUrl())
                .header("Content-Type","application/json")
                .body(task)
                .auth().oauth2(token).
                when()
                .post(EndPoint.API_TASK_ENDPOINT)
                .then()
                .log().all()
                .extract().response();
       if(response.statusCode() != 201){
           throw  new RuntimeException("The request not valid");
       }

    }
}
