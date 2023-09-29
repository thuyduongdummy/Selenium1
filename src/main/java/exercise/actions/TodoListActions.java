package exercise.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

import java.util.Arrays;
import java.util.List;

public class TodoListActions extends UIInteractionSteps {

    @Step(value = "Open the todoMVC")
    public void openApplications() {
        openUrl("https://todomvc.com/examples/angularjs/#/");
    }

    @Step(value = "Adding item {0}")
    public void addItem(String item) {
        find(".new-todo").typeAndEnter(item);
    }

    public List<String> items() {
        return $$(".todo-list label").texts();
    }

    @Step("Adding items: {0}")
    public void addItems(String... items) {
        addItems(Arrays.asList(items));
    }

    @Step("Adding items: {0}")
    public void addItems(List<String> items) {
        for (String item : items) {
            addItem(item);
        }
    }

    @Step("Complete item {0}")
    public void completeItem(String item){
        findBy("//label[.='{0}']/preceding-sibling::input[@type='checkbox']", item).click();
    }

    @Step("Filter by {0}")
    public void filterBy(String filterName) {
        findBy("//a[normalize-space()='{0}'][1]", filterName).click();
    }

    public void removeItem(String item) {
        $("//label[.='{0}']",item).click();
        $("//label[.='{0}']/following-sibling::button[@class='destroy']", item).click();
    }
}
