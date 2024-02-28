package lt.julija.page.vinted;

import lt.julija.page.Common;
import lt.julija.page.Locator;
import lt.julija.page.PageBase;

public class CreateAccountPage extends PageBase {


    public static void clickToSelectCountry() {
        Common.waitElementVisible(Locator.Vinted.CreateAccount.selectCountry, 6);
        Common.clickOnElement(Locator.Vinted.CreateAccount.selectCountry);
    }
}
