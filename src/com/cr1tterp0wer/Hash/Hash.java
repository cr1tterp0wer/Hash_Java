package com.cr1tterp0wer.Hash;

//
// Linear probed HashMap
// 

public interface Hash<T> {
  
	public int hash( int i );
	
	public void insert( T value );
	
	public T get( T value );
	
	public boolean isFull(); 
	
	public void printHash();
	
}