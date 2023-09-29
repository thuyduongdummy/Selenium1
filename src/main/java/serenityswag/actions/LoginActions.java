package serenityswag.actions;

import lombok.AllArgsConstructor;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class LoginActions extends UIInteractionSteps {

    @Step("Log in as {0}")
    public void as (userInfo user) {

        openUrl("https://www.saucedemo.com/");

        find("#user-name").sendKeys(user.getUsername());
        find("#password").sendKeys(user.getPassword());
        find("#login-button").click();

    }
}
