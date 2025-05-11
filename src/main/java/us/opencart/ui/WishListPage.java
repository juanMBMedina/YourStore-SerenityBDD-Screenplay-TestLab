package us.opencart.ui;

import net.serenitybdd.screenplay.targets.Target;

public class WishListPage extends HomePage {

    public static final Target ITEM_NAME_TABLE = Target.the("The table's cell that contains Item Name: {0}").locatedBy("//div[@class='table-responsive']//*[contains(text(),'{0}')]");
    public static final Target ITEM_ACTION_TABLE = Target.the("The table's cell that contains Item Name: {0} and Action: {1}").locatedBy("//div[@class='table-responsive']//*[contains(text(),'{0}')]/ancestor::tr//*[@data-original-title='{1}']");

}
