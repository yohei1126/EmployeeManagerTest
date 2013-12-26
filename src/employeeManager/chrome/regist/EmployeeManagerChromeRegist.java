package employeeManager.chrome.regist;

import org.junit.Test;

import employeeManager.chrome.EmployeeManagerChromeDriver;
import employeeManager.common.regist.EmployeeManagerRegist;

public class EmployeeManagerChromeRegist extends EmployeeManagerChromeDriver {

    private EmployeeManagerRegist employeeManagerRegist;

    @Override
    protected void setupOptions() {
    }

    @Override
    protected void setupDriverService() {
    }

    @Override
    public void preTest() {
        super.preTest();
        employeeManagerRegist = new EmployeeManagerRegist("Chrome", getDriver(), getinitialURL());
        employeeManagerRegist.beforeTestClass();
    }

    // 登録作業のテスト
    @Test
    public void registTest() {
        employeeManagerRegist.registTest();
    }

    @Test
    public void exit() {
        employeeManagerRegist.afterTestClass();
    }
}