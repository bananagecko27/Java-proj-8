package main.java;

public class Task {
  public int id;
  public int arrivalTime;
  public int transactionTime;
  public int startTime;

  public Task(int id, int arrivalTime, int transactionTime) {
    this.id = id;
    this.arrivalTime = arrivalTime;
    this.transactionTime = transactionTime;
    this.startTime = -1;
  }
}
