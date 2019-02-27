package cn.wdn.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class propertiesTest {
	static String url;
	static String name;
	static String pwd;
public static void main(String[] args) {
	Properties p = new Properties();
	InputStream is;
	String u = "LifeGame/src/sqlConfig.properties";
//	File f = new File(this.getClass().getResource("/").getPath());
//	System.out.println(ClassLoader.getSystemResourceAsStream("/"));
//	try {
//		is = new FileInputStream("sqlConfig.properties");
//		p.load(is);
//	} catch (FileNotFoundException e1) {
//		// TODO Auto-generated catch block
//		e1.printStackTrace();
//	}catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//		System.out.println(e.toString());
//	}
//	url = (String)p.get("sqlUrl");
//	name = (String)p.get("sqlUserName");
//	pwd =(String) p.get("passWord");
//	
//	System.out.println(url+name+pwd);
}
}
