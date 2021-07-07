import java.util.PriorityQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class PollerService {

  int threadCount;
  ThreadPoolExecutor executor;

  public PollerService(int threadCount) {
    this.threadCount = threadCount;
    this.executor= (ThreadPoolExecutor) Executors.newFixedThreadPool(threadCount);
  }

  void poll()  {
    PriorityQueue<CustomTask>  priorityQueue = SharedResource.priorityQueue;

    while(true) {

      while (priorityQueue.size()>0 &&  priorityQueue.peek().getStartTime() <= System.currentTimeMillis()) {
        CustomTask customTask = priorityQueue.poll();
        executor.submit(customTask);
        if(customTask.getTaskType().equals(TaskType.PERIODIC)) {
          long startTime = customTask.getStartTime() + customTask.getPeriod();

          CustomTask customTaskNew = new CustomTask((int)customTask.getTaskId(), startTime, customTask.getPeriod(), TaskType.PERIODIC);
          // f task length is not known for WAIT_PERIODIC usecase, we should add this new task to priority queue after the completion of Runnable task in CustomTask.java
          priorityQueue.add(customTaskNew);
        }
      }

    }
  }
}
