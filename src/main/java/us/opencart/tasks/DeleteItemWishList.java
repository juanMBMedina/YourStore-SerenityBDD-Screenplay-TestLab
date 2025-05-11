package us.opencart.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import us.opencart.exceptions.OptionNotFoundException;
import us.opencart.ui.WishListPage;

@AllArgsConstructor
public class DeleteItemWishList implements Task {

    private static final String REMOVE_OPTION = "Remove";
    private static final String ADD_TO_CART_OPTION = "Add to Cart";

    private final String itemName;
    private final String option;

    public static DeleteItemWishList with(String itemName, String option) {
        return Tasks.instrumented(DeleteItemWishList.class, itemName, option);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (option.equals(REMOVE_OPTION)) {
            actor.wasAbleTo(Click.on(WishListPage.ITEM_ACTION_TABLE.of(itemName, option)));
        } else if (option.equals(ADD_TO_CART_OPTION)) {
            actor.wasAbleTo(Click.on(WishListPage.ITEM_ACTION_TABLE.of(itemName, option)));
        } else {
            throw new OptionNotFoundException(option);
        }
    }
}
