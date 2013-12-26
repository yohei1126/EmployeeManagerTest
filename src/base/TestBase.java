package base;

import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public abstract class TestBase {

    protected static WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        // 設定ファイルを読み込む
        PropertyConfigurator.configure("conf/log4j.properties");
    }

    @Before
    public void preTest() {
        if (driver != null) {
            return;
        }
        initDriver();
    }

    @After
    public void postTest() {
        // driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    abstract protected void initDriver();

    abstract protected String getinitialURL();

}
