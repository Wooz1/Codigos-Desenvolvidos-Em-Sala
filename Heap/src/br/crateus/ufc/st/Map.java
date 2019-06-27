package br.crateus.ufc.st;

public interface Map<V> {
	void put(V value);
	void remove(V value);
	Iterable<V> keys();
	boolean contains(V value);
}
