package samplecode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EmployeeManagerOpen {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/EmployeeManager/index.jsp");
        driver.quit();
    }
}
