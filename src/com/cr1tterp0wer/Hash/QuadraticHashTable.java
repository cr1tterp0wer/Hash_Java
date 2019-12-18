package com.cr1tterp0wer.Hash;

public class QuadraticHashTable<T> implements Hash<T>{

	private final float LOAD_FACTOR = 0.5f;
	private final int C1 = 1, C2 = 2; //CONSTANTS

	private int   capacity   = 27;
	private int   size = 0;
	private T     data[];

	public QuadraticHashTable(){
		this.data = (T[]) new Object[capacity];
	}

	@Override
	public int hash( int i ) {
		return i % capacity;
	}

	@Override
	public void insert( T value ) {
	  int index  = this.hash( (int) value ) ;

	  int probed = 0, i = 0;

	  if( this.isFull() )
		  this.resize();

	  while( probed < capacity ) {

		  if( this.data[index] == null ) {
			  this.data[index] = value;
			  return;
		  }

		  i++;
		  index = this.hash( index ) + ( ( C1 + i ) + ( C2 * i * i ) ) % capacity;
		  probed++;
	  }

	}

	@Override
	public T get( T value ) {
	  int index  = this.hash( (int) value ) ;

	  int probed = 0, i = 0;

	  if( this.isFull() )
		  this.resize();
 
	  while( probed < capacity ) {
		 if( this.data[index] != null && this.data[index] == value )
			 return this.data[index];

		 i++;
		 index = this.hash( index ) + ( ( C1 + i ) + ( C2 * i * i ) ) % capacity;
		 probed++;

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
