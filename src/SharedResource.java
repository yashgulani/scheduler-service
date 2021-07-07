import java.util.Comparator;
import java.util.PriorityQueue;

public class SharedResource {

  // use syncronised block to run for concurrency usecases in pushing and polling from priority queue
  public static PriorityQueue<CustomTask> priorityQueue = new PriorityQueue<CustomTask>(new CustomTaskComparator());

}

class CustomTaskComparator implements Comparator<CustomTask> {

  public int compare(CustomTask s1, CustomTask s2) {
    if (s1.getStartTime() < s2.getStartTime())
      return 1;
    else if (s1.getStartTime() > s2.getStartTime())
      return -1;
    return 0;
  }
}
  
