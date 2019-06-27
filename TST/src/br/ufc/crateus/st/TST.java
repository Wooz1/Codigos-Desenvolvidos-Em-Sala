package br.ufc.crateus.st;

public class TST<V> {
	private class Node {
		V value;
		char ch;
		Node left;
		Node middle;
		Node right;

		Node(char ch) {
			this.ch = ch;
		}
	}

	private Node root = null;

	private Node put(Node r, String key, V value, int h) {
		char ch = key.charAt(h);
		if (r == null)
			r = new Node(ch);
		if (ch < r.ch)
			r.left = put(r.left, key, value, h);
		else if (ch > r.ch)
			r.right = put(r.right, key, value, h);
		else {
			if (h == key.length() - 1) {
				r.value = value;
				return r;
			}
			r.middle = put(r.middle, key, value, h + 1);
		}
		return r;
	}

	private Node get(Node r, String key, int h) {
		if (r == null)
			return r;
		char ch = key.charAt(h);
		if (ch < r.ch)
			return get(r.left, key, h);
		else if (ch > r.ch)
			return get(r.right, key, h);
		else {
			if (h == key.length() - 1)
				return r;
			else
				return get(r.middle, key, h + 1);
		}
	}

	public void put(String key, V value) {
		root = put(root, key, value, 0);
	}

	public V get(String key) {
		Node r = get(root, key, 0);
		return r == null ? null : r.value;
	}
}
