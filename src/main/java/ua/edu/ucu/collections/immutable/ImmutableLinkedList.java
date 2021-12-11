package ua.edu.ucu.collections.immutable;

public final class ImmutableLinkedList implements ImmutableList {
    private Node head;
    private Node tail;
    private int size;

    public ImmutableLinkedList(Object[] elements) {
        size = elements.length;
        if (size == 0) {
            head = null;
            tail = null;
            return;
        }
        head = new Node(null, null, elements[0]);
        tail = head;
        Node pointer = head;
        for (int i = 1; i < elements.length; i++){
            pointer.setNext(new Node(pointer, null, elements[i]));
            tail = pointer.getNext();
            pointer = pointer.getNext();
        }
    }

    public ImmutableLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public ImmutableLinkedList copy(){
        return new ImmutableLinkedList(this.toArray());
    }

    @Override
    public ImmutableList add(Object e) {
        ImmutableLinkedList copy = this.copy();
        copy.size = size + 1;
        if (copy.tail == null) {
            copy.tail = new Node(null, null, e);
            copy.head = copy.tail;
        } else {
            copy.tail.setNext(new Node(copy.tail, null, e));
            copy.tail = copy.tail.getNext();
        }
        return copy;
    }

    @Override
    public ImmutableList add(int index, Object e) {
        ImmutableLinkedList copy = this.copy();
        copy.size = size + 1;
        Node pointer = copy.head;
        if (pointer == null) {
            pointer = new Node(null, null, e);
            copy.tail = pointer;
            copy.head = copy.tail;
            return copy;
        }
        int counter = 0;
        while (counter != index) {
            pointer = pointer.getNext();
            counter++;
        }
        if (pointer.getPrevious() == null) {
            pointer.setPrevious(new Node(null, pointer, e));
            copy.head = pointer.getPrevious();
        } else {
            pointer.getPrevious().setNext(new Node(pointer.getPrevious(), pointer, e));
            pointer.setPrevious(pointer.getPrevious().getNext());
        }
        return copy;
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        ImmutableLinkedList copy = this.copy();
        ImmutableLinkedList addList = new ImmutableLinkedList(c);
        copy.size = size + addList.size;
        if (copy.tail == null) {
            return addList;
        }
        copy.tail.setNext(addList.getHead());
        copy.tail.getNext().setPrevious(copy.tail);
        copy.tail = addList.tail;

        return copy;
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        ImmutableLinkedList copy = this.copy();
        ImmutableLinkedList addList = new ImmutableLinkedList(c);
        copy.size = size + addList.size;
        Node pointer = copy.head;
        if (pointer == null) {
            return addList;
        }

        int counter = 0;
        while(counter != index) {
            pointer = pointer.getNext();
            counter++;
        }

        if (pointer.getPrevious() == null) {
            pointer.setPrevious(addList.tail);
            addList.tail.setNext(pointer);
            copy.head = addList.head;
        } else {
            pointer.getPrevious().setNext(addList.getHead());
            pointer.getPrevious().getNext().setPrevious(pointer.getPrevious());
            pointer.setPrevious(addList.getTail());
            pointer.getPrevious().setNext(pointer);
        }
        return copy;
    }

    @Override
    public Object get(int index) {
        Node pointer = head;
        if (pointer == null){
            return null;
        }

        int counter = 0;
        while (counter != index) {
            pointer = pointer.getNext();
            counter++;
        }
        return  pointer.getValue();
    }

    @Override
    public ImmutableList remove(int index) {
        ImmutableLinkedList copy = this.copy();
        Node pointer = copy.head;
        if (pointer == null) {
            return copy;
        }

        copy.size = size - 1;
        int counter = 0;
        while (counter != index) {
            pointer = pointer.getNext();
            counter++;
        }

        if (pointer.getPrevious() == null && pointer.getNext() == null) {
            copy.head = null;
            copy.tail = null;
        } else if (pointer.getPrevious() == null) {
            copy.head = pointer.getNext();
            pointer.getNext().setPrevious(null);
            pointer.setNext(null);
        } else if (pointer.getNext() == null) {
            copy.tail = pointer.getPrevious();
            pointer.getPrevious().setNext(null);
            pointer.setPrevious(null);
        } else {
            pointer.getPrevious().setNext(pointer.getNext());
            pointer.getNext().setPrevious(pointer.getPrevious());
            pointer.setPrevious(null);
            pointer.setNext(null);
        }
        return copy;
    }

    @Override
    public ImmutableList set(int index, Object e) {
        ImmutableLinkedList copy = this.copy();
        Node pointer = copy.head;
        if (pointer == null) {
            throw new IllegalArgumentException();
        }

        int counter = 0;
        while (counter != index) {
            pointer = pointer.getNext();
            counter++;
        }
        pointer.setValue(e);
        return copy;
    }

    @Override
    public int indexOf(Object e) {
        ImmutableLinkedList copy = this.copy();
        Node pointer = copy.head;
        if (pointer == null) {
            throw new IllegalArgumentException();
        }

        int index = 0;
        while (!pointer.getValue().equals(e)) {
            pointer = pointer.getNext();
            index++;
        }
        return index;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Object[] toArray() {
        Object[] elements = new Object[size];
        int index = 0;
        Node pointer = head;
        if (pointer == null) {
            return new Object[0];
        }
        while (index < size) {
            elements[index] = pointer.getValue();
            pointer = pointer.getNext();
            index++;
        }
        return elements;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return (ImmutableLinkedList) add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return (ImmutableLinkedList) add(e);
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public Object getFirst() {
        return head.getValue();
    }

    public Object getLast() {
        return tail.getValue();
    }

    public ImmutableLinkedList removeFirst() {
        return (ImmutableLinkedList) remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return (ImmutableLinkedList) remove(size-1);
    }
}
