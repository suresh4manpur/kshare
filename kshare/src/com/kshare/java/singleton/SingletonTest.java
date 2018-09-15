package com.kshare.java.singleton;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SingletonTest {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, MalformedURLException {
		List<URL> urls = new ArrayList<>();
		urls.add(new URL("file:/E://singltontest1.jar"));
		CCLoader classLoader = new CCLoader(urls);
		String singletonClassName = MySinglton.class.getPackage().getName()+"."+"MySinglton";
		System.out.println("class Name : "+singletonClassName);
		Class<?> c = classLoader.loadClass(singletonClassName,false);
		System.out.println("c1 "+c.getName());

		//MySinglton.getInstance().showClassLoader();
		//Class<?> c = loader.findClass("com.concretepage.lang.Test");
/*        Object ob = c.newInstance();
        Method md = c.getMethod("showClassLoader");
        md.invoke(ob);*/
		
		MySinglton s1 =  MySinglton.getInstance();
		System.out.println("hashcode "+s1.hashCode());
		System.out.println("state "+s1.getState());
		
		MySinglton s2 =  MySinglton.getInstance();
		s2.setState(2);
		System.out.println("hashcode "+s2.hashCode());
		System.out.println("state "+s2.getState());
		
		List<URL> urls2 = new ArrayList<>();
		urls.add(new URL("file:/E://singltontest2.jar"));
		CCLoader classLoader2 = new CCLoader(urls2);
		String singletonClassName2 = MySinglton.class.getPackage().getName()+"."+"MySinglton";
		System.out.println("class Name : "+singletonClassName2);
		Class<?> c2 = classLoader2.loadClass(singletonClassName2,true);
		System.out.println("c2 "+c2.getName());
		MySinglton s3 =  MySinglton.getInstance();
		System.out.println("hashcode "+s3.hashCode());
		System.out.println("state "+s3.getState());
	}
}
