import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("HTMLTasks", request.session().attribute("ArrayTasks"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/tasks", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      ArrayList<Task> tasks = request.session().attribute("ArrayTasks");

      if (tasks == null); {
        tasks = new ArrayList<Task>();
        request.session().attribute("ArrayTasks", tasks);
      }

      String descriptionOfTask = request.queryParams("descriptionOfTask");
      Task newTask = new Task(descriptionOfTask);
      tasks.add(newTask);

      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
