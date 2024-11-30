package main.java;

import java.util.NoSuchElementException;

public interface QueueInterface<E> {

  /**
   * Removes and returns the element at the front of this queue.
   * @return the element at the front of this queue
   * @throws NoSuchElementException if this queue is empty
   */
  public E dequeue() throws NoSuchElementException;

  /**
   * Adds an item at the back of this queue.
   * @param item the item to be appended to this queue
   */
  public void enqueue(E item);

  /**
   * Returns {@code true} if this queue has no elements.
   * @return {@code true} if this queue is empty
   */
  public boolean isEmpty();

  /**
   * Returns the element at the front of this queue without removing it.
   * @return the element at the front of this queue
   * @throws NoSuchElementException if this queue is empty
   */
  public E peek() throws NoSuchElementException;
}
