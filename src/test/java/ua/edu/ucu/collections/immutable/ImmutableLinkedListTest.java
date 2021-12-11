package ua.edu.ucu.collections.immutable;

import junit.framework.TestCase;
import static org.junit.Assert.assertArrayEquals;

public class ImmutableLinkedListTest extends TestCase {

    public void testCopy() {
        ImmutableLinkedList list = new ImmutableLinkedList(new Object[]{1,2,3});
        ImmutableLinkedList copy = list.copy();
        assertArrayEquals(copy.toArray(), list.toArray());
    }

    public void testAdd() {
        ImmutableLinkedList list1 = new ImmutableLinkedList(new Object[]{});
        ImmutableLinkedList list2 = (ImmutableLinkedList) list1.add(1);
        assertArrayEquals(new Object[]{1}, list2.toArray());
        ImmutableLinkedList list3 = (ImmutableLinkedList) list2.add(44);
        assertArrayEquals(new Object[]{1,44}, list3.toArray());
    }

    public void testTestAdd() {
        ImmutableLinkedList list1 = new ImmutableLinkedList();
        ImmutableLinkedList list2 = (ImmutableLinkedList) list1.add(-100, 1);
        assertArrayEquals(new Object[]{1}, list2.toArray());
        ImmutableLinkedList list3 = (ImmutableLinkedList) list2.add(0, 44);
        assertArrayEquals(new Object[]{44, 1}, list3.toArray());
        ImmutableLinkedList list4 = (ImmutableLinkedList) list3.add(1, 55);
        assertArrayEquals(new Object[]{44,55,1}, list4.toArray());
    }

    public void testAddAll() {
        ImmutableLinkedList list1 = new ImmutableLinkedList();
        ImmutableLinkedList list2 = (ImmutableLinkedList) list1.addAll(new Object[]{1,2,3});
        assertArrayEquals(new Object[]{1,2,3}, list2.toArray());
        ImmutableLinkedList list3 = (ImmutableLinkedList) list2.addAll(new Object[]{102});
        assertArrayEquals(new Object[]{1,2,3,102}, list3.toArray());
    }

    public void testTestAddAll() {
        ImmutableLinkedList list1 = new ImmutableLinkedList();
        ImmutableLinkedList list2 = (ImmutableLinkedList) list1.addAll(-100, new Object[]{1,2});
        assertArrayEquals(new Object[]{1,2}, list2.toArray());
        ImmutableLinkedList list3 = (ImmutableLinkedList) list2.addAll(0, new Object[]{44,55});
        assertArrayEquals(new Object[]{44, 55, 1, 2}, list3.toArray());
        ImmutableLinkedList list4 = (ImmutableLinkedList) list3.addAll(2, new Object[]{7});
        assertArrayEquals(new Object[]{44,55,7,1,2}, list4.toArray());
    }

    public void testGet() {
        ImmutableLinkedList list1 = new ImmutableLinkedList();
        assertNull(list1.get(1000));
        ImmutableLinkedList list2 = new ImmutableLinkedList(new Object[]{1,9,2,8});
        assertEquals(9, list2.get(1));
    }

    public void testRemove() {
        ImmutableLinkedList list1 = new ImmutableLinkedList();
        ImmutableLinkedList list2 = (ImmutableLinkedList) list1.remove(-100);
        assertArrayEquals(new Object[]{}, list2.toArray());
        ImmutableLinkedList list3 = new ImmutableLinkedList(new Object[]{1,2,3,4,5});
        ImmutableLinkedList list4 = (ImmutableLinkedList) list3.remove(0);
        assertArrayEquals(new Object[]{2,3,4,5}, list4.toArray());
        ImmutableLinkedList list5 = (ImmutableLinkedList) list4.remove(3);
        assertArrayEquals(new Object[]{2,3,4}, list5.toArray());
        ImmutableLinkedList list6 = (ImmutableLinkedList) list5.remove(1);
        assertArrayEquals(new Object[]{2,4}, list6.toArray());
    }

    public void testSet() {
        ImmutableLinkedList list1 = new ImmutableLinkedList(new Object[]{1,2,3,4,5});
        ImmutableLinkedList list2 = (ImmutableLinkedList) list1.set(2, 100);
        assertArrayEquals(new Object[]{1,2,100,4,5}, list2.toArray());
    }

    public void testIndexOf() {
        ImmutableLinkedList list1 = new ImmutableLinkedList(new Object[]{1,2,3,4,5});
        assertEquals(4, list1.indexOf(5));
    }

    public void testSize() {
        ImmutableLinkedList list1 = new ImmutableLinkedList(new Object[]{1,2,3,4,5});
        assertEquals(5, list1.size());
    }

    public void testClear() {
        ImmutableLinkedList list1 = new ImmutableLinkedList(new Object[]{1,2,3,4,5});
        ImmutableLinkedList list2 = (ImmutableLinkedList) list1.clear();
        assertArrayEquals(new Object[]{}, list2.toArray());
    }

    public void testIsEmpty() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        assertTrue(list.isEmpty());
    }

    public void testToArray() {
        ImmutableLinkedList list1 = new ImmutableLinkedList(new Object[]{1,2,3,4,5});
        assertArrayEquals(new Object[]{1,2,3,4,5}, list1.toArray());
    }

    public void testAddFirst() {
        ImmutableLinkedList list1 = new ImmutableLinkedList(new Object[]{1,2,3,4,5});
        ImmutableLinkedList list2 = list1.addFirst(0);
        assertArrayEquals(new Object[]{0,1,2,3,4,5}, list2.toArray());
    }

    public void testAddLast() {
        ImmutableLinkedList list1 = new ImmutableLinkedList(new Object[]{1,2,3,4,5});
        ImmutableLinkedList list2 = list1.addLast(0);
        assertArrayEquals(new Object[]{1,2,3,4,5,0}, list2.toArray());
    }

    public void testGetHead() {
        ImmutableLinkedList list1 = new ImmutableLinkedList(new Object[]{1,2,3,4,5});
        assertEquals(1, list1.getHead().getValue());
    }

    public void testGetTail() {
        ImmutableLinkedList list1 = new ImmutableLinkedList(new Object[]{1,2,3,4,5});
        assertEquals(5, list1.getTail().getValue());
    }

    public void testGetFirst() {
        ImmutableLinkedList list1 = new ImmutableLinkedList(new Object[]{1,2,3,4,5});
        assertEquals(1, list1.getFirst());
    }

    public void testGetLast() {
        ImmutableLinkedList list1 = new ImmutableLinkedList(new Object[]{1,2,3,4,5});
        assertEquals(5, list1.getLast());
    }

    public void testRemoveFirst() {
        ImmutableLinkedList list1 = new ImmutableLinkedList(new Object[]{1,2,3,4,5});
        ImmutableLinkedList list2 = list1.removeFirst();
        assertArrayEquals(new Object[]{2,3,4,5}, list2.toArray());
    }

    public void testRemoveLast() {
        ImmutableLinkedList list1 = new ImmutableLinkedList(new Object[]{1,2,3,4,5});
        ImmutableLinkedList list2 = list1.removeLast();
        assertArrayEquals(new Object[]{1,2,3,4}, list2.toArray());
    }
}