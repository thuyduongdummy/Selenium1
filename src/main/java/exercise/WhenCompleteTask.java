package exercise;

import exercise.actions.TodoListActions;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SerenityJUnit5Extension.class)
public class WhenCompleteTask {

    @Managed
    WebDriver driver;

    @Steps
    TodoListActions todoList;

    @BeforeEach
    public void openApplication(){
        todoList.openApplications();
    }

    @Test
    public void activeTaskShouldNotShowCompletedTask(){
        // Add "Feed the cat" and "Walk the dog to the list"
todoList.addItems("Feed the cat", "Walk the dog");
        //Complete "Feed the cat"
todoList.completeItem("Feed the cat");
        //Filter by Active
todoList.filterBy("Active");
        //Check that only "Walk the dog appears"
assertThat(todoList.items()).containsExactly("Walk the dog");
    }

    @Test
    public void completedTaskShouldNotShowActiveTask(){
        // Add "Feed the cat" and "Walk the dog to the list"
        todoList.addItems("Feed the cat", "Walk the dog");
        //Complete "Feed the cat"
        todoList.completeItem("Feed the cat");
        //Filter by Completed
        todoList.filterBy("Completed");
        //Check that only "Feed the cat" appears
        assertThat(todoList.items()).containsExactly("Feed the cat");
    }


}
