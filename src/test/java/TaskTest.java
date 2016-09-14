import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;


public class TaskTest {
  @Test
  public void Task_instantiatesCorrectly_String() {
    Task testTask = new Task("Mow the Lawn");
    assertEquals("Mow the Lawn", testTask.getDescriptionOfTask());
  }

  @Test
  public void isCompleted_isFalseAfterInstantiation_false() {
    Task testTask = new Task("Mow the lawn");
    assertEquals(false, testTask.isCompleted());
  }

  @Test
  public void getCreatedAt_instantiatesWithCurrentTime_today() {
    Task testTask = new Task("Mow the lawn");
    assertEquals(LocalDateTime.now().getDayOfWeek(), testTask.getCreatedAt().getDayOfWeek());
  }

  @Test
  public void all_retrievesAllInstantiatedObjects_true() {
    Task firstTask = new Task("Mow the lawn");
    Task secondTask = new Task("Return that book");
    assertEquals(true, Task.all().contains(firstTask));
    assertEquals(true, Task.all().contains(firstTask));
  }
}
