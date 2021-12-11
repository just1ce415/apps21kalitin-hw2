package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList collection;
    Queue(Object[] elements) {
        collection = new ImmutableLinkedList(elements);
    }

    Queue() {
        collection = new ImmutableLinkedList();
    }

    public Object peek() {
        return collection.getFirst();
    }

    public Object dequeue() {
        Object element = peek();
        collection = collection.removeFirst();
        return element;
    }

    public void enqueue(Object e) {
        collection = collection.addLast(e);
    }
}
