package main.java;

import java.util.NoSuchElementException;

/** An reference-based implementation of the Queue ADT. */
public class BasicQueue<E> implements QueueInterface<E> {

  private Node<E> tail; // the last node in the queue

  /** Constructs an empty queue. */
  public BasicQueue() {
    this.tail = null;
  }

  /**
   * Removes and returns the element at the front of this queue.
   * @return the element at the front of this queue
   * @throws NoSuchElementException if this queue is empty
   */
  public E dequeue() throws NoSuchElementException {
    if (this.isEmpty()) {
      throw new NoSuchElementException("Cannot dequeue an empty queue");
    }
    Node<E> head = this.tail.next;
    E hold = head.item;
    if (head == this.tail) {
      this.tail = null;
    } else {
      this.tail.next = head.next;
    }
    return hold;
  }

  /**
   * Adds an item at the back of this queue.
   * @param item the item to be appended to this queue
   */
  public void enqueue(E item) {
    if (this.isEmpty()) {
      this.tail = new Node<>(item, null);
      this.tail.next = this.tail;
      return;
    }
    this.tail.next = new Node<>(item, this.tail.next);
    this.tail = this.tail.next;
  }

  /**
   * Returns {@code true} if this queue has no elements.
   * @return {@code true} if this queue is empty
   */
  public boolean isEmpty() {
    return this.tail == null;
  }

  /**
   * Returns the element at the front of this queue without removing it.
   * @return the element at the front of this queue
   * @throws NoSuchElementException if this queue is empty
   */
  public E peek() throws NoSuchElementException {
    if (this.isEmpty()) {
      throw new NoSuchElementException("Cannot peek an empty queue");
    }
    return this.tail.next.item;
  }

  /**
   * A Node for the implementation of {@code Queue}. The node
   * contains only an item and a reference to the following Node.
   */
  private static class Node<E> {

    E item; // object contained in the Node
    Node<E> next; // reference to the following node

    /**
     * Constructs a node that contains the specified item and a reference to the specified
     * next node, such that this -> next.
     * @param item the item encapsulated in the node
     * @param next the successor node of this node
     */
    public Node(E item, Node<E> next) {
      this.item = item;
      this.next = next;
    }
  }
}
