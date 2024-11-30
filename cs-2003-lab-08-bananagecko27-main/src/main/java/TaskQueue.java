package main.java;

/** Implementation of a queue that holds Tasks waiting to be processed. */
public class TaskQueue{

  // time when the task at the front of the Q needs to be removed (transaction complete)
  private int dequeueTime;

  // queue of tasks to be processed; task in front is being processed */
  private QueueInterface<Task> Q;
  // current timer of the class
  private int time;

  // total number of tasks added to the queue
  private int totalTasks;
  // total wait time of all tasks, where {@code waitTime = timeStartProcessed - timeQueued}
  private int totalWaitTime;

  /** Constructor */
  public TaskQueue() {
    this.Q = new BasicQueue<>();
    this.time = 0;
    this.dequeueTime = -1;
    this.totalTasks = 0;
    this.totalWaitTime = 0;
  }

  /**
   * Adds a task to the queue.
   * @param task the task to be added to the queue for processing.
   */
  public void add(Task task) {
    System.out.printf(
        "%2d: Task %d enqueued (transaction time = %d)\n",
        this.time, task.id, task.transactionTime);
    // TODO: implement add(Task)
    // if the new task can start immediately,
    //    update the dequeue time and
    //    set the startTime of this task to time
    //    report with System.out.printf("    Task %d started processing\n", task.id);
    //    report with System.out.printf("    Task %d (wait time = 0)\n", task.id);
    // enqueue the task
    if(isComplete()){
      task.startTime = getTime();
      dequeueTime = getTime() + task.transactionTime;
      System.out.printf("    Task %d started processing\n", task.id);
      System.out.printf("    Task %d (wait time = 0)\n", task.id);
    }

    Q.enqueue(task);
   
    //throw new UnsupportedOperationException("add(Task) not yet implemented");
  }

  /**
   * Return the current average wait time, whch is the average time that
   * a task waited between the moment it entered the queue and the
   * moment it came to the front of the queue.
   * @return the average waiting time
   */
  public double getAvgWaitTime() {
    return ((double) this.totalWaitTime) / this.totalTasks;
  }

  /** Returns the time when the current task will be dequeued. */
  public int getDequeueTime() {
    return this.dequeueTime;
  }

  /** Return the current time. */
  public int getTime() {
    return this.time;
  }

  /** Return the number of tasks added to the queue. */
  public int getTotalTasks() {
    return this.totalTasks;
  }

  /** Returns the total wait time across all tasks that have already been processed. */
  public int getTotalWaitTime() {
    return this.totalWaitTime;
  }

  /**
   * Return {@code true} if all tasks have been processed.
   * @return return {@code true} if the queue is empty
   */
  public boolean isComplete() {
    return this.Q.isEmpty();
  }

  /**
   * Processes the current queue by (a) removing any completed task from the front of the queue,
   * (b) starting a new task if the previous task was removed, (c) processing the current
   * task at the front of the queue, and (d) updating the current time.
   */
  public void process() {
    System.out.printf("%2d: ", this.time);
    if (this.Q.isEmpty()) {
      System.out.println("idle");
      this.time++;
      return;
    }
    if (this.time == this.dequeueTime) {
      System.out.printf("Task %d dequeued\n", this.Q.peek().id);
      // TODO: implement the following
      // Remove task from queue
      // Increment totalTasks
      Q.dequeue(); 
      totalTasks++;
      if (!this.Q.isEmpty()) {
        System.out.printf("    Task %d started processing\n", this.Q.peek().id);
        // TODO: implement the following
        // Set dequeueTime by peeking (but not removing) the task at the front of the queue
        // Set the startTime of this task to time
        // Compute the waitTime (int) for this task
        // Increment totalWaitTime by the waitTime
        // Report the wait time with System.out.printf("    Task %d (wait time = %d)\n",
        // this.Q.peek().id, waitTime);
        //dequeueTime = Q.peek().getDequeueTime();

        Task front = Q.peek();
        front.startTime = getTime();
        int waitTime = getTime() - front.arrivalTime;
        totalWaitTime += waitTime;
        
        //Q.dequeue(); 

        System.out.printf("    Task %d (wait time = %d)\n",this.Q.peek().id, waitTime);
        dequeueTime = getTime() + front.transactionTime;
  
        //throw new UnsupportedOperationException("process() not yet implemented");
      }
    } 
    else if (!Q.isEmpty()) {
      System.out.printf("Task %d still processing \n", this.Q.peek().id);
    }
    this.time++;
  }
}
