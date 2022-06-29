package com.bl.hashmap;

import java.util.Arrays;

    public class HashMap<K, T> implements IHashMap<K, T>{

        int size = 0;
        MapLinkedList[] buckets = new MapLinkedList[6];

        @Override
        public void put(K key, T value) {
            int index = Math.abs((int) key.hashCode() % buckets.length);
            if (buckets[index] == null) {
                buckets[index] = new MapLinkedList<K, T>();
            }
            size += buckets[index].add(key, value);
        }
        @Override
        public T get(K key) {
            int index = Math.abs((int) key.hashCode() % buckets.length);
            if (buckets[index] == null) {
                return null;
            }
            return (T) buckets[index].search(key);
        }

        public boolean remove(K key) {
            int index = Math.abs((int) key.hashCode() % buckets.length);
            buckets[index].remove(key);
            size--;
            return true;
        }

        public boolean isEmpty() {
            if (size == 0) {
                return true;
            }
            return false;
        }

        public int getSize() {
            return size;
        }


        @Override
        public String toString() {
            return "HashMap{" +
                    "buckets=" + Arrays.toString(buckets) +
                    '}';
        }
    }

