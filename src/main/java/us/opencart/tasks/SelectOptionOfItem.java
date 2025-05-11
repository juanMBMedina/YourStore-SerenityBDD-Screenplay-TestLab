package us.opencart.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import us.opencart.exceptions.OptionNotFoundException;
import us.opencart.ui.HomePage;

import static us.opencart.ui.HomePage.*;

@AllArgsConstructor
public class SelectOptionOfItem implements Task {

    private final String itemName;
    private final String optionItem;

    public static SelectOptionOfItem with(String itemName, String optionItem){
        return Tasks.instrumented(SelectOptionOfItem.class, itemName, optionItem);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (optionItem) {
            case COMPARISON_OPTION:
            case WISH_LIST_OPTION:
                actor.wasAbleTo(Click.on(HomePage.ITEM_BUTTON.of(itemName, optionItem)));
                break;
            case ADD_TO_CART_OPTION:
                actor.wasAbleTo(Click.on(HomePage.ADD_TO_CART_BUTTON.of(itemName, optionItem)));
                break;
            default:
                throw new OptionNotFoundException(optionItem);
        }
    }
}
