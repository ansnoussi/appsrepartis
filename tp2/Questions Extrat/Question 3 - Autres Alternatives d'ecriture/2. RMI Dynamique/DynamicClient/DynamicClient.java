import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
import java.lang.reflect.*;

public class DynamicClient {
	public DynamicClient(String[] args)throws Exception{
		Properties p=System.getProperties();
		String url=p.getProperty("java.rmi.server.codebase");		
		Class classClient=RMIClassLoader.loadClass(url,"ClientDistant");
		
		Constructor [] c=classClient.getConstructors();
	c[0].setAccessible(true);
	c[0].newInstance(new Object[] {args});
	}
	
	public static void main(String[] args) {
	System.setSecurityManager(new RMISecurityManager());
		try{
			DynamicClient c=new DynamicClient(args);
		}
		catch(Exception e){
			e.printStackTrace();
		}	
	}

}
