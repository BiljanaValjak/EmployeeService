package client;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.request.EmployeeRequestModelPOSTPUT;
import models.response.EmployeeResponseModelDELETE;
import util.Configuration;

public class EmployeeClient {
    public Response getAllEmployees(){
        return RestAssured
                .given()
                .when().log().all()
                .get(Configuration.EMPLOYEE_URL_GETALL)
                .thenReturn();
    }
    public Response getByIdlEmployees(String id){
        return RestAssured
                .given()
                .when().log().all()
                .get(Configuration.EMPLOYEE_URL_GETBYID + "/" + id)
                .thenReturn();
    }
    public Response postEmployee(EmployeeRequestModelPOSTPUT request){
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(request)
                .post(Configuration.EMPLOYEE_URL_POST)
                .thenReturn();
    }
    public Response updateEmployee(EmployeeRequestModelPOSTPUT request, String id){
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(request)
                .put(Configuration.EMPLOYEE_URL_UPDATE + "/" + id)
                .thenReturn();
    }
    public Response deleteEmployee(String id){
        return RestAssured
                .given()
                .when().log().all()
                .delete(Configuration.EMPLOYEE_URL_DELETE + "/" + id)
                .thenReturn();
    }

}
