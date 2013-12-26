package employeeManager.firefox.edit;

import org.junit.Test;

import employeeManager.common.edit.EmployeeManagerEdit;
import employeeManager.firefox.EmployeeManagerFirefoxDriver;

/**
 * Firefoxの編集画面テスト
 */
public class EmployeeManagerFirefoxEdit extends EmployeeManagerFirefoxDriver {

    private EmployeeManagerEdit employeeManagerEdit;

    @Override
    protected void setupProfile() {
        profile.setEnableNativeEvents(true);
    }

    @Override
    public void preTest() {
        super.preTest();
        employeeManagerEdit = new EmployeeManagerEdit("Firefox", getDriver(), getinitialURL());
    }

    // 編集作業のテスト
    @Test
    public void editTest() {
        employeeManagerEdit.editTest();
    }

    // 削除処理のテスト
    @Test
    public void deleteTest() {
        employeeManagerEdit.deleteTest();
    }

    // 確認メッセージのテスト
    @Test
    public void confirtmTest() {
        employeeManagerEdit.confirtmTest();
    }

    @Test
    public void exit() {
        employeeManagerEdit.afterTestClass();
    }
}
