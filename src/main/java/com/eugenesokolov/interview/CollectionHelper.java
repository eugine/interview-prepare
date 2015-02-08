package com.eugenesokolov.interview;

public class CollectionHelper {

	public <T> SingleLinkedList<T> reverse(SingleLinkedList<T> root) {
		SingleLinkedList<T> newRoot = null;
		
		while(root != null) {
			SingleLinkedList<T> next = root.tail;
			root.tail = newRoot;
			newRoot = root;
			root = next;
		}
		return newRoot;
	}
	
}
