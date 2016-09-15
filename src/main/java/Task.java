import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Task {
  private String mDescriptionOfTask;
  private boolean mCompleted;
  private LocalDateTime mCreatedAt;
  private static List<Task> instances = new ArrayList<Task>();
  private int mId;

  public Task(String descriptionOfTask) {
    mDescriptionOfTask = descriptionOfTask;
    mCompleted = false;
    mCreatedAt = LocalDateTime.now();
    instances.add(this);
    mId = instances.size();
  }

  public String getDescriptionOfTask() {
    return mDescriptionOfTask;
  }

  public boolean isCompleted() {
    return mCompleted;
  }

  public LocalDateTime getCreatedAt() {
    return mCreatedAt;
  }

  public static List<Task> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }

  public static Task find(int id) {
    return instances.get(id - 1);
  }

}
