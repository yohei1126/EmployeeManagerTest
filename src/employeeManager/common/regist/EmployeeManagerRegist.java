package employeeManager.common.regist;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import util.CaputureUtils;
import employeeManager.common.EmployeeManager;

public class EmployeeManagerRegist extends EmployeeManager {

    public EmployeeManagerRegist(String browserName, WebDriver driver, String initialURL) {
        super(browserName, driver, initialURL);
    }

    // 登録作業のテスト
    public void registTest() {
        registNormal();
        registAfterError();
        driver.get(initialURL);

        String filePath = CaputureUtils.getFilePath(getClass().getName(), browserName, "registTest");
        CaputureUtils.getScreenshot((TakesScreenshot) driver, filePath);
        Logger logger = Logger.getLogger(getClass());
        logger.info(filePath + "のキャプチャ内容がeditTestにて行った変更内容と合致していることを確認してください。");
    }

    private void registNormal() {
        driver.get(initialURL);
        driver.findElement(By.xpath("//div[@id='registpanel']/form/input")).click();
        driver.findElement(By.xpath("//div[@id='registpanel']/form/table/tbody/tr/td[2]/input")).clear();
        driver.findElement(By.xpath("//div[@id='registpanel']/form/table/tbody/tr/td[2]/input")).sendKeys("777777");
        driver.findElement(By.xpath("//div[@id='registpanel']/form/table/tbody/tr[2]/td[2]/input")).clear();
        driver.findElement(By.xpath("//div[@id='registpanel']/form/table/tbody/tr[2]/td[2]/input")).sendKeys("テスト777");
        driver.findElement(By.xpath("//div[@id='registpanel']/form/table/tbody/tr[4]/td[2]/input[2]")).click();
        driver.findElement(By.xpath("//div[@id='registpanel']/form/input")).click();
        driver.findElement(By.linkText("従業員検索")).click();
    }

    private void registAfterError() {
        driver.get(initialURL);
        driver.findElement(By.xpath("//div[@id='registpanel']/form/input")).click();
        driver.findElement(By.xpath("//div[@id='registpanel']/form/table/tbody/tr/td[2]/input")).clear();
        driver.findElement(By.xpath("//div[@id='registpanel']/form/table/tbody/tr/td[2]/input")).sendKeys("1");
        driver.findElement(By.xpath("//div[@id='registpanel']/form/table/tbody/tr[2]/td[2]/input")).clear();
        driver.findElement(By.xpath("//div[@id='registpanel']/form/table/tbody/tr[2]/td[2]/input")).sendKeys("aa");
        driver.findElement(By.xpath("//div[@id='registpanel']/form/input")).click();

        String filePath_1 = CaputureUtils.getFilePath(getClass().getName(), browserName, "registAfterError_1");
        CaputureUtils.getScreenshot((TakesScreenshot) driver, filePath_1);
        Logger logger = Logger.getLogger(getClass());
        logger.info(filePath_1 + "のキャプチャのエラーメッセージが「・社員番号は半角数字のみ6桁です。」となっていることを確認してください。");

        driver.findElement(By.xpath("//div[@id='registpanel']/form/table/tbody/tr/td[2]/input")).clear();
        driver.findElement(By.xpath("//div[@id='registpanel']/form/table/tbody/tr/td[2]/input")).sendKeys("8888888");
        driver.findElement(By.xpath("//div[@id='registpanel']/form/table/tbody/tr[2]/td[2]/input")).clear();
        driver.findElement(By.xpath("//div[@id='registpanel']/form/table/tbody/tr[2]/td[2]/input")).sendKeys("123456789012345678901");
        driver.findElement(By.xpath("//div[@id='registpanel']/form/input")).click();

        String filePath_2 = CaputureUtils.getFilePath(getClass().getName(), browserName, "registAfterError_2");
        CaputureUtils.getScreenshot((TakesScreenshot) driver, filePath_2);
        Logger logger_2 = Logger.getLogger(getClass());
        logger_2.info(filePath_1 + "のキャプチャのエラーメッセージが「・社員番号は半角数字のみ6桁です。・社員名は20文字以内で入力してください。」となっていることを確認してください。");

        driver.findElement(By.xpath("//div[@id='registpanel']/form/table/tbody/tr[2]/td[2]/input")).clear();
        driver.findElement(By.xpath("//div[@id='registpanel']/form/table/tbody/tr[2]/td[2]/input")).sendKeys("test8");
        driver.findElement(By.xpath("//div[@id='registpanel']/form/table/tbody/tr/td[2]/input")).clear();
        driver.findElement(By.xpath("//div[@id='registpanel']/form/table/tbody/tr/td[2]/input")).sendKeys("888888");
        driver.findElement(By.xpath("//div[@id='registpanel']/form/input")).click();
    }
}
