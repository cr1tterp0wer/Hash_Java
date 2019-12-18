package com.cr1tterp0wer.Hash;

public class LinearHashTable<T> implements Hash<T>{

	private float LOAD_FACTOR = 0.5f;
	private int   capacity   = 27;
	private int   size = 0;
	private T     data[];
	
	public LinearHashTable(){
		this.data = (T[]) new Object[capacity];
	}

	@Override
	public int hash( int i ) {
		return i % capacity;
	}

	@Override
	public void insert( T value ) {
	  int index = this.hash( (int) value ) ;

	  if( this.isFull() )
		  this.resize();
	  
	  while( this.data[index] != null ) {

		  if(index >= capacity)
			index = 0;
		  else
		    index++;
	  }

	  this.data[index] = value;
	  size++;
	}

	@Override
	public T get( T value ) {
	  int index = this.hash( (int) value );

	  if( this.isFull() )
		  this.resize();
	  
	  while( this.data[index] != null ) {

		  if( this.data[index] == value )
			  return this.data[index];

		  if(index >= capacity)
			index = 0;
		  else
		    index++;
	  }

      return null;
    }

	@Override
	public boolean isFull() {
		return LOAD_FACTOR < (float)( (float)size / (float)capacity );
	}

	@Override
	public void printHash() {
		this.toString();
	}

	@Override
	public String toString() {
		String str = "";
		for( int i = 0; i < this.capacity; i++ ) {
			if( this.data[i] != null )
				str += (this.data[i]) + " ";
		}
		return str;
	}
	
	private void resize() {
		int p = nextPrime( this.capacity );
		this.capacity = p;
		T arr[] = (T[]) new Object[p];
        
		for(int i = 0; i < this.size; i++ ) {
			arr[i] = data[i];
		}
		this.data = arr;
	}
	
	private int nextPrime( int p ) {
		
		do {
		  p++;	
		}
		while( !isPrime( p ) );
		
		return p;
	}
	
	private boolean isPrime( int p ) {
		
	    if( p % 2 == 0 )
	    	return false;
	    int i = 3;	

	    while( i < p ) {
	    	if( ( p % i ) == 0 ) {
	    	  return true;	
	    	}
	    	i++;
	    }

		return false;
	}
}


