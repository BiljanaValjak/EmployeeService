package data;

import models.request.EmployeeRequestModelPOST;

public class EmployeeDataFactory {

    private EmployeeRequestModelPOST request;

    public EmployeeDataFactory(EmployeeRequestModelPOST requestBody){
        request = requestBody;
    }
    public EmployeeDataFactory setName(String value){
        request.setName(value);
        return this;
    }
    public EmployeeDataFactory setSalary(String value){
        request.setSalary(value);
        return this;

    }
    public EmployeeDataFactory setAge(String value){
        request.setAge(value);
        return this;
    }

    public EmployeeRequestModelPOST createRequest(){
        return request;
    }
}
