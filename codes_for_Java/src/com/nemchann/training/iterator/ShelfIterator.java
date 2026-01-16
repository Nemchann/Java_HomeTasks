package com.nemchann.training.iterator;

import java.util.NoSuchElementException;

public class ShelfIterator implements Iterator{
    private BookShelf shelf;
    private int position;

    public ShelfIterator(BookShelf shelf){
        this.shelf = shelf;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < shelf.size();
    }

    @Override
    public Book next() {
        if (!hasNext()){
            throw new NoSuchElementException();
        }
        Book book = shelf.get(position);
        position++;
        return book;
    }
}
