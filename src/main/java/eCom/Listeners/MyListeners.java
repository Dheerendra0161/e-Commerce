package eCom.Listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import eCom.Utils.ExtentReporter;
import eCom.Utils.Utilities;

public class MyListeners implements ITestListener {

	ExtentReports extentReport;
	ExtentTest extentTest;

	// ITestContext context:allows you to retrieve information about the current
	// test suite, test methods, test parameters, test groups, and other suite-level
	// attributes.
	@Override
	public void onStart(ITestContext context) {

		extentReport = ExtentReporter.generateExtentReport();

	}

	// ITestResult result: allows you to retrieve information about the status of
	// the test method (pass, fail, skip)
	@Override
	public void onTestStart(ITestResult result) {

		extentTest = extentReport.createTest(result.getName());
		extentTest.log(Status.INFO, result.getName() + " started executing");

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		extentTest.log(Status.PASS, result.getName() + " got successfully executed");

	}

	@Override
	public void onTestFailure(ITestResult result) {

		WebDriver driver = null;

		// using WebDriver driver = null; provides a flexible and defensive approach,
		// ensuring that the driver is only initialized when it is explicitly needed for
		// a specific test case.

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}

		String destinationScreenshotPath = Utilities.captureScreenshot(driver, result.getName());

		extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, result.getName() + " got failed");

	}

	@Override
	public void onTestSkipped(ITestResult result) {

		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, result.getName() + " got skipped");

	}

	@Override
	public void onFinish(ITestContext context) {

		extentReport.flush();

		String pathOfExtentReport = System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentReport.html";
		File extentReport = new File(pathOfExtentReport);

		// To open automatically a default web browser and navigate to a specified URL
		// or URI.
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
