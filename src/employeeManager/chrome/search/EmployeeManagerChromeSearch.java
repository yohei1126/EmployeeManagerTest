package employeeManager.chrome.search;

import org.junit.Test;
import org.openqa.selenium.By;

import employeeManager.chrome.EmployeeManagerChromeDriver;
import employeeManager.common.search.EmployeeManagerSearch;

public class EmployeeManagerChromeSearch extends EmployeeManagerChromeDriver {

    private EmployeeManagerSearch employeeManagerSearch;

    @Override
    protected void setupOptions() {
    }

    @Override
    protected void setupDriverService() {
    }

    @Override
    public void preTest() {
        super.preTest();
        employeeManagerSearch = new EmployeeManagerSearch("Chrome", getDriver(), getinitialURL());
    }

    // 遷移テスト
    @Test
    public void transitionTest() throws InterruptedException {
        employeeManagerSearch.transitionTest();
    }

    @Test
    public void downloadTest() throws InterruptedException {
        driver.get(getinitialURL());
        driver.findElement(By.xpath("//div[@id='downloadpanel']/form/input")).click();
        Thread.sleep(3000);
    }

    @Test
    public void exit() {
        employeeManagerSearch.afterTestClass();
    }
}
