package com.eugenesokolov.interview;

public class SingleLinkedList<T> {
	
	T head;
	SingleLinkedList<T> tail;

	public SingleLinkedList(T value) {
		this.head = value;
		this.tail = null;
	}
	
	public void insert(T value) {
		if (tail == null) {
			tail = new SingleLinkedList<>(value);
		} else {
			tail.insert(value);
		}
	}
	
	public T head() {
		return head;
	}
	
	public SingleLinkedList<T> tail() {
		return tail;
	}

	public void insert(T... values) {
		for (T value: values) {
			insert(value);
		}
	}
	
}
