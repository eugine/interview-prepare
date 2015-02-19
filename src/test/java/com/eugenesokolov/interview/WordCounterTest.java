package com.eugenesokolov.interview;


import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WordCounterTest {

	@InjectMocks
	private WordCounter counter;
	
	@Mock
	private Collection<String> words;
	
	@Test 
	public void shouldAddWord() {
		String word = "cat";

		counter.add(word);
		counter.add(word);
		
		verify(words, times(2)).add(word);
	}
	
	@Test 
	public void shouldCountObject() {
		
		int amount = counter.count("any");
		
		Assert.assertEquals(0, amount);
	}
	
	
	
}
