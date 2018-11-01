package com.transaction.datasource;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SetDataSourceByKey {

	String value() default "";

	//String dataSourceKey() default "";

}