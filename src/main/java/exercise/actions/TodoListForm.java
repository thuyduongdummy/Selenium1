package exercise.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

class TodoListForm {
    static final By NEW_TODO_FIELD = By.className(".new-todo");
    static final String ITEM_LABELS = ".todo-list label";
    static final String COMPLETE_CHECKBOX = "//label[.='{0}']/preceding-sibling::input[@type='checkbox']";
    static final String FILTER_BUTTON = "//a[normalize-space()='{0}'][1]" ;
   // static final String
    //static final String

}
