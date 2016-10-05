package com.mvc_model.util;

import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class xmlUtil {
	private static String xmlRealPath;
	static{
		ClassLoader cl = xmlUtil.class.getClassLoader();
	       xmlRealPath = cl.getResource("users.xml").getPath();
	}
	public static Document getdoc() throws Exception{
		SAXReader reader = new SAXReader();
		 return reader.read(xmlRealPath);
	}
	public static void write2Xml(Document doc) throws Exception{
		XMLWriter writer = new XMLWriter(new FileOutputStream(xmlRealPath), OutputFormat.createPrettyPrint());
		writer.write(doc);
		writer.close();
	}
}
