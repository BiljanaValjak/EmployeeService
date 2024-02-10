package mother;

import models.request.EmployeeRequestModelPOSTPUT;

public class EmployeeMother {

    public static EmployeeRequestModelPOSTPUT createBodyForEmployeePost(){
        return EmployeeRequestModelPOSTPUT.builder()
                .name("Default name")
                .salary("Default salary")
                .age("Default age")
                .build();

    }
}
