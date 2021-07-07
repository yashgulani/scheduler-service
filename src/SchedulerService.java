public interface SchedulerService {

  void adhocSchedule(int taskId, long scheduleTime);

  void schedulePeriodically(int taskId, long initialDelay, long period);

  void schedulePeriodaicallyAfterJobCompletion(long initialDelay, long period);
}
