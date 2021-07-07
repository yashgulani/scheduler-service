public class CustomTask implements Runnable {

  private int taskId;
  private long startTime;
  private long period;
  private TaskType taskType;

  public long getStartTime() {
    return startTime;
  }

  public long getPeriod() {
    return period;
  }

  public TaskType getTaskType() {
    return taskType;
  }

  public long getTaskId() {
    return taskId;
  }

  public CustomTask(int taskId, long startTime, long period, TaskType taskType) {
    this.taskId = taskId;
    this.startTime = startTime;
    this.period = period;
    this.taskType = taskType;
  }

  @Override
  public void run() {
    System.out.println("taskId" + this.taskId);
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // we should add to priority queue here for WAIT_PERIODIC case

  }
}
