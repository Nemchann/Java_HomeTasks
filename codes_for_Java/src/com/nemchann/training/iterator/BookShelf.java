package com.nemchann.training.iterator;

public class BookShelf implements IterableShelf {
    private Book[] items;
    private int count;

    public BookShelf(int capacity){
        this.items = new Book[capacity];
        this.count = 0;
    }

    public void add(Book item){
        if (count < items.length) {
            items[count++] = item;
        }
    }

    public Book get(int index){
        return items[index];
    }

    public int size(){
        return count;
    }

    @Override
    public Iterator createIterator() {
        return new ShelfIterator(this);
    }
}
