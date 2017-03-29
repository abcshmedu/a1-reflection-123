package edu.hm.cs.swa.demo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Tester {
	
	public static void main(String... args) throws Exception {
		int tests = 0;
		int successes = 0;
		int fails = 0;
		
		Class<?> cut = Class.forName(args[0]);
		
		Method[] methods = cut.getMethods();
		
		for (Method method : methods) {
			/*if (method.getAnnotation(org.junit.Test.class) != null) {
				tests++;
				Object ott = cut.getConstructor().newInstance();
				try {
					method.invoke(ott);
					successes++;
				} catch(InvocationTargetException e){
					fails++;
				}
			}*/
		}
		
		System.out.println("total: " + tests + " Successes: " + successes + " fails: " + fails);
	}

}
