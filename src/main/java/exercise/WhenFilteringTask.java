package exercise;

import exercise.actions.TodoListActions;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenFilteringTask {

    @Managed
    WebDriver driver;

    @Steps
    TodoListActions todoList;


    @BeforeEach
    public void openApplication() {
        todoList.openApplications();
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void shouldDisplayCorrectlyFilteredItems(String filterBy, List<String> todoItems, String itemToComplete, List<String> filteredItems) {

        todoList.addItems(todoItems);
        todoList.completeItem(itemToComplete);
        todoList.filterBy(filterBy);

        assertThat(todoList.items()).containsExactlyElementsOf(filteredItems);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("Active", asList("Feed the cat", "Walk the dog"), "Feed the cat", asList("Walk the dog")),
                Arguments.of("Completed", asList("Feed the cat", "Walk the dog"), "Feed the cat", asList("Feed the cat")),
                Arguments.of("All", asList("Feed the cat", "Walk the dog"), "Feed the cat", asList("Feed the cat", "Walk the dog"))
        );
    }

}
