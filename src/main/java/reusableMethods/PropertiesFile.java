package reusableMethods;
import java.io.FileInputStream;
import java.util.Properties;
import org.apache.commons.lang3.StringUtils;


public class PropertiesFile {
	
	static Properties prop = new Properties();
	
	public static String  getPropertyValue(String Key) throws Exception
	{
	    String propFilepath = System.getProperty("user.dir")+"/src/test/resources/dataFile.properties";
		FileInputStream fis=new FileInputStream(propFilepath);
	    prop.load(fis);
	    String value = prop.getProperty(Key).toString();
	    
	    if(StringUtils.isEmpty(value)) {
	    	throw new Exception("Value is not specified for key: "+Key +"in properties file");
	    }
     return value;
	}
	    

}
