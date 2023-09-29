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
public class WhenDeletingTask {

    @Managed
    WebDriver driver;
    @Steps
    TodoListActions todoList;
    @BeforeEach
    public void openApplication() {
        todoList.openApplications();
    }

    @Test
    public void deletedItemsShouldBeDeletedFromTheList(){
        // Add "Clean the house" and "Wash dishes"
        todoList.addItems("Clean the house", "Wash dishes");

        //Delete "Clean the house"
        todoList.removeItem("Clean the house");

        //Check that only "Wash dishes" appears"
        assertThat(todoList.items()).containsExactly("Wash dishes");
    }
}
