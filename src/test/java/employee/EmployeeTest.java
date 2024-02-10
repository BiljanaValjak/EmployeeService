package employee;

import client.EmployeeClient;
import data.EmployeeDataFactory;
import io.restassured.response.Response;
import models.request.EmployeeRequestModelPOSTPUT;
import models.response.EmployeeResponseModelDELETE;
import models.response.EmployeeResponseModelGETAll;
import models.response.EmployeeResponseModelGETById;
import models.response.EmployeeResponseModelPOSTPUT;
import org.junit.Test;

import static mother.EmployeeMother.createBodyForEmployeePost;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class EmployeeTest {
    @Test
    public void getAllEmployeesTest(){
        Response getresponse = new EmployeeClient()
                .getAllEmployees();
        EmployeeResponseModelGETAll employeeResponse = getresponse.body().as(EmployeeResponseModelGETAll.class);

        assertEquals(200, getresponse.statusCode());
        assertEquals("success", employeeResponse.getStatus());
        assertFalse(employeeResponse.getData().isEmpty());
        assertEquals("Successfully! All records has been fetched.", employeeResponse.getMessage());

    }
    @Test
    public void getByIdEmployeeTest(){
        Response getResponse = new EmployeeClient()
                .getByIdlEmployees("5");
        EmployeeResponseModelGETById employeeResponse = getResponse.body().as(EmployeeResponseModelGETById.class);

        assertEquals(200, getResponse.statusCode());
        assertEquals("success", employeeResponse.getStatus());
        assertEquals("Airi Satou", employeeResponse.getData().getEmployee_name());
        assertEquals(162700, employeeResponse.getData().getEmployee_salary());
        assertEquals(33, employeeResponse.getData().getEmployee_age());
        assertEquals("Successfully! Record has been fetched.", employeeResponse.getMessage() );

    }
    @Test
    public void postEmployeeDefaultValueTest(){
        EmployeeRequestModelPOSTPUT requestBody = new EmployeeDataFactory(createBodyForEmployeePost())
                .createRequest();

        Response responsePost = new EmployeeClient()
                .postEmployee(requestBody);

        EmployeeResponseModelPOSTPUT employeeResponse = responsePost.body().as(EmployeeResponseModelPOSTPUT.class);

        assertEquals(200, responsePost.statusCode());
        assertEquals("success", employeeResponse.getStatus());
        assertEquals("Default name", employeeResponse.getData().getName());
        assertEquals("Default salary", employeeResponse.getData().getSalary());
        assertEquals("Default age", employeeResponse.getData().getAge());
        assertEquals("Successfully! Record has been added.", employeeResponse.getMessage());

    }
    @Test
    public void postEmployeeRequestTest(){
        EmployeeRequestModelPOSTPUT requestBody = new EmployeeDataFactory(createBodyForEmployeePost())
                .setName("Biljana")
                .setSalary("20 000")
                .setAge("40")
                .createRequest();

        Response responsePost = new EmployeeClient()
                .postEmployee(requestBody);

        EmployeeResponseModelPOSTPUT employeeResponse = responsePost.body().as(EmployeeResponseModelPOSTPUT.class);

        assertEquals(200, responsePost.statusCode());
        assertEquals("success", employeeResponse.getStatus());
        assertEquals("Biljana", employeeResponse.getData().getName());
        assertEquals("20 000", employeeResponse.getData().getSalary());
        assertEquals("40", employeeResponse.getData().getAge());
        assertEquals("Successfully! Record has been added.", employeeResponse.getMessage());

    }
    @Test
    public void updateEmployeeTest(){
        EmployeeRequestModelPOSTPUT requestBody = new EmployeeDataFactory(createBodyForEmployeePost())
                .setName("Zivko Petkov")
                .setSalary("15.000")
                .setAge("41")
                .createRequest();
        Response updateEmployee = new EmployeeClient()
                .updateEmployee(requestBody,"5");
        EmployeeResponseModelPOSTPUT employeeResponse = updateEmployee.body().as(EmployeeResponseModelPOSTPUT.class);

        assertEquals(200, updateEmployee.statusCode());
        assertEquals("success", employeeResponse.getStatus());
        assertEquals("Zivko Petkov", employeeResponse.getData().getName());
        assertEquals("15.000", employeeResponse.getData().getSalary());
        assertEquals("41", employeeResponse.getData().getAge());
        assertEquals("Successfully! Record has been updated.", employeeResponse.getMessage());

    }
    @Test
    public void deleteEmployeeTest(){
        String id = "5";

        Response deleteEmployee = new EmployeeClient()
                .deleteEmployee(id);

        EmployeeResponseModelDELETE employeeResponse = deleteEmployee.body().as(EmployeeResponseModelDELETE.class);

        assertEquals(200, deleteEmployee.statusCode());
        assertEquals("success", employeeResponse.getStatus());
        assertEquals(id, employeeResponse.getData());
        assertEquals("Successfully! Record has been deleted", employeeResponse.getMessage());

    }
}
