package com.eugenesokolov.interview;

public class BinarySearchTree<T extends Comparable<T>> {
	
	private BinaryNode root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public BinarySearchTree(T value) {
		root = new BinaryNode(value);
	}
	
	public void insert(T... values) {
		for (T value: values) {
			insert(value);
		}
	}
	
	public void insert(T value) {
		BinaryNode node = new BinaryNode(value);
		if (root == null) {
			root = node;
		} else {
			insertInTree(root, node);
		}
	}
	
	public boolean constains(T value) {
		return searchNodeByValue(root, value) != null;
	}
	
	private BinaryNode searchNodeByValue(BinaryNode root, T value) {
		if (root == null) {
			return null;
		} else if (root.value == value) {
			return root;
		} else {
			return searchNodeByValue(root.value.compareTo(value) > 0 ? root.left : root.right, value);
		}
	}
	
	private void insertInTree(BinaryNode root, BinaryNode node) {
		if (root.value.compareTo(node.value) < 0) {
			if (root.right == null) {
				root.right = node;
			} else {
				insertInTree(root.right, node);
			}
		} else {
			if (root.left == null) {
				root.left = node;
			} else {
				insertInTree(root.left, node);
			}
		}
	}
	
	class BinaryNode {
		T value;
		BinaryNode left, right;
		
		BinaryNode(T element) {
			this.value = element;
			this.left = null;
			this.right = null;
		}
	}
	

}
