import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;


public class TaskTest {
  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/to_do_test", null, null);
  }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String deleteTasksQuery = "DELETE FROM tasks *;";
      String deleteCategoriesQuery = "DELETE FROM categories *;";
      con.createQuery(deleteTasksQuery).executeUpdate();
      con.createQuery(deleteCategoriesQuery).executeUpdate();
    }
  }

  @Test
  public void equals_returnsTrueIfDescriptionsAretheSame() {
    Task firstTask = new Task("Mow the lawn", 1, 1);
    Task secondTask = new Task("Mow the lawn", 1, 1);
    assertTrue(firstTask.equals(secondTask));
  }

  @Test
  public void save_returnsTrueIfDescriptionsAretheSame() {
    Task myTask = new Task("Mow the lawn", 1);
    myTask.save();
    assertTrue(Task.all().get(0).equals(myTask));
  }

  @Test
  public void Task_instantiatesCorrectly_String() {
    Task testTask = new Task("Mow the lawn", 1);
    assertEquals("Mow the lawn", 1, testTask.getDescriptionOfTask());
  }

  @Test
  public void isCompleted_isFalseAfterInstantiation_false() {
    Task testTask = new Task("Mow the lawn", 1);
    assertEquals(false, testTask.isCompleted());
  }

  @Test
  public void getCreatedAt_instantiatesWithCurrentTime_today() {
    Task testTask = new Task("Mow the lawn", 1);
    assertEquals(LocalDateTime.now().getDayOfWeek(), testTask.getCreatedAt().getDayOfWeek());
  }

  @Test
  public void all_returnsAllInstancesOfTask_true() {
    Task firstTask = new Task("Mow the lawn", 1);
    Task secondTask = new Task("Return that book");
    assertEquals(true, Task.all().contains(firstTask));
    assertEquals(true, Task.all().contains(firstTask));
  }

  @Test
  public void clear_emptiesAllTasksFromArrayList_0() {
    Task testTask = new Task("Mow the lawn", 1);
    Task.clear();
    assertEquals(Task.all().size(), 0);
  }

  @Test
  public void getID_tasksInstantiateWithAnID_1() {
    Task.clear();
    Task testTask = new Task("Mow the lawn", 1);
    assertEquals(1, testTask.getId());
  }

  @Test
  public void find_returnsTaskWithSameId_secondTask() {
    Task firstTask = new Task("Mow the lawn", 1);
    Task secondTask = new Task("Buy groceries");
    assertEquals(Task.find(secondTask.getId()), secondTask);
  }

  @Test
  public void save_savesCategoryIdIntoDB_true() {
    Category myCategory = new Category("Household chores");
    myCategory.save();
    Task myTask = new Task("Mow the lawn", 1, myCategory.getId());
    myTask.save();
    Task savedTask = Task.find(myTask.getId());
    assertEquals(savedTask.getCategoryId(), myCategory.getId());
  }
}
