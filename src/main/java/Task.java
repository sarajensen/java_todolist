import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Task {
  private String mDescriptionOfTask;
  private boolean mCompleted;
  private LocalDateTime mCreatedAt;
  private static List<Task> instances = new ArrayList<Task>();

  public Task(String descriptionOfTask) {
    mDescriptionOfTask = descriptionOfTask;
    mCompleted = false;
    mCreatedAt = LocalDateTime.now();
    instances.add(this);
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

}
