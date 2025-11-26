package us.opencart.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class WaitForScrollToFinish implements Task {

    private final long timeoutMillis;
    private final long pollIntervalMillis;

    public WaitForScrollToFinish(long timeoutMillis, long pollIntervalMillis) {
        this.timeoutMillis = timeoutMillis;
        this.pollIntervalMillis = pollIntervalMillis;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        long startTime = System.currentTimeMillis();
        long lastScrollPosition = -1;

        while (System.currentTimeMillis() - startTime < timeoutMillis) {
            String readyState = (String) js.executeScript("return document.readyState;");
            if (!"complete".equals(readyState)) {
                sleep(pollIntervalMillis);
                continue;
            }

            long currentScrollPosition = ((Number) js.executeScript("return window.pageYOffset;")).longValue();
            if (currentScrollPosition == lastScrollPosition) {
                return;
            }
            lastScrollPosition = currentScrollPosition;

            sleep(pollIntervalMillis);
        }

    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static WaitForScrollToFinish forUpTo(long timeoutMillis) {
        return new WaitForScrollToFinish(timeoutMillis, 100);
    }

    public static WaitForScrollToFinish forUpTo(long timeoutMillis, long pollIntervalMillis) {
        return new WaitForScrollToFinish(timeoutMillis, pollIntervalMillis);
    }
}
