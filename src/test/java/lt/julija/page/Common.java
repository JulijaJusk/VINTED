package lt.julija.page;

import lt.julija.util.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Common {



    public static void setUpDriver(int seconds) {
        Driver.setDriver();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public static void openUrl(String url) {
        Driver.getDriver().get(url);
    }

    public static void refreshPage(int sec) {
        Driver.getDriver().navigate().refresh();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
    }

    public static void quitDriver() {
        Driver.getDriver().quit();
    }

    public static WebElement getElement(By locator) {
        return Driver.getDriver().findElement(locator);
    }

    public static List<WebElement> getElements(By locator) {
        return Driver.getDriver().findElements(locator);
    }

    public static void clickOnElement(By locator) {
        getElement(locator).click();
    }

    public static void sendKeysToElement(By locator, String text) {
        getElement(locator).sendKeys(text);
    }

    public static String getTextFromElement(By locator) {
        return getElement(locator).getText();
    }

    public static void waitElementVisible(By locator, int sec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(sec));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static boolean waitElementIsEnabledCustomised(By locator, int sec) {
        boolean isEnabled = false;
        int i = 0;

        for (int j = 0; j < sec * 2; j++) {

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            isEnabled = getElement(locator).isEnabled();

            if (isEnabled) return true;

        }
        return isEnabled;
    }

    public static void clickOnElementByActions(By locator) {
        getActions()

                .click(getElement(locator))
                .perform();
    }

    private static Actions getActions() {
        return new Actions(Driver.getDriver());
    }

    public static List<String> getTextFromElements(By locator) {
        List<WebElement> elements = getElements(locator);
        List<String> nameOfSizes = new ArrayList<>();

        for (int i = 0; i < elements.size(); i++) {
            String size = elements.get(i).getText();
            nameOfSizes.add(size);
        }

        return nameOfSizes;
    }
}
