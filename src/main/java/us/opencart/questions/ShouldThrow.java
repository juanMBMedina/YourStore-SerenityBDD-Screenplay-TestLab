package us.opencart.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.concurrent.Callable;

public class ShouldThrow implements Question<Boolean> {

    private final Callable<?> action;
    private final Class<? extends Throwable> expectedException;

    public ShouldThrow(Callable<?> action, Class<? extends Throwable> expectedException) {
        this.action = action;
        this.expectedException = expectedException;
    }

    public static ShouldThrow whenExecuting(Callable<?> action, Class<? extends Throwable> expected) {
        return new ShouldThrow(action, expected);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            action.call();
        } catch (Throwable e) {
            return expectedException.isInstance(e);
        }
        return false;
    }
}

