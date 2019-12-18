package com.cr1tterp0wer.Hash;

public class HashProject {

	public static void main(String[] args) {
		QuadraticHashTable<Integer> h = new QuadraticHashTable<Integer>();

		h.insert(0);
		h.insert(1);
		h.insert(2);
		h.insert(3);
		h.insert(4);
		h.insert(5);
		h.insert(6);
		h.insert(7);
		h.insert(8);
		h.insert(9);
		h.insert(10);
		h.insert(31);
		h.insert(32);
		h.insert(33);
		h.insert(34);
		h.insert(35);

		
		System.out.println(h);
	}

}
