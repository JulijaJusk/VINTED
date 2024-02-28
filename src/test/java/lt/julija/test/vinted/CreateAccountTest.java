package lt.julija.test.vinted;

import lt.julija.page.vinted.CreateAccountPage;
import lt.julija.test.TestBase;
import org.testng.annotations.BeforeMethod;

public class CreateAccountTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        CreateAccountPage.open("https://www.vinted.com/",8);
        CreateAccountPage.clickToSelectCountry();
        CreateAccountPage.clickOnButtonAcceptCookies();
        CreateAccountPage.refreshWebPage(7);
    }
}
