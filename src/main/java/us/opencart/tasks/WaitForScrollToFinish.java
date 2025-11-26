package us.opencart.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class WaitForScrollToFinish implements Task {

    private final long timeoutMillis;

    public WaitForScrollToFinish(long timeoutMillis) {
        this.timeoutMillis = timeoutMillis;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        long startTime = System.currentTimeMillis();
        long lastPosition = -1;

        while (System.currentTimeMillis() - startTime < timeoutMillis) {
            long currentPosition = ((Long) js.executeScript("return window.pageYOffset;"));
            if (currentPosition == lastPosition) {
                return; // scroll detenido
            }
            lastPosition = currentPosition;

            try {
                Thread.sleep(50); // espera pequeña entre chequeos
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static WaitForScrollToFinish forUpTo(long timeoutMillis) {
        return Tasks.instrumented(WaitForScrollToFinish.class, timeoutMillis);
    }
}
