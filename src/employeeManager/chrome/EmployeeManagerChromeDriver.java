package employeeManager.chrome;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import employeeManager.EmployeeManagerBase;

public abstract class EmployeeManagerChromeDriver extends EmployeeManagerBase {
    protected static ChromeOptions options;
    protected static ChromeDriverService service;

    @Override
    protected void initDriver() {
        options = new ChromeOptions();
        setupOptions();

        // 作成したプロファイルでFirefox(のドライバー)を起動する
        driver = new ChromeDriver(service, options);
    }

    @BeforeClass
    public static void beforeClass2() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingChromeDriverExecutable(new File("C:\\appli\\chromedriver_win_20.0.1133.0\\chromedriver.exe")).usingAnyFreePort().build();
        service.start();
    }

    @AfterClass
    public static void createAndStopService() {
        service.stop();
    }

    abstract protected void setupOptions();

    abstract protected void setupDriverService();
}
