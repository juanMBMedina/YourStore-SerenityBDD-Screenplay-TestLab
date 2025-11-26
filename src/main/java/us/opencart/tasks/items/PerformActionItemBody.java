package us.opencart.tasks.items;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import us.opencart.ui.HomePage;


public class PerformActionItemBody extends PerformActionItemBase {

    protected PerformActionItemBody(String itemName, String itemOption) {
        super(itemName, itemOption);
    }

    public static PerformActionItemBody with(String itemName, String optionItem) {
        return Tasks.instrumented(PerformActionItemBody.class, itemName, optionItem);
    }

    public static Boolean checkOptions(String inputOptions) {
        switch (inputOptions) {
            case HomePage.COMPARISON_OPTION:
            case HomePage.WISH_LIST_OPTION:
            case HomePage.ADD_TO_CART_OPTION:
                return Boolean.TRUE;
            default:
                return Boolean.FALSE;
        }
    }

    @Override
    protected boolean isOptionValid(String inputOption) {
        return checkOptions(inputOption);
    }

    @Override
    protected void performActions(Actor actor) {
        switch (itemOption) {
            case HomePage.COMPARISON_OPTION:
            case HomePage.WISH_LIST_OPTION:
                actor.wasAbleTo(Click.on(HomePage.ITEM_BUTTON.of(itemName, itemOption)));
                break;
            case HomePage.ADD_TO_CART_OPTION:
                actor.wasAbleTo(Click.on(HomePage.ADD_TO_CART_BUTTON.of(itemName, itemOption)));
                break;
        }
    }

}
