package us.opencart.tasks.items;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import us.opencart.exceptions.OptionNotFoundException;
import us.opencart.ui.HomeUI;
import us.opencart.ui.WishListUI;

public class PerformActionItemTable extends PerformActionItemBase {
    // You Can use this task in tables of AddToCartPage and WishListPagew the tables are the same,
    // but, you can check the targets of these classes.
    protected PerformActionItemTable(String itemName, String itemOption) {
        super(itemName, itemOption);
    }

    public static PerformActionItemTable with(String itemName, String option) {
        return Tasks.instrumented(PerformActionItemTable.class, itemName, option);
    }

    public static Boolean checkOptions(String inputOption) {
        return HomeUI.REMOVE_OPTION.equals(inputOption)
                || HomeUI.ADD_TO_CART_OPTION.equals(inputOption);
    }


    @Override
    protected boolean isOptionValid(String inputOption) {
        return checkOptions(inputOption);
    }

    @Override
    protected void performActions(Actor actor) {
        switch (itemOption) {
            case HomeUI.REMOVE_OPTION:
            case HomeUI.ADD_TO_CART_OPTION:
                actor.wasAbleTo(Click.on(WishListUI.ITEM_ACTION_TABLE.of(itemName, itemOption)));
                break;
            default:
                throw new OptionNotFoundException(itemOption);
        }
    }


}
