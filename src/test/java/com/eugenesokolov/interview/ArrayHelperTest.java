package com.eugenesokolov.interview;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ArrayHelperTest {

	private ArrayHelper helper;

	@Before
	public void setup() {
		helper = new ArrayHelper();
	}

	@Test
	public void shouldFindZeroPairWhenArrayIsEmpty() {
		int[] array = {  };

		checkNumberOfPairs(array, 0);
	}

	@Test
	public void shouldFindZeroPairWhenArrayWithOneEmpty() {
		int[] array = { 3 };

		checkNumberOfPairs(array, 0);
	}

	@Test
	public void shouldFindZeroPairWhenArrayWithSinglePair() {
		int[] array = { 4, -4 };

		checkNumberOfPairs(array, 1);
	}

	@Test
	public void shouldFindNumberOfParisWhenArrayHasPairs() {
		int[] array = { 2, -2, 3, 5, -3, 7, 1, -4, -5, -4, 1, -2 };

		checkNumberOfPairs(array, 4);
	}

	private void checkNumberOfPairs(int[] array, int expectedNumOfParis) {
		int amount = helper.getNumberOfParisSmarter(array);
		Assert.assertEquals(expectedNumOfParis, amount);
	}
	
//-------------------------------- merge -----------------
	
	@Test
	public void shouldMergeTwoSortedArrays() {
		int[] a1 = {1, 3, 5, 7, 9};
		int[] a2 = {2, 4, 6, 8, 10};
		int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		int[] result = helper.merge(a1, a2);
		
		Assert.assertArrayEquals(expected,  result);
	}

	@Test
	public void shouldMergeTwoSortedArrays2() {
		int[] a1 = {1, 3};
		int[] a2 = {6, 8, 10};
		int[] expected = {1, 3, 6, 8, 10};
		
		int[] result = helper.merge(a1, a2);
		
		Assert.assertArrayEquals(expected,  result);
	}

	//-------------------------------- find duplicate -----------------

	@Test
	public void shouldFindDuplicateNumber() {
		int[] array = {1, 2, 6, 3, 4, 5, 6, 7, 8, 9, 10};
		int expected = 6;
		
		int found = helper.findDuplicate(array);
		
		Assert.assertEquals(expected, found);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenThereIsNoDuplicates() {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		helper.findDuplicate(array);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenThereAreSeveralDuplicates() {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 7};
		
		helper.findDuplicate(array);
	}
	
	//-------------------------------- search in matrix -----------------

	// ---> moved to ArrayHelperParametrizedTest;
	
	//-------------------------------- occurances -----------------

	@Test
	public void shouldFindAllOccurances() {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 7, 3, 6, 2, -2, 0};

		checkOccurances(array, 2, 3);
	}
	
	@Test
	public void shouldFindAllOccurances2() {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 7, 3, 6, 2, -2, 0};

		checkOccurances(array, 0, 1);
	}
	
	@Test
	public void shouldFindZeroOccurances() {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 7, 3, 6, 2, -2, 0};

		checkOccurances(array, -4, 0);
	}
	
	private void checkOccurances(int[] array, int value, int expectedOccurances) {
		int found = helper.countOccurances(array, value);
		
		Assert.assertEquals(expectedOccurances, found);
	}
	
}
