package com.transaction.datasource;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

public class DataSourceSwitchHandler {

	public void doBefore(JoinPoint joinPoint) {
		//DataSourceKeyHolder.setDataSourceKey("data_source_2");

		Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
		SetDataSourceByKey setDataSourceByKeyAnnotation = method.getAnnotation(SetDataSourceByKey.class);
		if (setDataSourceByKeyAnnotation == null) {
			setDataSourceByKeyAnnotation = joinPoint.getTarget().getClass().getAnnotation(SetDataSourceByKey.class);
			if (setDataSourceByKeyAnnotation == null) {
				return;
			}
		}

		String dataSourceKey = setDataSourceByKeyAnnotation.value();
		if (StringUtils.isNotBlank(dataSourceKey)) {
			DataSourceKeyHolder.setDataSourceKey(dataSourceKey);
		}

		//System.out.println("执行 doBefore() 方法, DataSourceKey = " + DataSourceKeyHolder.getDataSourceKey());
	}

	public void doAfter(JoinPoint joinPoint) {
		DataSourceKeyHolder.clearDataSourceKey();
	}

}
