package com.eugenesokolov.interview;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CollectionHelperTest {

	private CollectionHelper helper;
	
	@Before
	public void setup() {
		helper = new CollectionHelper();
	}
	
	@Test
	public void testReverseList() {
		SingleLinkedList<Integer> list = new SingleLinkedList<Integer>(10);
		list.insert(11, 12, 13, 5, -3, 9);
		SingleLinkedList<Integer> reversed = helper.reverse(list);
		
		Assert.assertEquals(new Integer(9), reversed.head());
		Assert.assertEquals(new Integer(-3), reversed.tail().head());
	}
	
	 
}
