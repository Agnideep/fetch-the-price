package genericLib;

import java.io.FileInputStream;
import java.util.Properties;

public class Utility {
	
	
	
	
  public static String getPropertyValue(String path , String key) {
   String v="";

	try {
	Properties p=new Properties();
	p.load(new FileInputStream(path));
	v=p.getProperty(key);
	} catch (Exception e) {
	System.out.println("---getProperty value FAIL---");
	}

	return v;

}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////


}
