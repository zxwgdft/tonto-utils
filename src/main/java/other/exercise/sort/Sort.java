package other.exercise.sort;

import org.junit.Test;

public class Sort {

	public static int[] selectSort(int[] arr) {
		if (arr == null)
			return null;

		int size = arr.length;

		for (int i = 0; i < size; i++) {
			int max = i;
			for (int j = i + 1; j < size; j++) {
				if (arr[j] > arr[max])
					max = j;

			}

			int v = arr[i];
			arr[i] = arr[max];
			arr[max] = v;

		}

		return arr;
	}

	/**
	 * 选择排序改进，每次循环找出最大和最小的插入最前和最后
	 * 
	 * @param arr
	 * @return
	 */
	public static int[] selectSort2(int[] arr) {
		if (arr == null)
			return null;

		int size = arr.length;
		int temp, max, min;

		for (int i = 0, j = size - 1; i < j; i++, j--) {
			max = i;
			min = i;
			for (int k = i; k <= j; k++) {
				if (arr[k] > arr[max]) {
					max = k;
					continue;
				}

				if (arr[k] < arr[min])
					min = k;

			}

			if (max == min)
				return arr;

			if (min == i) {
				temp = arr[j];
				arr[j] = arr[i];
				arr[i] = arr[max];
				arr[max] = temp;
				arr[j] = arr[min];
			} else {
				temp = arr[i];
				arr[i] = arr[max];
				arr[max] = temp;
				temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;

			}

		}

		return arr;
	}

	public static int[] maopaoSort(int[] arr) {

		if (arr == null)
			return null;

		int size = arr.length;

		for (int i = 0; i < size; i++) {

			for (int j = i + 1; j < size; j++) {

				if (arr[i] < arr[j]) {

					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;

				}
			}

		}

		return arr;

	}

	public static void quickSort(int[] arr, int start, int end) {
		if (start < end) {
			int base = arr[start];

			int i = start, j = end;

			do {
				while (arr[i] > base && i < end)
					i++;
				while (arr[j] < base && j > start)
					j--;

				if (i <= j) {
					if (i != j) {
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
					i++;
					j--;
				}

			} while (i <= j);

			if (i < end)
				quickSort(arr, i, end);
			if (j > start)
				quickSort(arr, start, j);
		}

	}

	public void printArray(int[] arr) {
		String s = "";

		for (int i : arr)
			s += i + ",";
		System.out.println(s);

	}

	@Test
	public void test() {
		int[] arr = new int[] { 1, 2, 56, 365, 5, 34, 6 };
		printArray(arr);
		selectSort2(arr);
		printArray(arr);
	}

}
