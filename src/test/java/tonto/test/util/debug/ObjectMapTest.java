package tonto.test.util.debug;


import org.junit.Test;

import com.tonto2.common.utils.debug.DefaultObjectMap;


public class ObjectMapTest {
	
	@Test
	public void testObjectMap(){
		
		
		A a = new A();
		B b = new B();
		a.b = b;
		b.a = a;
		
		DefaultObjectMap objectMap = new DefaultObjectMap(a);
		System.out.println(objectMap.toJson());
	}
	
}
