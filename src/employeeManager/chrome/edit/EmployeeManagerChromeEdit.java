package employeeManager.chrome.edit;

import org.junit.Test;

import employeeManager.chrome.EmployeeManagerChromeDriver;
import employeeManager.common.edit.EmployeeManagerEdit;

public class EmployeeManagerChromeEdit extends EmployeeManagerChromeDriver {

    private EmployeeManagerEdit employeeManagerEdit;

    @Override
    protected void setupOptions() {
    }

    @Override
    protected void setupDriverService() {
    }

    @Override
    public void preTest() {
        super.preTest();
        employeeManagerEdit = new EmployeeManagerEdit("Chrome", getDriver(), getinitialURL());
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
