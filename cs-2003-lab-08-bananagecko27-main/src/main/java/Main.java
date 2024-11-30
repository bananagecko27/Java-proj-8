package main.java;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/** Simulates dynamic task arrival and processing in a queue. */
public class Main {

  // queue to store the incoming tasks
  private static QueueInterface<Task> holdingQ;
  // queue of tasks to be processed
  private static TaskQueue processingQ;

  public static void main(String[] args) {
    try {
      Scanner scanInput = new Scanner(new File("lab08.txt"));
      holdingQ = new BasicQueue<Task>();
      while (scanInput.hasNextLine()) {
        Scanner scanLine = new Scanner(scanInput.nextLine());
        int id = scanLine.nextInt();
        int arrivalTime = scanLine.nextInt();
        int transactionTime = scanLine.nextInt();
        holdingQ.enqueue(new Task(id, arrivalTime, transactionTime));
      }
      scanInput.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    processingQ = new TaskQueue();
    while (!holdingQ.isEmpty()) { // while more tasks to be added
      while (!holdingQ.isEmpty() // while more tasks to be added now
          && processingQ.getTime() == holdingQ.peek().arrivalTime) {
        processingQ.add(holdingQ.dequeue());
      }
      processingQ.process();
    }
    // all task from the auxiliary queue have been sent to the taskQueue,
    // but they may not have been performed
    while (!processingQ.isComplete()) { // while not all tasks completed
      processingQ.process();
    }
    // Write out the number of tasks processed and the average wait time
    System.out.printf(
        "Number of tasks processed : %d\n Average wait time : %.2f\n",
        processingQ.getTotalTasks(), processingQ.getAvgWaitTime());
  }
}
