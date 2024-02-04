package employee;

import client.EmployeeClient;
import data.EmployeeDataFactory;
import io.restassured.response.Response;
import models.request.EmployeeRequestModelPOST;
import models.response.EmployeeResponseModelPOST;
import org.junit.Test;

import static mother.EmployeeMother.createBodyForEmployeePost;
import static org.junit.Assert.assertEquals;

public class EmployeeTest {

    @Test
    public void employeeDefaultValuePost(){

        EmployeeRequestModelPOST requestBody = new EmployeeDataFactory(createBodyForEmployeePost())
                .createRequest();

        Response responsePost = new EmployeeClient()
                .postEmployee(requestBody);


        EmployeeResponseModelPOST employeeResponse = responsePost.body().as(EmployeeResponseModelPOST.class);

        assertEquals(200, responsePost.statusCode());
        assertEquals("success", employeeResponse.getStatus());
        assertEquals("Default name", employeeResponse.getData().getName());
        assertEquals("Default salary", employeeResponse.getData().getSalary());
        assertEquals("Default age", employeeResponse.getData().getAge());
        assertEquals("Successfully! Record has been added.", employeeResponse.getMessage());

    }
    @Test
    public void employeeRequestPost(){

        EmployeeRequestModelPOST requestBody = new EmployeeDataFactory(createBodyForEmployeePost())
                .setName("Biljana")
                .setSalary("20 000")
                .setAge("40")
                .createRequest();

        Response responsePost = new EmployeeClient()
                .postEmployee(requestBody);


        EmployeeResponseModelPOST employeeResponse = responsePost.body().as(EmployeeResponseModelPOST.class);

        assertEquals(200, responsePost.statusCode());
        assertEquals("success", employeeResponse.getStatus());
        assertEquals("Biljana", employeeResponse.getData().getName());
        assertEquals("20 000", employeeResponse.getData().getSalary());
        assertEquals("40", employeeResponse.getData().getAge());
        assertEquals("Successfully! Record has been added.", employeeResponse.getMessage());


    }

}
