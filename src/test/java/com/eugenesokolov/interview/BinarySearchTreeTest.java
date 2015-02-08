package com.eugenesokolov.interview;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {

	private BinarySearchTree<Integer> bts;
	
	@Before
	public void setup() {
		bts = new BinarySearchTree<>();
	}
	
	@Test
	public void shouldAddAnItem() {
		bts.insert(10);
		Assert.assertTrue(bts.constains(10));
		Assert.assertFalse(bts.constains(2));
	}
	
	@Test 
	public void shouldSearchInBigTree() {
		bts.insert(10, 1, 4, -5, -3, -2, 6, 7, 9, -4);
		
		Assert.assertTrue(bts.constains(6));
		Assert.assertTrue(bts.constains(-4));
		
		Assert.assertFalse(bts.constains(2));
		Assert.assertFalse(bts.constains(-8));
	}

	@Test 
	public void shouldSearchInStringTree() {
		BinarySearchTree<String> bts = new BinarySearchTree<>("hello");
		
		bts.insert("test", "interview", "java", "groovy");
		
		Assert.assertTrue(bts.constains("java"));
		Assert.assertFalse(bts.constains("scala"));
	}
}

