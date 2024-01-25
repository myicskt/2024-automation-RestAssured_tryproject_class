package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	private static Properties properties;
	private String name;
	private int age;

	
	public static String getProperty(String key) {
		properties = new Properties();
		try {
			FileInputStream input = new FileInputStream("src/main/java/util/config.properties");
			properties.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return properties.getProperty(key);
	}

}
