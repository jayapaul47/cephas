package corebase.Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class PropertiesHelper {

	public static Properties prop = new Properties();
	public static FileInputStream  output = null;
	public static String PropertyValue = null;
	
	public static String getProperties(String PropertyName)
	{
		try {
			output = new FileInputStream(System.getProperty("user.dir") + "/src//main//java//corebase//Resources//config.properties");
	
			// load a properties file
			prop.load(output);

			PropertyValue = prop.getProperty(PropertyName);
			
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return PropertyValue;
	}

}
