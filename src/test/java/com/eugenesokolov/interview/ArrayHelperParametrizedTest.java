package com.eugenesokolov.interview;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ArrayHelperParametrizedTest {

	private static final int[][] MATRIX = { {1, 2, 3, 4, 5, 6}, 
												{7, 8, 9, 11, 12},
												{14, 15, 16} };
	
	private int[][] matrix;
	private int value;
	private boolean expected;
	private ArrayHelper helper;
	
	public ArrayHelperParametrizedTest(int[][] matrix, int value,boolean expected) {
		this.matrix = matrix;
		this.value = value;
		this.expected = expected;
	}
	
	@Before
	public void setup() {
		helper = new ArrayHelper();
	}
	
	@SuppressWarnings("rawtypes")
	@Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] {
				{ MATRIX, 6, true },
				{ MATRIX, 7, true },
				{ MATRIX, 8, true },
				{ MATRIX, 12, true },
				{ MATRIX, 13, false },
				{ MATRIX, 31, false },
				{ MATRIX, -2, false },
				{ MATRIX, 10, false }
		});
	}
	
	@Test
	public void testHelper() {
		boolean result = helper.isValueInMatrix(matrix, value);
		Assert.assertEquals(expected, result);
	}
	
}
