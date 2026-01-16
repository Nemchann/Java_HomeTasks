package com.nemchann.training.iterator;

import java.util.NoSuchElementException;

public class ReversedShelfIterator implements Iterator{
    private BookShelf shelf;
    private int position;

    public ReversedShelfIterator(BookShelf shelf){
        this.shelf = shelf;
        this.position = shelf.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return position >= 0;
    }

    @Override
    public Book next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        Book book = shelf.get(position);
        position--;
        return book;
    }
}
