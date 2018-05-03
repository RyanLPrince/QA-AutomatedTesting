package com.qa.constants;

import java.io.File;
import java.io.IOException;

public class Constants {
	
	public static final String CHROME_DRIVER_LOCATION="C:\\Development\\chromedriver_win32\\chromedriver.exe"; 
	
	public static final String getProjectPath() throws IOException {
		return (new File(".").getCanonicalPath());
	}
	public static final String getTestResourcesPath() throws IOException {
		return (new File(".").getCanonicalPath()+"\\src\\test\\resources");
	}
	
}
