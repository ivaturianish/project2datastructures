/**
 * 
 */

/**
 * @author gaok
 *
 */

public final class ArrayBag<T> implements BagInterface<T>{

	private final T[] bag;
	private int numberOfEntries;
	private static final int DEFAULT_CAPACITY=25;
	
	/** Creates an empty bag whose initial capacity is 25. */
	public ArrayBag()
	{
		this (DEFAULT_CAPACITY);
	} // end default constructor
	
	/** Creates an empty bag having a given capacity.
    @param desiredCapacity  The integer capacity desired. */
	public ArrayBag(int desiredCapacity)
	{
		bag=(T[]) new Object[desiredCapacity];
		numberOfEntries=0;
	} // end constructor

	
	
	@Override
	public int getCurrentSize() {
		// TODO Auto-generated method stub
		return numberOfEntries; 
	}

	@Override
	public boolean isEmpty() {
		if(numberOfEntries == 0) {
		return true;
		}
		return false;
	}

	@Override
	public boolean add(T newEntry) {
		if(isEmpty()) {
			return false;
		}
		if(numberOfEntries == bag.length) {
			return false;
		}
		bag[numberOfEntries+1] = newEntry;
		return true;
	}

	@Override
	public T remove() {
		if(isEmpty()) {
			return null;
		}
		T buff = bag[numberOfEntries-1];
		bag[numberOfEntries-1] = null;
		numberOfEntries--;
		return buff;
	}

	@Override
	public boolean remove(T anEntry) {
		for(int i = 0; i<numberOfEntries; i++) {
			if(bag[i] == anEntry) {
				bag[i] = bag[numberOfEntries];
				bag[numberOfEntries-1] = null;
				numberOfEntries--;
				return true;
			}
			}
		return false;
		}

	@Override
	public void clear() {
		numberOfEntries = 0;
		for(int i = 0; i < bag.length;i++) {
			remove();
		}
		
		
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		// TODO Auto-generated method stub
		int count = 0;
		for(int i = 0; i < numberOfEntries; i++) {
			if(bag[i] == anEntry) {
				count++;
				
			}
			
		}
		return count;
	}

	@Override
	public boolean contains(T anEntry) {
		if(isEmpty()) {
			return false;
		}
		else {
			for(int i = 0; i < numberOfEntries; i++) {
				if(bag[i] == anEntry) {
					return true;
				}
			}
			return false;
		}
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		T[] temp = (T[]) new Object[numberOfEntries];
		for(int i = 0; i < temp.length;i++) {
			temp[i] = bag[i];
		}
		return temp;
	}
	
}