package employeeManager.firefox.regist;

import org.junit.Test;

import employeeManager.common.regist.EmployeeManagerRegist;
import employeeManager.firefox.EmployeeManagerFirefoxDriver;

/**
 * 　Firefoxの登録画面テスト
 */
public class EmployeeManagerFirefoxRegist extends EmployeeManagerFirefoxDriver {

    private EmployeeManagerRegist employeeManagerRegist;

    @Override
    protected void setupProfile() {
        profile.setEnableNativeEvents(true);
    }

    @Override
    public void preTest() {
        super.preTest();
        employeeManagerRegist = new EmployeeManagerRegist("Firefox", getDriver(), getinitialURL());
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
