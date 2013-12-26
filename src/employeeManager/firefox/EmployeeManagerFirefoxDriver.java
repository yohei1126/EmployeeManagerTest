package employeeManager.firefox;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import employeeManager.EmployeeManagerBase;

public abstract class EmployeeManagerFirefoxDriver extends EmployeeManagerBase {

    protected static FirefoxProfile profile;

    @Override
    protected void initDriver() {
        profile = new FirefoxProfile();
        setupProfile();

        // 作成したプロファイルでFirefox(のドライバー)を起動する
        driver = new FirefoxDriver(profile);
    }

    abstract protected void setupProfile();
}
