package eCom.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports generateExtentReport() {
		
		//ExtentReports is the main reporting class responsible for creating and managing the HTML report file.
		ExtentReports extentReport = new ExtentReports();
		
		File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		
		//It enhances the visual appearance of the HTML report by providing a more modern and visually appealing layout.
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("e-Commerce Test Automation Results Report");
		sparkReporter.config().setDocumentTitle("EC Automation Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentReport.attachReporter(sparkReporter);
		
		Properties configProp = new Properties();
		File configPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\eCom\\Config\\config.properties");
		
		try {
			FileInputStream fisConfigProp = new FileInputStream(configPropFile);
			configProp.load(fisConfigProp);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		//To get all System Out:      System.getProperties().list(System.out);   
		extentReport.setSystemInfo("Application URL",configProp.getProperty("url"));
		extentReport.setSystemInfo("Browser Name",configProp.getProperty("browserName"));
		extentReport.setSystemInfo("Email",configProp.getProperty("validEmail"));
		extentReport.setSystemInfo("Password",configProp.getProperty("validPassword"));
		extentReport.setSystemInfo("Operating System",System.getProperty("os.name"));
		extentReport.setSystemInfo("Username",System.getProperty("user.name"));
		extentReport.setSystemInfo("Java Version",System.getProperty("java.version"));
		
		return extentReport;
	}

}
