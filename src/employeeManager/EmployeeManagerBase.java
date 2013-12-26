package employeeManager;

import base.TestBase;

public abstract class EmployeeManagerBase extends TestBase {

    @Override
    protected String getinitialURL() {
        return "http://localhost:8080/EmployeeManager/";
    }
}
