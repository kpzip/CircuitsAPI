package com.kpzip.circuitsapi.util;

import java.util.Iterator;

public final class IteratorUtil {

	private IteratorUtil() {}
	
	public static <T> Iterable<T> toIterable(final Iterator<T> iterator) {
		if (iterator == null) throw new IllegalArgumentException();
		return new Iterable<T>() {
			private boolean used = false;
			
			@Override
			public Iterator<T> iterator() {
	    		if (used) throw new IllegalStateException("Cannot get an iterator twice from a single use iterable!");
	    		used = true;
	    		return iterator;
	    	}
	
	    };
	}

}
