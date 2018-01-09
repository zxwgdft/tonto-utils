package com.tonto2.common.utils.sort;

import org.junit.Test;

public class EffectTest {
	
	@Test
	public void testSort()
	{
		
		
		SortInspector inspector = new SortInspector(1000000);
		
		long t1 = inspector.testSort(new DescendSort(){

			@Override
			public void sort(int[] arr) {
				SortUtil.selectSort(arr);				
			}		
		});
		
		long t2 = inspector.testSort(new DescendSort(){

			@Override
			public void sort(int[] arr) {
				SortUtil.quickSort(arr);				
			}		
		});
		
		
		System.out.println("快速排序2方法耗时"+t1);
		System.out.println("快速排序1方法耗时"+t2);
	}
	
}
