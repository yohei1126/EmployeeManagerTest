package util;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CaputureUtils {

    public static void getScreenshot(TakesScreenshot driver, String... params) {
        String filePath = getFilePath(params);
        getScreenshot(driver, filePath);
    }

    public static void getScreenshot(TakesScreenshot driver, String filePath) {
        File scrFile = driver.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(filePath));
        } catch (IOException e) {
            Logger logger = Logger.getLogger(CaputureUtils.class);
            logger.warn(e);
        }
    }

    public static String getFilePath(String... params) {
        StringBuilder builder = new StringBuilder();
        builder.append("c:\\tmp\\");
        builder.append(getYYYYMMDD());
        builder.append("\\screenshot\\");
        builder.append(getYYYYMMDD());
        for (String param : params) {
            builder.append("_");
            builder.append(param);
        }
        builder.append(".png");
        return builder.toString();
    }

    private static String getYYYYMMDD() {
        StringBuilder builder = new StringBuilder();
        Calendar calendar = Calendar.getInstance();
        builder.append(calendar.get(Calendar.YEAR));
        int month = calendar.get(Calendar.MONTH) + 1;
        if (month < 10) {
            builder.append("0");
        }
        builder.append(month);

        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        if (dayOfMonth < 10) {
            builder.append("0");
        }
        builder.append(dayOfMonth);

        return builder.toString();
    }
}
