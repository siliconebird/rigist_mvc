package com.mvc_model.web.formatbean;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class FormatBean {
	private String username;
	private String password;
	private String repassword;
	private String email;
	private String birthday;
	private Map<String, String> errors = new HashMap<String, String>();
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	
	public boolean validate(){
		//��֤�û�������ȷ��
		if(username.trim().equals("")){
			errors.put("username", "�û�������Ϊ��");
		}else{
			if(!username.matches("[a-zA-Z]{3,9}")){
				errors.put("username", "�û�����ʽ�Ƿ�");
			}
		}
		//��֤�����Ƿ���ȷ
		if(password.trim().equals("")){
			errors.put("password", "���벻��Ϊ��");
		}else{
			if(!password.matches("\\d{3,8}")){
				errors.put("password", "�����ʽ�Ƿ�");
			}
		}
		//��֤�ظ�����
		if(!password.trim().equals(repassword)){
			errors.put("repassword", "������������벻һ��");
		}
		//��֤����
		if(email.trim().equals("")){
			errors.put("email", "����������");
		}else{
			if(!email.matches("\\b^['_a-z0-9-\\+]+(\\.['_a-z0-9-\\+]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*\\.([a-z]{2}|aero|arpa|asia|biz|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|nato|net|org|pro|tel|travel|xxx)$\\b")){
				errors.put("email", "�����ʽ����ȷ");
			}
		}
		//��֤����
		if(birthday.trim().equals("")){
			errors.put("birthday", "����������");
		}else{
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			try {
				df.parse(birthday);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				errors.put("birthday", "���ո�ʽ�Ƿ�");
			}
		}
		return errors.isEmpty();
	}
	
}
