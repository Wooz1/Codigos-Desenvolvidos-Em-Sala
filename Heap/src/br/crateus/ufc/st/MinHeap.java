package br.crateus.ufc.st;

import java.util.ArrayList;
import java.util.List;

public class MinHeap<T extends Comparable<T>> {
	private List<T> array;
	private static final int MAX = 100;

	public MinHeap() {
		this.array = new ArrayList<T>();
		this.array.add(null);

	}

	public boolean isEmpty() {
		return array.size() == 0;
	}

	public int size() {
		return array.size();
	}

	private void swinUp(int pos) {
		while (pos > 1) {
			if (greaterThan(pos / 2, pos)) {
				swap(pos / 2, pos);
			}
			pos = pos / 2;
		}

	}
	public void insert(T value) {
		array.add(value);
		swinUp(array.size() - 1);
	}
	public void deleteMin() {
		
	}
	
	private void sinkDown(int pos) {
		//Contrario do swinUp basicamente;
	}
		
	private boolean greaterThan(int k, int j) {
		return (array.get(k).compareTo(array.get(j)) > 0);
	}

	private void swap(int k, int j) {
		T aux = array.get(k);
		array.set(k, array.get(j));
		array.set(j, aux);
	}

}
