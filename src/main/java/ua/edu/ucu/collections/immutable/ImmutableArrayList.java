package ua.edu.ucu.collections.immutable;


public final class ImmutableArrayList implements ImmutableList {
    private final Object[] array;
    private final int size;

    public ImmutableArrayList(Object[] elements) {
        array = elements;
        size = elements.length;
    }

    public ImmutableArrayList() {
        array = new Object[0];
        size = 0;
    }

    @Override
    public ImmutableList add(Object e) {
        Object[] elements = new Object[size + 1];

        if (size >= 0) {
            System.arraycopy(array, 0, elements, 0, size);
        }
        elements[size] = e;
        return new ImmutableArrayList(elements);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        Object[] elements = new Object[size + 1];
        int margin = 0;

        for (int i = 0; i < size + 1; i++) {
            if (i == index) {
                elements[i] = e;
                margin = 1;
            } else {
                elements[i] = array[i - margin];
            }
        }
        return new ImmutableArrayList(elements);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        int newArrLen = c.length;
        Object[] elements = new Object[size + newArrLen];
        if (size >= 0) {
            System.arraycopy(array, 0, elements, 0, size);
        }
        if (newArrLen > 0) {
            System.arraycopy(c, 0, elements, size, newArrLen);
        }

        return new ImmutableArrayList(elements);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index < 0) {
            index = 0;
        }

        int newArrLen = c.length;
        Object[] elements = new Object[size + newArrLen];

        if (size >= 0) {
            System.arraycopy(array, 0, elements, 0, index);
        }
        if (newArrLen > 0) {
            System.arraycopy(c, 0, elements, index, newArrLen);
        }
        System.arraycopy(array, index, elements, index + newArrLen,
                size - index);

        return new ImmutableArrayList(elements);
    }

    @Override
    public Object get(int index) {
        return array[index];
    }

    @Override
    public ImmutableList remove(int index) {
        Object[] elements = new Object[size - 1];
        int margin = 0;

        for (int i = 0; i < size; i++) {
            if (i == index) {
                margin = 1;
            } else {
                elements[i - margin] = array[i];
            }
        }
        return new ImmutableArrayList(elements);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        Object[] elements = new Object[size];
        System.arraycopy(array, 0, elements, 0, size);
        elements[index] = e;

        return new ImmutableArrayList(elements);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] elements = new Object[size];
        System.arraycopy(array, 0, elements, 0, size);
        return elements;
    }
}
