package ua.edu.ucu.collections.immutable;

import junit.framework.TestCase;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class ImmutableArrayListTest extends TestCase {

    public void testAdd() {
        ImmutableArrayList list1 = new ImmutableArrayList();
        ImmutableArrayList result = (ImmutableArrayList) list1.add(1);
        Object[] expected = {1};
        assertArrayEquals(expected, result.toArray());
        ImmutableArrayList result2 = (ImmutableArrayList) result.add(2);
        Object[] expected2 = {1,2};
        assertArrayEquals(expected2, result2.toArray());
    }

    public void testTestAdd() {
        ImmutableArrayList list = new ImmutableArrayList(new Object[]{1,3,4});
        ImmutableArrayList result = (ImmutableArrayList) list.add(1, 2);
        assertArrayEquals(new Object[]{1,2,3,4}, result.toArray());
    }

    public void testAddAll() {
        ImmutableArrayList list = new ImmutableArrayList(new Object[]{1,2});
        ImmutableArrayList result = (ImmutableArrayList) list.addAll(new Object[]{4,5});
        assertArrayEquals(new Object[]{1,2,4,5}, result.toArray());
    }

    public void testTestAddAll() {
        ImmutableArrayList list = new ImmutableArrayList(new Object[]{1,2});
        ImmutableArrayList result = (ImmutableArrayList) list.addAll(1, new Object[]{4,5});
        assertArrayEquals(new Object[]{1,4,5,2}, result.toArray());
        ImmutableArrayList result2 = (ImmutableArrayList) list.addAll(-1, new Object[] {4,5});
        assertArrayEquals(new Object[]{4,5,1,2}, result2.toArray());
    }

    public void testGet() {
        ImmutableArrayList list = new ImmutableArrayList(new Object[]{1,2});
        assertEquals(2, list.get(1));
    }

    public void testRemove() {
        ImmutableArrayList list = new ImmutableArrayList(new Object[]{1,2,4,8});
        ImmutableArrayList result = (ImmutableArrayList) list.remove(0);
        assertArrayEquals(new Object[]{2,4,8}, result.toArray());
    }

    public void testSet() {
        ImmutableArrayList list = new ImmutableArrayList(new Object[]{1,2,4,8});
        ImmutableArrayList result = (ImmutableArrayList) list.set(0, 2);
        assertArrayEquals(new Object[]{2,2,4,8}, result.toArray());
    }

    public void testIndexOf() {
        ImmutableArrayList list = new ImmutableArrayList(new Object[]{1,2,4,8});
        assertEquals(3, list.indexOf(8));
        assertEquals(-1, list.indexOf(228));
    }

    public void testSize() {
        ImmutableArrayList list = new ImmutableArrayList(new Object[]{1,2,4,8});
        assertEquals(4, list.size());
    }

    public void testClear() {
        ImmutableArrayList list = new ImmutableArrayList(new Object[]{1,2,4,8});
        ImmutableArrayList result = (ImmutableArrayList) list.clear();
        assertArrayEquals(new Object[]{}, result.toArray());
        assertEquals(0, result.size());
    }

    public void testIsEmpty() {
        ImmutableArrayList list = new ImmutableArrayList(new Object[]{});
        assertTrue(list.isEmpty());
    }

    public void testToArray() {
        ImmutableArrayList list = new ImmutableArrayList(new Object[]{1,2,4,8});
        assertArrayEquals(new Object[]{1,2,4,8}, list.toArray());
    }
}