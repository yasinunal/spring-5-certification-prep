package com.example.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;

public class TestDBPostProcessor implements BeanFactoryPostProcessor, Ordered {

 @Override
 public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) 
         throws BeansException {
  System.out.println("In postProcessBeanFactory");
  
  // Getting the dataSource bean
  BeanDefinition bd = beanFactory.getBeanDefinition("dataSource");
  
  if(bd.hasPropertyValues()){
   MutablePropertyValues pvs = bd.getPropertyValues();
   
   PropertyValue[] pvArray = pvs.getPropertyValues();
   
   for (PropertyValue pv : pvArray) {
   
	   System.out.println("pv -- " + pv.getName());
    
	   // changing value for url property
    
	   if(pv.getName().equals("url")){
     
		   pvs.add(pv.getName(), "jdbc:mysql://localhost:3306/TestSchema");
    
	   }
   
   }
  } 
 }
 @Override
 public int getOrder() {
  // TODO Auto-generated method stub
  return 0;
 }
}
