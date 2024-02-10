package data;

import models.request.EmployeeRequestModelPOSTPUT;

public class EmployeeDataFactory {

    private EmployeeRequestModelPOSTPUT request;

    public EmployeeDataFactory(EmployeeRequestModelPOSTPUT requestBody){
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

    public EmployeeRequestModelPOSTPUT createRequest(){
        return request;
    }
}
