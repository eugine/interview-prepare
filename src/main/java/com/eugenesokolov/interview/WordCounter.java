package com.eugenesokolov.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WordCounter {

	private Map<String, Integer> counter;
	
	public WordCounter() {
		counter = new ConcurrentHashMap<String, Integer>();
	}
	
	public void add(String word) {
		int amount = 1;
		if (counter.containsKey(word)) {
			amount = counter.get(word) + 1; 
		}
		counter.put(word, amount);
	}

	public int count(String word) {
		return counter.containsKey(word) ? counter.get(word) : 0;
	}
}
