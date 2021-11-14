package com.luxoft.datastructures.queueTest;

import com.luxoft.datastructures.queue.ArrayQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueArrayTest {

    @DisplayName("test enqueue, dequeue elements and return correct size")
    @Test
    public void testEnqueueAndDequeueWorkCorrectlyAndChangeSize() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");

        assertEquals(2, arrayQueue.size());
        assertEquals("A", arrayQueue.dequeue());
        assertEquals("B", arrayQueue.dequeue());
        assertEquals(0, arrayQueue.size());
        assertTrue(arrayQueue.isEmpty());
    }

    @DisplayName("test enqueue and dequeue and elements and change size")
    @Test
    public void testEnqueueOverInitialCapacityAndDequeueWorkCorrectlyAndChangeSize() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("C");

        assertEquals(3, arrayQueue.size());
        assertEquals("A", arrayQueue.dequeue());
        assertEquals("B", arrayQueue.dequeue());
        assertEquals("C", arrayQueue.dequeue());

        assertEquals(0, arrayQueue.size());
        assertTrue(arrayQueue.isEmpty());
    }

    @DisplayName("test enqueue, peek elements and don't change size ")
    @Test
    public void testEnqueueAndPeek() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");


        assertEquals(2, arrayQueue.size());
        assertEquals("A", arrayQueue.peek());
        assertEquals("A", arrayQueue.peek());
        assertEquals(2, arrayQueue.size());
    }

    @DisplayName("test create new queue and cheek it's empty")
    @Test
    public void testIsEmptyReturnTrueOnNewQueue() {
        ArrayQueue arrayQueue = new ArrayQueue();

        assertTrue(arrayQueue.isEmpty());
    }

    @DisplayName("test return false on queue with data")
    @Test
    public void testIsEmptyReturnFalseOnQueueWithData() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");

        assertFalse(arrayQueue.isEmpty());
    }

    @DisplayName("test clear queue and check that it is empty")
    @Test
    public void testIsEmptyReturnTrueOnStackAfterClear() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");

        arrayQueue.clear();

        assertTrue(arrayQueue.isEmpty());
    }

    @DisplayName("test checked contains elements on queue with data")
    @Test
    public void testContainsReturnTrue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");

        assertTrue(arrayQueue.contains(new String("A")));
    }

    @Test
    public void testContainsReturnFalse() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");

        assertFalse(arrayQueue.contains(new String("C")));
    }

    @Test
    public void testContainsReturnFalseOnEmptyStack() {
        ArrayQueue arrayQueue = new ArrayQueue();

        assertFalse(arrayQueue.contains("C"));
    }

    @Test
    public void testThrowIllegalStateExceptionWhenDequeueOnEmptyStack() {
        ArrayQueue arrayQueue = new ArrayQueue();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            arrayQueue.dequeue();
        });
    }

    @DisplayName("test queue with data return correct toString")
    @Test
    public void testConvertQueueArrayToString() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("C");

        assertEquals("[A, B, C]", arrayQueue.toString());
    }
}

