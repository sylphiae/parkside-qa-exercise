package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WikipediaMetis extends BasePage {

    public By familyHeading = By.cssSelector("h2 span[id='Family']");
    public By mythologyHeading = By.cssSelector("h2 span[id='Mythology']");
    public By referencesHeading = By.cssSelector("h2 span[id='References']");
    public By seeAlsoHeading = By.cssSelector("h2 span[id='See_also']");
    public By furtherReadingHeading = By.cssSelector("h2 span[id='Further_reading']");

    public By familyLink = By.xpath("(//span[.=\"Family\"])[1]");
    public By mythologyLink = By.xpath("(//span[.=\"Mythology\"])[1]");
    public By referencesLink = By.xpath("(//span[.=\"References\"])[1]");
    public By seeAlsoLink = By.xpath("(//span[.=\"See also\"])[1]");
    public By furtherReadingLink = By.xpath("(//span[.=\"Further reading\"])[1]");

    public By nikeLink = By.cssSelector("a[title='Nike (mythology)']");
    public By nikePopupText = By.cssSelector("a[class=\"mwe-popups-extract\"] p");

    public By familyTree = By.cssSelector("table[class=\"toccolours\"] tbody tr td table");

    public WikipediaMetis(WebDriver driver) {
        super(driver);
    }

    public void loadPage() {
        visit("https://en.wikipedia.org/wiki/Metis_(mythology)");
    }

    public void loadPageAndClick(By link) {
        visit("https://en.wikipedia.org/wiki/Metis_(mythology)");
        click(link);
    }

    public Boolean headingPresent(By heading) {
        return isDisplayed(heading, 10);
    }
}
