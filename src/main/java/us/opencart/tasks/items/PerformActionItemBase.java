package us.opencart.tasks.items;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import us.opencart.exceptions.OptionNotFoundException;

public abstract class PerformActionItemBase implements Task {

    protected final String itemName;
    protected final String itemOption;

    protected PerformActionItemBase(String itemName, String itemOption) {
        this.itemName = itemName;
        this.itemOption = itemOption;
    }

    protected abstract boolean isOptionValid(String inputOption);

    protected abstract void performActions(Actor actor);

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (!isOptionValid(itemOption)) {
            throw new OptionNotFoundException(itemOption);
        }
        performActions(actor);
    }
}
