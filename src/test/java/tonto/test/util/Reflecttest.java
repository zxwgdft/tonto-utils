package tonto.test.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.junit.Test;

public class Reflecttest {
	
	
	@Test
	public void test(){
		
	
		
	}
	
	
	
	
	public static class C extends B{
		
		
		
	}
	
	
	public static class B extends A<Integer>{
		
		
	}
	
	
	
	public static class A<T>{
		
		T t;
		
	}
	
}
