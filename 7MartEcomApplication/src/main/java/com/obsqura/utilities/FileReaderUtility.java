package com.obsqura.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FileReaderUtility {
	private Properties properties;
	String path = System.getProperty("user.dir");
	final String propertyFilePath = path + "//src//main//resources//Configuration.properties";

	public FileReaderUtility() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getChromeDriverPath() {
		String driverPath = properties.getProperty("chromedriverPath");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
	}

	public String getEdgeDriverPath() {
		String driverPath = properties.getProperty("edgedriverPath");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
	}

	public String getAfterLoginUrl() {
		String url = properties.getProperty("afterloginUrl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public long getImplicitlyWait() {
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if (implicitlyWait != null)
			return Long.parseLong(implicitlyWait);
		else
			throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
	}

	public long getExplicitWait() {
		String explicitlyWait = properties.getProperty("explicitlyWait");
		if (explicitlyWait != null)
			return Long.parseLong(explicitlyWait);
		else
			throw new RuntimeException("ExplicitlyWait not specified in the Configuration.properties file.");
	}

	public long getFluentWaitTimeOut() {
		String timeOut = properties.getProperty("timeOut");
		if (timeOut != null)
			return Long.parseLong(timeOut);
		else
			throw new RuntimeException("FluentWait timeOut not specified in the Configuration.properties file.");
	}

	public long getFluentWaitPollingTime() {
		String pollingTime = properties.getProperty("pollingTime");
		if (pollingTime != null)
			return Long.parseLong(pollingTime);
		else
			throw new RuntimeException("FluentWait pollingTime not specified in the Configuration.properties file.");
	}
}
