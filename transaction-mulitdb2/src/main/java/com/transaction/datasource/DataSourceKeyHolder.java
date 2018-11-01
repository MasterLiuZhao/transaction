package com.transaction.datasource;

public class DataSourceKeyHolder {

	private static final ThreadLocal<String> dataSourceKeys = new ThreadLocal<>();

	public static String getDataSourceKey() {
		return dataSourceKeys.get();
	}

	public static void setDataSourceKey(String dataSourceKey) {
		dataSourceKeys.set(dataSourceKey);
	}

	public static void clearDataSourceKey() {
		dataSourceKeys.remove();
	}

}
