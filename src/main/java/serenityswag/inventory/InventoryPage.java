package serenityswag.inventory;

import net.thucydides.core.pages.PageObject;

import static java.nio.file.Files.find;

public class InventoryPage extends PageObject {
    public String getHeading() {
        return $(".title").getText();
    }
}
