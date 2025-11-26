package us.opencart.tasks.items;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import us.opencart.ui.HomePage;
import us.opencart.ui.WishListPage;

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
        switch (inputOption) {
            case HomePage.REMOVE_OPTION:
            case HomePage.ADD_TO_CART_OPTION:
                return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    protected boolean isOptionValid(String inputOption) {
        return checkOptions(inputOption);
    }

    @Override
    protected void performActions(Actor actor) {
        switch (itemOption) {
            case HomePage.REMOVE_OPTION:
            case HomePage.ADD_TO_CART_OPTION:
                actor.wasAbleTo(Click.on(WishListPage.ITEM_ACTION_TABLE.of(itemName, itemOption)));
                break;
        }
    }


}
