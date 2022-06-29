package com.bl.hashmap;

public interface IHashMap<K, T> {
    void put(K key, T data);
    T get(K key);
    boolean remove(K key);
    int getSize();
}

