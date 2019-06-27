package br.ufc.crateus.st;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings("unchecked")
public class SepareteChainingHashMap<K, V> implements Map<K, V> {
	private static class Node {
		Object key;
		Object value;
		Node next;

		Node(Object key, Object value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	private Node[] table;

	private int size = 0;

	public SepareteChainingHashMap(double d) {
		this.table = new Node[(int) d];
	}

	public SepareteChainingHashMap() {
		this(97);
	}

	private int hash(K key) {
		return (key.hashCode() & 0x7fffffff) % table.length;
	}

	private Node getNode(K key) {
		int i = hash(key);
		for (Node n = table[i]; n != null; n = n.next)
			if (key.equals(n.key))
				return n;
		return null;
	}

	@Override
	public void put(K key, V value) {
		Node n = getNode(key);
		if (n == null) {
			int i = hash(key);
			table[i] = new Node(key, value, table[i]);
			size++;
			if (this.size / table.length == 8) {
				resize(table.length * 2);
			}
		} else {
			n.value = value;
		}
	}

	private void resize(int newLength) {
		SepareteChainingHashMap<K, V> tmp = new SepareteChainingHashMap<K, V>(newLength);
		for (int i = 0; i < table.length; i++) {
			for (Node n = table[i]; n != null; n = n.next)
				tmp.put((K) n.key, (V) n.value);
		}
		table = tmp.table;
	}
	@Override
	public void remove(K key) {
		int i = hash(key);
		Node head = new Node(null, null, table[i]);
		for (Node n = head; n.next != null; n = n.next) {
			if (key.equals(n.next.key)) {
				n.next = n.next.next;
				size--;
				if (this.size / table.length == 4)
					resize(table.length / 2);
				break;
			}
		}
		table[i] = head.next;
	}

	@Override
	public V get(K key) {
		Node n = getNode(key);
		return n == null ? null : (V) n.value;
	}
	
	@Override
	public Iterable<K> keys() {
		Queue<K> queue = new LinkedList<K>();
		for (int i = 0; i < table.length; i++) {
			Node tmp = table[i];
			while (tmp != null) {
				queue.add((K) tmp.key);
				tmp = tmp.next;
			}
		}
		return queue;
	}

	@Override
	public boolean contains(K key) {
		return get(key) == key;
	}

	public int[] getLength() {
		int menor = 1000000000;
		int maior = 0;
		int count = 0;
		for (int i = 0; i < table.length; i++) {
			Node tmp = table[i];
			count = 0;
			while (tmp != null) {
				tmp = tmp.next;
				count++;
			}
			if(count<= menor) {
				menor = count;
			}
			if(count>=maior)
				maior = count;
		}

		return new int[] {maior,menor};
	}
}