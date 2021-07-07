import java.util.PriorityQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class CustomExecutorService implements SchedulerService {

  int threadCount;
  ThreadPoolExecutor executor;

  public CustomExecutorService(int threadCount) {
    this.threadCount = threadCount;
    this.executor= (ThreadPoolExecutor) Executors.newFixedThreadPool(threadCount);
  }

  @Override
  public void adhocSchedule(int taskId, long scheduleTime) {

    PriorityQueue<CustomTask>  priorityQueue = SharedResource.priorityQueue;
    CustomTask customTask = new CustomTask(taskId, scheduleTime,0, TaskType.ADHOC);
    priorityQueue.add(customTask);

  }

  @Override
  public void schedulePeriodically(int taskId, long initialDelay, long period) {
    PriorityQueue<CustomTask>  priorityQueue = SharedResource.priorityQueue;
    CustomTask customTask = new CustomTask(taskId, initialDelay,period, TaskType.PERIODIC);
    priorityQueue.add(customTask);
  }

  @Override
  public void schedulePeriodaicallyAfterJobCompletion(long initialDelay, long period) {

  }
}
