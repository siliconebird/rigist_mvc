package com.mvc_model.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class beanUtil {
	public static <T> T fillBean(HttpServletRequest requst,Class<T> clazz) throws Exception{
		T bean = clazz.newInstance();
		BeanUtils.populate(bean, requst.getParameterMap());
		return bean;
	}
}
