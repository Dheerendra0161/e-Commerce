package eCom.Base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import eCom.Utils.PropertiesFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	WebDriver driver;
	public Properties prop;
	public Properties dataProp;

	public Base() {
		String configPropPath = System.getProperty("user.dir") + "\\src\\main\\java\\eCom\\Config\\config.properties";
		prop = PropertiesFileReader.readProperties(configPropPath);

		String dataPropPath = System.getProperty("user.dir") + "\\src\\main\\java\\eCom\\Testdata\\testdata.properties";
		dataProp = PropertiesFileReader.readProperties(dataPropPath);

	}

	public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {
		System.out.println("#######1"+browserName);
		System.out.println("#######2"+System.getProperty(browserName));
		System.out.println("#######22"+System.getenv(browserName));
		if (System.getenv(browserName)!=null) {
			browserName=System.getProperty(browserName);
		}
		System.out.println("#######3"+System.getProperty(browserName));
		System.out.println("#######4"+browserName);
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(options);

			} else if (browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			} else if (browserName.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();

			} else if (browserName.equalsIgnoreCase("safari")) {
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();

			}
		} catch (Exception e) {
			System.out.println("Failed to initialize WebDriver: " + e.getMessage());
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));

		return driver;

	}

}
