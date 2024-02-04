package mother;

import models.request.EmployeeRequestModelPOST;

public class EmployeeMother {

    public static EmployeeRequestModelPOST createBodyForEmployeePost(){
        return EmployeeRequestModelPOST.builder()
                .name("Default name")
                .salary("Default salary")
                .age("Default age")
                .build();

    }
}
