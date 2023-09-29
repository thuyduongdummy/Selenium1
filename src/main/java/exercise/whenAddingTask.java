package exercise;

import exercise.actions.TodoListActions;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class whenAddingTask {

    @Managed
    WebDriver driver;

    @Steps
    TodoListActions todoList;

//    public whenAddingTask(TodoListActions todoList) {
//        this.todoList = todoList;


    @BeforeEach
    public void openApplications() {
        todoList.openApplications();
    }

    @Test
    public void addingSingleTask() {
        //add Feed the cat to the list
        todoList.addItem("Feed the cat");

        //check that "Feed the cat appear in the list
        assertThat(todoList.items()).containsExactly("Feed the cat");
    }

    @Test
    public void addingMultipleTasks() {
        todoList.addItems("Feed the cat", "Walk the dog");
        assertThat(todoList.items()).containsExactly("Feed the cat", "Walk the dog");
    }

}

