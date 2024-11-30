package test.java;

/**
 * DO NOT DISTRIBUTE.
 *
 * This code is intended to support the education of students associated with the Tandy School of
 * Computer Science at the University of Tulsa. It is not intended for distribution and should
 * remain within private repositories that belong to Tandy faculty, students, and/or alumni.
 */
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsSame.sameInstance;

import java.util.NoSuchElementException;
import main.java.BasicQueue;
import org.junit.Test;
import test.java.TUGrader.Deps;
import test.java.TUGrader.DisplayName;
import test.java.TUGrader.TestGroup;

public class BasicQueueTest {

  @Test
  @TestGroup("default")
  @DisplayName("BasicQueue() should construct an empty queue")
  @Deps("isEmpty()")
  public void testConstructsAnEmptyQueue() {
    assertThat(new BasicQueue<>().isEmpty(), is(true));
  }

  @Test
  @TestGroup("isEmpty")
  @DisplayName("isEmpty() should return true when the queue is empty")
  public void testIsEmptyReturnsTrueWhenQueueIsEmpty() {
    assertThat(new BasicQueue<>().isEmpty(), is(true));
  }

  @Test
  @TestGroup("isEmpty")
  @DisplayName("isEmpty() should return false when the queue has elements")
  @Deps("enqueue(E)")
  public void testIsEmptyReturnsFalseWhenQueueHasElements() {
    BasicQueue<Integer> queue = new BasicQueue<>();
    queue.enqueue(10);
    assertThat(queue.isEmpty(), is(false));
  }

  @Test
  @TestGroup("dequeue")
  @DisplayName("dequeue() should remove the front element")
  @Deps({"enqueue(E)", "peek()"})
  public void testDequeueRemovesFrontElementOfQueue() {
    BasicQueue<Integer> queue = new BasicQueue<>();
    Integer e1 = 10;
    queue.enqueue(e1);
    assertThat(queue.peek(), is(sameInstance(e1)));
    Integer e2 = 20;
    queue.enqueue(e2);
    assertThat(queue.peek(), is(sameInstance(e1)));
    queue.dequeue();
    assertThat(queue.peek(), is(sameInstance(e2)));
  }

  @Test
  @TestGroup("dequeue")
  @DisplayName("dequeue() should return the front element of the queue after removing it")
  @Deps("enqueue(E)")
  public void testDequeueReturnsFrontElementOfQueue() {
    BasicQueue<Integer> queue = new BasicQueue<>();
    Integer elt = 10;
    queue.enqueue(elt);
    assertThat(queue.dequeue(), is(sameInstance(elt)));
  }

  @Test(expected = NoSuchElementException.class)
  @TestGroup("dequeue")
  @DisplayName("dequeue() should throw an exception when an empty queue is dequeued")
  public void testDequeueThrowsExceptionWhenEmpty() {
    new BasicQueue<>().dequeue();
  }

  @Test
  @TestGroup("enqueue")
  @DisplayName("enqueue(E) should append element to the back of the queue")
  @Deps("peek()")
  public void testEnqueueAppendsElementToBackOfQueue() {
    BasicQueue<Integer> queue = new BasicQueue<>();
    Integer e1 = 10;
    queue.enqueue(e1);
    assertThat(queue.peek(), is(sameInstance(e1)));
    Integer e2 = 20;
    queue.enqueue(e2);
    assertThat(queue.peek(), is(sameInstance(e1)));
  }

  @Test
  @TestGroup("peek")
  @DisplayName("peek() should return the front element of the queue")
  @Deps("enqueue(E)")
  public void testPeekReturnsFrontElementOfQueue() {
    BasicQueue<Integer> queue = new BasicQueue<>();
    Integer e1 = 10;
    queue.enqueue(e1);
    assertThat(queue.peek(), is(sameInstance(e1)));
  }

  @Test
  @TestGroup("peek")
  @DisplayName("peek() should not alter the stack")
  @Deps({"enqueue(E)"})
  public void testPeekDoesNotAlterStack() {
    BasicQueue<Integer> queue = new BasicQueue<>();
    Integer e1 = 10;
    queue.enqueue(e1);
    queue.peek();
    assertThat(queue.peek(), is(sameInstance(e1)));
  }

  @Test(expected = NoSuchElementException.class)
  @TestGroup("peek")
  @DisplayName("peek() should throw an exception when peeking an empty queue")
  public void testPeekThrowsExceptionWhenEmpty() {
    new BasicQueue<>().peek();
  }
}
