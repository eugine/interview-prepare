package com.eugenesokolov.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class ArrayHelper {

	/*
	 * O(n^2)
	 */
	public int getNumberOfPairs(int... array) {
		int countFound = 0;
		
		for (int i = 0; i < array.length; i++) {
			for (int j = i+1; j < array.length; j++) {
				if (array[i] + array[j] == 0) {
					countFound++;
				}
			}
		}
		return countFound;
	}
	
	/**
	 * O(n) 
	 */
	public int getNumberOfParisSmarter(int... array) {
		int countFound = 0;
		Set<Integer> set = new HashSet<>();
		for (Integer value: array) {
			if (set.contains(-value)) {
				countFound++;
			} else {
				set.add(value);
			}
		}
		return countFound;
	}
	
	/** O(N+M) **/
	public int[] merge(int[] array1, int[] array2) {
		int[] result = new int[array1.length + array2.length];
		int i1 = 0, i2 = 0;
		
		for(int i = 0; i< result.length; i++) {
			if (array1[i1] > array2[i2]) {
				result[i] = array2[i2];
				i2++;
				if (i2 >= array2.length) {
					System.arraycopy(array1, i1, result, i+1, result.length - i - 1);
					break;
				}
			} else {
				result[i] = array1[i1];
				i1++;
				if (i1 >= array1.length) {
					System.arraycopy(array2, i2, result, i+1, result.length - i - 1);
					break;
				}
			}
		}
		return result;
	}
	
	public int findDuplicate(int[] array) {
		int[] items = new int[array.length];
		System.arraycopy(array, 0, items, 0, items.length);
		
		Arrays.sort(items);
		
		int value = 0;
		boolean found = false;
		
		for(int i = 0; i < items.length - 1; i++ ) {
			if (items[i] == items[i+1]) {
				if (found) throw new IllegalArgumentException("There are more than one duplicate in the array");
				value = items[i];
				found = true;
			}
		}
		
		if (!found) throw new IllegalArgumentException("No duplicates in the array");
		return value;
	}
	
	public boolean isValueInMatrix(int[][] matrix, int value) {
		boolean found = false; 
		int row = -1;
		
		for(int i = 0; i < matrix.length; i++) {
			int lastIdx = matrix[i].length - 1;
			if (value <= matrix[i][lastIdx]) {
				row = i;
				break;
			}
		}
		if (row >= 0) {
			for (int j=0; j < matrix[row].length; j++) {
				if (value == matrix[row][j]) {
					found = true;
					break;
				}
			}
		}
		return found;
	}
	
	public int countOccurances(int[] array, int value) {
		int count = 0;
		for (int i = 0; i < array.length; i++ ){
			if (array[i] == value) count++;
		}
		return count;
	}

}
