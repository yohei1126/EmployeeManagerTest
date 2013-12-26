package employeeManager.firefox.search;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import employeeManager.common.search.EmployeeManagerSearch;
import employeeManager.firefox.EmployeeManagerFirefoxDriver;

/**
 * 　Firefoxの従業員一覧画面テスト
 */
public class EmployeeManagerFirefoxSearch extends EmployeeManagerFirefoxDriver {

    private EmployeeManagerSearch employeeManagerSearch;

    @Override
    protected void setupProfile() {
        profile.setEnableNativeEvents(true);
    }

    @Override
    public void preTest() {
        super.preTest();
        employeeManagerSearch = new EmployeeManagerSearch("Firefox", getDriver(), getinitialURL());
    }

    // 遷移テスト
    @Test
    public void transitionTest() throws InterruptedException {
        employeeManagerSearch.transitionTest();
    }

    // ダウンロードテスト
    @Test
    public void downloadTest() throws InterruptedException {
        if (driver != null) {
            driver.quit();
        }

        // ダウンロードするファイルの保存先フォルダを指定　0:デスクトップ 1：ダウンロードフォルダ 2:ダウンロードに指定された最後のフォルダ
        profile.setPreference("browser.download.folderList", 0);
        // ダウンロードするファイルの保存先フォルダが指定してあればそれを使う
        profile.setPreference("browser.download.useDownloadDir", true);
        // 指定したmimeタイプは有無を言わさずダウンロードする
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream;");

        // 作成したプロファイルでFirefox(のドライバー)を起動する
        driver = new FirefoxDriver(profile);
        driver.get(getinitialURL());
        driver.findElement(By.xpath("//div[@id='downloadpanel']/form/input")).click();
        Thread.sleep(3000);
    }

    @Test
    public void exit() {
        employeeManagerSearch.afterTestClass();
    }
}
