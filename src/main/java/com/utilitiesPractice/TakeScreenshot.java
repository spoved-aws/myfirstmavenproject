package com.utilitiesPractice;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.Base_Practice;

public class TakeScreenshot extends Base_Practice {

	public static void takeScreenshot(String methodName) {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String pathname = System.getProperty("user.dir") + "\\Screenshots\\" + methodName + "_" + timeStamp + ".jpg";

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(pathname));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
