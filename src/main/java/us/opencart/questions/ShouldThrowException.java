package us.opencart.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.concurrent.Callable;

public class ShouldThrowException implements Question<Boolean> {

    private final Callable<?> action;
    private final Class<? extends Throwable> expectedException;

    public ShouldThrowException(Callable<?> action, Class<? extends Throwable> expectedException) {
        this.action = action;
        this.expectedException = expectedException;
    }

    public static ShouldThrowException whenExecuting(Callable<?> action, Class<? extends Throwable> expected) {
        return new ShouldThrowException(action, expected);
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

