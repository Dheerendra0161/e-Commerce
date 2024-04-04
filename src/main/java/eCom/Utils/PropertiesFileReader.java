package eCom.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {
	public static Properties readProperties(String filePath) {
		Properties prop = new Properties(); //object will store the key-value pairs read from the properties file.
		FileInputStream fileInputStream = null;
		try {
			File file = new File(filePath);
			fileInputStream = new FileInputStream(file);
			prop.load(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop;
	}
}
