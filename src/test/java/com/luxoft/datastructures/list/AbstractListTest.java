package com.luxoft.datastructures.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractListTest {
    private List list;

    @BeforeEach
    public void before() {
        list = getList();
    }

    protected abstract List getList();

    @Test
    public void testAdd() {

        list.add("Helena");
        list.add("Anna");
        list.add("Vera");

        assertEquals(3, list.size());
        assertEquals("Helena", list.get(0));
        assertEquals("Anna", list.get(1));
        assertEquals("Vera", list.get(2));
    }

//    @Test
//    public void testAddElementsByValueAndIndex() {
//
//        list.add("Helena");
//        list.add("Anna");
//        list.add("Vera", 2);
//
//        assertEquals(3, list.size());
//        assertEquals("Helena", list.get(0));
//        assertEquals("Anna", list.get(1));
//        assertEquals("Vera", list.get(2));
//    }

    @Test
    public void testRemoveByIndex() {

        list.add("Helena");
        list.add("Anna");
        list.add("Vera");

        list.remove(0);

        assertEquals(2, list.size());
        assertEquals("Anna", list.get(0));
        assertEquals("Vera", list.get(1));
    }

    @Test
    public void testIsEmpty() {

        list.add("Helena");
        list.add("Anna");
        list.add("Vera");

        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testGetElement() {

        list.add("Helena");
        list.add("Anna");
        list.add("Vera");

        assertEquals("Anna", list.get(1));

    }

    @Test
    public void testSetElement() {

        list.add("Helena");
        list.add("Anna");
        list.add("Vera");

        list.set("Vova", 1);

        assertEquals("Vova", list.get(1));

    }

    @Test
    public void testIndexOf() {

        list.add("Helena");
        list.add("Anna");
        list.add("Vera");
        assertEquals(0, list.indexOf("Helena"));
        assertEquals(1, list.indexOf("Anna"));
        assertEquals(2, list.indexOf("Vera"));
    }

    @Test
    public void testLastIndexOf() {

        list.add("Helena");
        list.add("Anna");
        list.add("Vera");
        assertEquals(2, list.indexOf("Vera"));
    }

    @Test
    public void testContainsReturnTrue() {

        list.add("Helena");
        list.add("Anna");
        list.add("Vera");

        assertTrue(list.contains(new String("Anna")));
    }

    @Test
    public void testContainsReturnFalse() {

        list.add("Helena");
        list.add("Anna");
        list.add("Vera");

        assertFalse(list.contains("Vova"));
    }

    @Test
    public void testClear() {

        list.add("Helena");
        list.add("Anna");
        list.add("Vera");

        list.clear();
        assertEquals(0, list.size());

    }


    @Test
    public void testContainsReturnFalseOnEmptyList() {

        assertFalse(list.contains("Vova"));
    }

    @Test
    public void testThrowIndexBoundsOfOutExceptionWithLargerIndex() {

        list.add("Helena");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(2, 2);
        });
    }

    @Test
    public void testThrowIndexBoundsOfOutExceptionWithLargerIndexOnRenove() {

        list.add("Helena");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(2);
        });
    }
}

