package com.tonto2.common.utils.sort;

import java.util.Arrays;

import com.tonto2.common.utils.random.RandomUtil;

public class SortInspector {

	private int maxSize = 100;
	private int minSize = 20;

	private int testNum = 1000;

	public SortInspector(){};
	
	public SortInspector(int testNum){
		this.testNum = testNum;
	}
	
	
	
	/**
	 * 获取一个随机数组
	 * 
	 * @return
	 */
	private int[] getRandomArray() {
		int size = RandomUtil.getRandomInt(minSize, maxSize);
		int[] arr = new int[size];
		for (int i = 0; i < size; i++)
			arr[i] = RandomUtil.getRandomInt(size);
		return arr;
	}

	private int[][] testArray;
	private int[][] testArrayBackup;

	private void readyTest() {
		
		if(!isReady)
		{		
			testArray = new int[testNum][];
			testArrayBackup = new int[testNum][];
	
			for (int i = 0; i < testNum; i++) {
				int[] arr = getRandomArray();
				testArray[i] = arr;
				testArrayBackup[i] = Arrays.copyOf(arr, arr.length);
			}
			
			isReady = true;
			isTested = false;
		}
		
		if(isTested)
		{
			testArray = testArrayBackup;
			
			testArrayBackup = new int[testNum][];
			for (int i = 0; i < testNum; i++) {
				int[] arr = testArray[i];
				testArrayBackup[i] = Arrays.copyOf(arr, arr.length);
			}
		}
		
	}
	
	private boolean isReady = false;
	private boolean isTested = false;
	
	
	public long testSort(DescendSort sort)
	{
		readyTest();
		
		long now = System.currentTimeMillis();
		
		for(int[] arr: testArray)
			sort.sort(arr);
		
		long waste = System.currentTimeMillis() - now;
		isTested = true;
		
		validateTest();
		
		return waste;
		
	}
	

	private boolean validateTest() {
		
		boolean right = true;
		
		for (int i = 0; i < testArray.length; i++) {
			int[] arr = testArray[i];
			
			if(!validateArray(arr))
			{
				System.out.println("排序错误数组："+parseArray(arr));
				System.out.println("排序错误原数组："+parseArray(testArrayBackup[i]));		
				right = false;
			}	
		}
		
		return right;
	}

	private String parseArray(int[] arr)
	{
		StringBuilder sb = new StringBuilder();
		for(int i : arr)
			sb.append(i).append(",");
		return sb.toString();
	}
	
	private boolean validateArray(int[] arr) {

		int v = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > v) {
				return false;
			}
		}
		return true;
	}

}
