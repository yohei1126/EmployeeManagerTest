package employeeManager.common.search;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import util.CaputureUtils;
import employeeManager.common.EmployeeManager;

public class EmployeeManagerSearch extends EmployeeManager {

    public EmployeeManagerSearch(String browserName, WebDriver driver, String initialURL) {
        super(browserName, driver, initialURL);
    }

    // 画面遷移テスト
    public void transitionTest() throws InterruptedException {
        transitionToEditView();
        transitionToBackwardForward();
        transitionToRegistView();
    }

    private void transitionToEditView() {
        // 一覧の一番上の従業員情報をクリックした場合の遷移テスト
        selectTest1st();
        // 一覧の上から3番目の従業員情報をクリックした場合の遷移テスト
        selectTestThird();
        // 一覧の一番下の従業員情報をクリックした場合の遷移テスト
        selectTestFinal();
    }

    // 一覧の一番上の従業員情報をクリックした場合の遷移テスト
    private void selectTest1st() {
        driver.get(initialURL);
        WebElement element = driver.findElement(By.xpath("//table[@id='emptable']/tbody/tr/td/a"));
        String targetID = element.getText();
        element.click();
        Assert.assertEquals(driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr/td[2]")).getText(), targetID);
        driver.findElement(By.linkText("一覧表示")).click();
    }

    private void selectTestThird() {
        driver.get(initialURL);
        WebElement element = driver.findElement(By.xpath("//table[@id='emptable']/tbody/tr[3]/td/a"));
        String targetID = element.getText();
        element.click();
        Assert.assertEquals(driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr/td[2]")).getText(), targetID);
        driver.findElement(By.linkText("一覧表示")).click();
    }

    private void selectTestFinal() {
        driver.get(initialURL);
        WebElement table = driver.findElement(By.xpath("//table[@id='emptable']/tbody"));
        String tableText = table.getText();
        int lastIndex = tableText.split("\n").length;

        WebElement element = driver.findElement(By.xpath("//table[@id='emptable']/tbody/tr[" + lastIndex + "]/td/a"));
        String targetID = element.getText();
        element.click();
        Assert.assertEquals(driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr/td[2]")).getText(), targetID);
        driver.findElement(By.linkText("一覧表示")).click();
    }

    private void transitionToRegistView() {
        String filePath_1 = CaputureUtils.getFilePath(getClass().getName(), browserName, "transitionToRegistView");
        CaputureUtils.getScreenshot((TakesScreenshot) driver, filePath_1);
        Logger logger = Logger.getLogger(getClass());
        logger.info(filePath_1 + "のキャプチャのエラーメッセージが「・社員番号は半角数字のみ6桁です。」となっていることを確認してください。");

        driver.findElement(By.xpath("//div[@id='registpanel']/form/input")).click();
        Assert.assertEquals(driver.getTitle(), "名簿　新規登録");
        driver.findElement(By.xpath("//div[@id='searchpanel']/a")).click();

    }

    private void transitionToBackwardForward() {
        driver.findElement(By.xpath("//table[@id='emptable']/tbody/tr[4]/td/a")).click();
        driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[2]/td[2]/input")).clear();
        driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[2]/td[2]/input")).sendKeys("変更後");
        new Select(driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[3]/td[2]/select"))).selectByVisibleText("管理部");
        driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[4]/td[2]/input[2]")).click();
        driver.findElement(By.xpath("//table[@id='edittable']/tbody/tr[5]/td[2]/input")).click();
        driver.findElement(By.xpath("//div[@id='editpanel']/form/input[6]")).click();
        driver.switchTo().alert().accept();
        driver.findElement(By.linkText("検索")).click();

        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();

        Assert.assertEquals("名簿　従業員一覧", driver.getTitle());
    }

}
