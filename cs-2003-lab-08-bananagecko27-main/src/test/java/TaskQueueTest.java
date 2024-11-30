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

import main.java.Task;
import main.java.TaskQueue;
import org.junit.Test;
import test.java.TUGrader.Deps;
import test.java.TUGrader.DisplayName;
import test.java.TUGrader.TestGroup;

public class TaskQueueTest {

  @Test
  @TestGroup("add")
  @DisplayName("add(Task) should start the new task immediately if the task queue is empty")
  @Deps("getDequeueTime()")
  public void testAddStartsTaskImmediatelyIfQueueIsEmpty() {
    TaskQueue Q = new TaskQueue();
    Q.add(new Task(1, 0, 1));
    assertThat(Q.getDequeueTime(), is(equalTo(1)));
  }

  @Test
  @TestGroup("add")
  @DisplayName("add(Task) should set the startTime of a task that's been started")
  public void testAddSetsTheStartTime() {
    TaskQueue Q = new TaskQueue();
    Task task = new Task(1, 0, 1);
    Q.add(task);
    assertThat(task.startTime, is(equalTo(0)));
  }

  @Test
  @TestGroup("add")
  @DisplayName("add(Task) should not start the task if another task is already being processed")
  @Deps("getDequeueTime()")
  public void testAddDoesNotStartTaskIfQueueIsNotEmpty() {
    TaskQueue Q = new TaskQueue();
    Q.add(new Task(1, 0, 6));
    Q.add(new Task(2, 0, 3));
    assertThat(Q.getDequeueTime(), is(equalTo(6)));
  }

  @Test
  @TestGroup("process")
  @DisplayName("process() should remove dequeue task if it's finished being processed")
  public void testProcessDequeuesCompletedTask() {
    TaskQueue Q = new TaskQueue();
    Q.add(new Task(1, 0, 1));
    Q.process();
    Q.process();
    assertThat(Q.isComplete(), is(true));
  }

  @Test
  @TestGroup("process")
  @DisplayName("process() should update the total number of tasks after dequeueing a task")
  public void testProcessUpdatesTotalTasks() {
    TaskQueue Q = new TaskQueue();
    Q.add(new Task(1, 0, 1));
    assertThat(Q.getTotalTasks(), is(equalTo(0)));
    Q.process();
    Q.process();
    assertThat(Q.getTotalTasks(), is(equalTo(1)));
  }

  @Test
  @TestGroup("process")
  @DisplayName("process() should set the start time of the next task")
  public void testProcessSetsStartTimeOfNextTask() {
    TaskQueue Q = new TaskQueue();
    Q.add(new Task(1, 0, 1));
    Task task = new Task(2, 0, 3);
    Q.add(task);
    Q.process();
    Q.process();
    assertThat(task.startTime, is(equalTo(1)));
  }

  @Test
  @TestGroup("process")
  @DisplayName("process() should update the totalWaitTime")
  public void testProcessUpdatesTotalWaitTime() {
    TaskQueue Q = new TaskQueue();
    Q.add(new Task(1, 0, 2));
    Q.add(new Task(2, 0, 3));
    assertThat(Q.getTotalWaitTime(), is(equalTo(0)));
    Q.process();
    Q.process();
    Q.process();
    assertThat(Q.getTotalWaitTime(), is(equalTo(2)));
  }
}
