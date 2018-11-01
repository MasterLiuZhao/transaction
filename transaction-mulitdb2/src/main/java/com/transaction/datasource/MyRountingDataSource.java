package com.transaction.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MyRountingDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		String dataSourceKey = DataSourceKeyHolder.getDataSourceKey();
		System.out.println("执行 determineCurrentLookupKey(), dataSourceKey=" + dataSourceKey);
		return dataSourceKey;
	}

}
