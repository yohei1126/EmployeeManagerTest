package employeeManager.common.edit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import util.CaputureUtils;
import employeeManager.common.EmployeeManager;

public class EmployeeManagerEdit extends EmployeeManager {

    public EmployeeManagerEdit(String browserName, WebDriver driver, String initialURL) {
        super(browserName, driver, initialURL);
    }

    // 編集作業のテスト
    public void editTest() {
        editTest1st();
        editTestThird();
        editTestFinal();

        editInvalidTest_20char();
        editInvalidTest_21char();
        editInvalidTest_21char_20char();

        driver.get(initialURL);

        String filePath = CaputureUtils.getFilePath(getClass().getName(), browserName, "editTest");
        CaputureUtils.getScreenshot((TakesScreenshot) driver, filePath);
        Logger logger = Logger.getLogger(getClass());
        logger.info(filePath + "のキャプチャ内容がeditTestにて行った変更内容と合致していることを確認してください。");
    }

    private void editInvalidTest_20char() {
        driver.get(initialURL);
        driver.findElement(By.xpath("//table[@id='emptable']/tbody/tr[2]/td/a")).click();
        driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[2]/td[2]/input")).clear();
        driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[2]/td[2]/input")).sendKeys("テスト変更_X#℡1234567890＋");
        new Select(driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[3]/td[2]/select"))).selectByVisibleText("開発部1部");
        driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[4]/td[2]/input[2]")).click();
        driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[5]/td[2]/input")).click();
        driver.findElement(By.xpath("//div[@id='editpanel']/form/input[6]")).click();
        driver.switchTo().alert().accept();
        String filePath = CaputureUtils.getFilePath(getClass().getName(), browserName, "editInvalidTest_19char");
        CaputureUtils.getScreenshot((TakesScreenshot) driver, filePath);

        Logger logger = Logger.getLogger(getClass());
        logger.info(filePath + "のキャプチャ内文言が「テスト変更_X#℡1234567890＋の情報を変更しました。 」となっていることを確認してください。");
        driver.findElement(By.linkText("検索")).click();
    }

    private void editInvalidTest_21char() {
        driver.get(initialURL);
        driver.findElement(By.xpath("//table[@id='emptable']/tbody/tr[2]/td/a")).click();
        driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[2]/td[2]/input")).clear();
        driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[2]/td[2]/input")).sendKeys("テスト変更_あ#℡1234567890+1");
        new Select(driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[3]/td[2]/select"))).selectByVisibleText("開発部1部");
        driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[4]/td[2]/input[2]")).click();
        driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[5]/td[2]/input")).click();
        driver.findElement(By.xpath("//div[@id='editpanel']/form/input[6]")).click();
        driver.switchTo().alert().accept();
        String filePath = CaputureUtils.getFilePath(getClass().getName(), browserName, "editInvalidTest_20char");
        CaputureUtils.getScreenshot((TakesScreenshot) driver, filePath);

        Logger logger = Logger.getLogger(getClass());
        logger.info(filePath + "のキャプチャ内エラー文言が「・社員名は20文字以内で入力してください。 」となっていることを確認してください。");
        driver.findElement(By.linkText("一覧表示")).click();
    }

    private void editInvalidTest_21char_20char() {
        driver.get(initialURL);
        driver.findElement(By.xpath("//table[@id='emptable']/tbody/tr[2]/td/a")).click();
        driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[2]/td[2]/input")).clear();
        driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[2]/td[2]/input")).sendKeys("テスト変更_XX#℡1234567890＋");
        new Select(driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[3]/td[2]/select"))).selectByVisibleText("開発部1部");
        driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[4]/td[2]/input[2]")).click();
        driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[5]/td[2]/input")).click();
        driver.findElement(By.xpath("//div[@id='editpanel']/form/input[6]")).click();
        driver.switchTo().alert().accept();
        String filePath_20over = CaputureUtils.getFilePath(getClass().getName(), browserName, "editInvalidTest_21char_20char_1st");
        CaputureUtils.getScreenshot((TakesScreenshot) driver, filePath_20over);

        Logger logger = Logger.getLogger(getClass());
        logger.info(filePath_20over + "のキャプチャ内エラー文言が「・社員名は20文字以内で入力してください。 」となっていることを確認してください。");

        driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[2]/td[2]/input")).clear();
        driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[2]/td[2]/input")).sendKeys("テスト変更_X#℡1234567890＋");
        driver.findElement(By.xpath("//div[@id='editpanel']/form/input[6]")).click();
        driver.switchTo().alert().accept();
        String filePath_20 = CaputureUtils.getFilePath(getClass().getName(), browserName, "editInvalidTest_21char_20char_2nd");
        CaputureUtils.getScreenshot((TakesScreenshot) driver, filePath_20);

        logger.info(filePath_20 + "のキャプチャ内文言が「テスト変更_X#℡1234567890＋の情報を変更しました。 」となっていることを確認してください。");
        driver.findElement(By.linkText("検索")).click();
    }

    private void editTest1st() {
        driver.get(initialURL);
        driver.findElement(By.xpath("//table[@id='emptable']/tbody/tr/td/a")).click();
        driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[2]/td[2]/input")).clear();
        driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[2]/td[2]/input")).sendKeys("テスト変更1");
        new Select(driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[3]/td[2]/select"))).selectByVisibleText("開発部1部");
        driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[4]/td[2]/input[2]")).click();
        driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[5]/td[2]/input")).click();
        driver.findElement(By.xpath("//div[@id='editpanel']/form/input[6]")).click();
        driver.switchTo().alert().accept();
        String filePath = CaputureUtils.getFilePath(getClass().getName(), browserName, "editTest1st");
        CaputureUtils.getScreenshot((TakesScreenshot) driver, filePath);

        Logger logger = Logger.getLogger(getClass());
        logger.info(filePath + "のキャプチャ内文言が「テスト変更1の情報を変更しました。 」となっていることを確認してください。");
        driver.findElement(By.linkText("検索")).click();
    }

    private void editTestThird() {
        driver.get(initialURL);
        driver.findElement(By.xpath("//table[@id='emptable']/tbody/tr[3]/td/a")).click();
        driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[2]/td[2]/input")).clear();
        driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[2]/td[2]/input")).sendKeys("テスト変更3");
        new Select(driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[3]/td[2]/select"))).selectByVisibleText("開発部1部");
        driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[4]/td[2]/input")).click();
        driver.findElement(By.xpath("//div[@id='editpanel']/form/input[6]")).click();
        driver.switchTo().alert().accept();
        String filePath = CaputureUtils.getFilePath(getClass().getName(), browserName, "editTestThird");
        CaputureUtils.getScreenshot((TakesScreenshot) driver, filePath);

        Logger logger = Logger.getLogger(getClass());
        logger.info(filePath + "のキャプチャ内文言が「テスト変更3の情報を変更しました。 」となっていることを確認してください。");
        driver.findElement(By.linkText("検索")).click();
    }

    private void editTestFinal() {
        driver.get(initialURL);
        WebElement table = driver.findElement(By.xpath("//table[@id='emptable']/tbody"));
        String tableText = table.getText();
        int lastIndex = tableText.split("\n").length;

        WebElement element = driver.findElement(By.xpath("//table[@id='emptable']/tbody/tr[" + lastIndex + "]/td/a"));
        element.click();
        driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[2]/td[2]/input")).clear();
        driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[2]/td[2]/input")).sendKeys("テスト変更final");
        new Select(driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[3]/td[2]/select"))).selectByVisibleText("開発部1部");
        driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[4]/td[2]/input[2]")).click();
        driver.findElement(By.xpath("//div[@id='editpanel']/form/input[6]")).click();
        driver.switchTo().alert().accept();
        String filePath = CaputureUtils.getFilePath(getClass().getName(), browserName, "editTestFinal");
        CaputureUtils.getScreenshot((TakesScreenshot) driver, filePath);

        Logger logger = Logger.getLogger(getClass());
        logger.info(filePath + "のキャプチャ内文言が「テスト変更finalの情報を変更しました。 」となっていることを確認してください。");
        driver.findElement(By.linkText("検索")).click();
    }

    // 削除処理のテスト
    public void deleteTest() {
        deleteTest2nd();
    }

    private void deleteTest2nd() {
        driver.get(initialURL);
        String deleteTargetName = driver.findElement(By.xpath("//table[@id='emptable']/tbody/tr[2]/td[2]")).getText();
        driver.findElement(By.xpath("//table[@id='emptable']/tbody/tr[2]/td/a")).click();
        driver.findElement(By.xpath("//div[@id='deletepanel']/form/input")).click();
        driver.switchTo().alert().accept();
        String filePath = CaputureUtils.getFilePath(getClass().getName(), browserName, "deleteTest2nd");
        CaputureUtils.getScreenshot((TakesScreenshot) driver, filePath);

        Logger logger = Logger.getLogger(getClass());
        logger.info(filePath + "のキャプチャ内文言が「" + deleteTargetName + "の情報を削除しました。 」となっていることを確認してください。");
        driver.findElement(By.linkText("検索")).click();
    }

    // 確認メッセージのテスト
    public void confirtmTest() {
        driver.get(initialURL);
        driver.findElement(By.xpath("//table[@id='emptable']/tbody/tr[3]/td/a")).click();
        driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[2]/td[2]/input")).clear();
        driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[2]/td[2]/input")).sendKeys("テスト変更3");
        new Select(driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[3]/td[2]/select"))).selectByVisibleText("開発部1部");
        driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[4]/td[2]/input")).click();
        driver.findElement(By.xpath("//div[@id='editpanel']/form/input[6]")).click();
        Alert alert1st = driver.switchTo().alert();
        Assert.assertEquals(alert1st.getText(), "変更しますか？");
        alert1st.dismiss();
        driver.findElement(By.xpath("//div[@id='deletepanel']/form/input")).click();
        Alert alert2nd = driver.switchTo().alert();
        Assert.assertEquals(alert2nd.getText(), "削除しますか？");
        alert2nd.dismiss();
        driver.findElement(By.linkText("一覧表示")).click();
    }
}
