package tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import pageObjects.WikipediaMetis;
import tests.groups.Shallow;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

@Category(Shallow.class)
public class TestWikipediaMetis extends BaseTest {

    private WikipediaMetis wikipediaMetis;

    @Before
    public void setUp() {
        wikipediaMetis = new WikipediaMetis(driver);
    }

    @Test
    public void contextBoxHeadingsAreUsedAsPageHeadings() {
        wikipediaMetis.loadPage();
        assertTrue("Family is not a heading",
                wikipediaMetis.headingPresent(wikipediaMetis.familyHeading));
        assertTrue("Mythology is not a heading",
                wikipediaMetis.headingPresent(wikipediaMetis.mythologyHeading));
        assertTrue("References is not a heading",
                wikipediaMetis.headingPresent(wikipediaMetis.referencesHeading));
        assertTrue("See also is not a heading",
                wikipediaMetis.headingPresent(wikipediaMetis.seeAlsoHeading));
        assertTrue("Further reading is not a heading",
            wikipediaMetis.headingPresent(wikipediaMetis.furtherReadingHeading));

    }

    @Test
    public void contextBoxHeadingsHaveValidHyperlinks() {
        wikipediaMetis.loadPageAndClick(wikipediaMetis.familyLink);
        assertTrue("Family is not present after clicking on the hyperlink",
                wikipediaMetis.headingPresent(wikipediaMetis.familyHeading));
        wikipediaMetis.loadPageAndClick(wikipediaMetis.mythologyLink);
        assertTrue("Mythology is not present after clicking on the hyperlink",
                wikipediaMetis.headingPresent(wikipediaMetis.mythologyHeading));
        wikipediaMetis.loadPageAndClick(wikipediaMetis.referencesLink);
        assertTrue("References is not present after clicking on the hyperlink",
                wikipediaMetis.headingPresent(wikipediaMetis.referencesHeading));
        wikipediaMetis.loadPageAndClick(wikipediaMetis.seeAlsoLink);
        assertTrue("See also is not present after clicking on the hyperlink",
                wikipediaMetis.headingPresent(wikipediaMetis.seeAlsoHeading));
        wikipediaMetis.loadPageAndClick(wikipediaMetis.furtherReadingLink);
        assertTrue("Further reading is not present after clicking on the hyperlink",
                wikipediaMetis.headingPresent(wikipediaMetis.furtherReadingHeading));
    }

    @Test
    public void nikePopupTextExists() throws InterruptedException {
        wikipediaMetis.loadPage();
        wikipediaMetis.hover(wikipediaMetis.nikeLink, wikipediaMetis.nikePopupText);
        assertEquals("In ancient Greek religion, Nike was a goddess who personified victory. Her Roman equivalent was Victoria."
                , wikipediaMetis.getText(wikipediaMetis.nikePopupText));
    }

    @Test
    public void familyTreeIsDisplayed() {
        wikipediaMetis.loadPageAndClick(wikipediaMetis.nikeLink);
        assertTrue("The family tree is not present after clicking on the hyperlink",
                wikipediaMetis.isDisplayed(wikipediaMetis.familyTree));
    }
}
