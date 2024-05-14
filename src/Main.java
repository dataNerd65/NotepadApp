import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private TodoList todoList = new TodoList();

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Todo List");

        TextField taskInput = new TextField();
        Button addButton = new Button("Add Task");
        ListView<String> taskList = new ListView<>();

        addButton.setOnAction(e -> {
            todoList.addTask(taskInput.getText());
            taskInput.clear();
            updateTaskList(taskList);
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(taskInput, addButton, taskList);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    private void updateTaskList(ListView<String> taskList){
        taskList.getItems().clear();
        for (Task task : todoList.getTasks()){
            taskList.getItems().add(task.getDescription() + " (Completed: " + task.isCompleted() + ")");
        }
    }

}
