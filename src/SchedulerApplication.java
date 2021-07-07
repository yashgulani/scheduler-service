public class SchedulerApplication {

    public static void main(String[] args)
    {

      SchedulerService schedulerService = new CustomExecutorService(10);
      PollerService pollerService = new PollerService(10);
      pollerService.poll();
//      Runnable task1 = getRunableTask();
      schedulerService.adhocSchedule(1,System.currentTimeMillis() + 10000);
      schedulerService.schedulePeriodically(2,System.currentTimeMillis() + 5000,System.currentTimeMillis() + 3000);

    }
}
