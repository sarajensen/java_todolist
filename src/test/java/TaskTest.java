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
  public void all_returnsAllInstancesOfTask_true() {
    Task firstTask = new Task("Mow the lawn");
    Task secondTask = new Task("Return that book");
    assertEquals(true, Task.all().contains(firstTask));
    assertEquals(true, Task.all().contains(firstTask));
  }

  @Test
  public void clear_emptiesAllTasksFromArrayList_0() {
    Task testTask = new Task("Mow the lawn");
    Task.clear();
    assertEquals(Task.all().size(), 0);
  }

  @Test
  public void getID_tasksInstantiateWithAnID_1() {
    Task.clear();
    Task testTask = new Task("Mow the lawn");
    assertEquals(1, testTask.getId());
  }

  @Test
  public void find_returnsTaskWithSameId_secondTask() {
    Task firstTask = new Task("Mow the lawn");
    Task secondTask = new Task("Buy groceries");
    assertEquals(Task.find(secondTask.getId()), secondTask);
  }
}
