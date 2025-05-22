package us.opencart.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import us.opencart.models.SearchItemNavBar;
import us.opencart.ui.HomePage;
import us.opencart.utils.UiAssertions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class SearchItem implements Task {

    private final SearchItemNavBar item;

    public static SearchItem with(SearchItemNavBar item) {
        return instrumented(SearchItem.class, item);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.wasAbleTo(Click.on(HomePage.CATEGORY_ALONE_TARGET.of(item.getCategory())));
        if (!item.getSubcategory().equals(SearchItemNavBar.DEFAULT_VALUE)) {
            actor.wasAbleTo(Click.on(HomePage.CATEGORY_SUBCATEGORY_TARGET.of(item.getCategory(), item.getSubcategory())));
        }
        UiAssertions.shouldSeeElementOnPage(actor, HomePage.ITEM_BOX_TARGET.of(item.getItemName()));
    }
}
