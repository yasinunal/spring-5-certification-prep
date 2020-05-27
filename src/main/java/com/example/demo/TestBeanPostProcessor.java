package com.example.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class TestBeanPostProcessor implements BeanPostProcessor{
    @Override
    public Object postProcessAfterInitialization(Object bean, String name)
            throws BeansException {
    	
        if("dataSource".equals(name)){
            DataSource ds =((DataSource)bean);  
            System.out.println("Driver Class Name Before : " + ds.getDriverClassName());
            if("com.mysql.jdbc.Driver".equals(ds.getDriverClassName())){
                ds.setDriverClassName("com.mysql.jdbc.Drivers");
            }
            System.out.println("Driver Class Name After : " + ds.getDriverClassName());
            return ds;
        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object arg0, String arg1)
            throws BeansException {
        return arg0;
    }
}