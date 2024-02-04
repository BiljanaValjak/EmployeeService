package client;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.request.EmployeeRequestModelPOST;
import util.Configuration;

public class EmployeeClient {

    public Response postEmployee(EmployeeRequestModelPOST request){
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(request)
                .post(Configuration.EMPLOYEE_URL_POST)
                .thenReturn();

    }
}
