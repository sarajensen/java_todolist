import org.junit.*;
import static org.junit.Assert.*;

public class TaskTest {
  @Test
  public void Task_instantiatesCorrectly_String() {
    Task testTask = new Task("Mow the Lawn");
    assertEquals("Mow the Lawn", testTask.getDescriptionOfTask());
  }
}
