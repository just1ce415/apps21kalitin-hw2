package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList collection;

    Stack(Object[] elements) {
        collection = new ImmutableLinkedList(elements);
    }

    Stack() {
        collection = new ImmutableLinkedList();
    }

    public void push(Object e) {
        collection = collection.addLast(e);
    }

    public Object pop() {
        Object element = collection.getLast();
        collection = collection.removeLast();
        return element;
    }

    public Object peek() {
        return collection.getLast();
    }
}
