package employeeManager.common;

import org.openqa.selenium.WebDriver;

public abstract class EmployeeManager {

    public static final String INIT_DATA_URL = "http://localhost:8080/EmployeeManager/initEmployee.do";
    public static final String ALL_DATA_DELETE_URL = "http://localhost:8080/EmployeeManager/initEmployee.do?initdata=0";

    protected String browserName;
    protected WebDriver driver;
    protected String initialURL;

    public EmployeeManager(String browserName, WebDriver driver, String initialURL) {
        this.browserName = browserName;
        this.driver = driver;
        this.initialURL = initialURL;
    }

    public void beforeTestClass() {
        driver.get(INIT_DATA_URL);
    }

    public void afterTestClass() {
        if (driver != null) {
            driver.quit();
        }
    }
}
