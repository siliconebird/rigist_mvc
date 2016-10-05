package com.mvc_model.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.dom4j.Document;
import org.dom4j.Node;

import com.mvc_model.domain.Users;
import com.mvc_model.util.xmlUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public Users findUserByName(String username)  {
		// TODO Auto-generated method stub
		try {
			Document document;
			document = xmlUtil.getdoc();
			Node node = document.selectSingleNode("//user[@username='"+username+"']");
			if(node==null){
				return null;
			}
				String xmlBirthday = node.valueOf("@birthday");
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date birthday = df.parse(xmlBirthday);
			return  new Users(node.valueOf("@username"), node.valueOf("@password"), node.valueOf("@email"), birthday);
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} 
	}

	@Override
	public void saveUser(Users user) {
		// TODO Auto-generated method stub
		try {
			Document doc = xmlUtil.getdoc();
			doc.getRootElement().addElement("user")
								.addAttribute("username", user.getUsername())
								.addAttribute("password", user.getPassword())
								.addAttribute("email", user.getEmail())
								.addAttribute("birthday", user.getBirthday().toLocaleString());
			xmlUtil.write2Xml(doc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	
	public Users checkUser(String username, String password) {
		// TODO Auto-generated method stub
		try {
			Document document;
			document = xmlUtil.getdoc();
			Node node = document.selectSingleNode("//user[@username='"+username+"' and @password='"+password+"']");
			if(node==null){
				return null;
			}
				String xmlBirthday = node.valueOf("@birthday");
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date birthday = df.parse(xmlBirthday);
			return  new Users(node.valueOf("@username"), node.valueOf("@password"), node.valueOf("@email"), birthday);
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} 
	}

}
