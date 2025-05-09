package us.opencart.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CommonElements {
    private CommonElements() {
    }

    public static final Target ELEMENT_EQUALS_TEXT = Target.the("The element with text equals: {0}").locatedBy("//*[text()='{0}']");
    public static final Target ELEMENT_CONTAINS_TEXT = Target.the("The element contains text: {0}").locatedBy("//*[contains(text(),'{0}')]]");
    public static final Target TOP_NAV_ITEM_CONTAINS_TEXT = Target.the("Top Nav bar item contains text: {0}").locatedBy("//nav[@id='top']//*[contains(text(),'{0}')]");



}
