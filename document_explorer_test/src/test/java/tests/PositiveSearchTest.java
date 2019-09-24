package tests;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/***
 * this class configured to run test one by one and in suite
 *
 */
public class PositiveSearchTest extends TestBase {
    String groupName = "new_group_19";
    private String url = "";
    private static final String BASEPATH = "/Users/mbp/Documents/omni_files/%s";
    private PositiveSearchTest() throws IOException {

    }

    @Test(enabled = true)
    public void testSearchForGroup() throws Exception {
        app.getNavigationHelper().enterLoginCredentials("testuser","testuser");
        app.getDocumentHelper().searchForGroup(groupName);

    }
    @Test
    public void searchForDocumentInCollection(){
        String document = "cat";
        app.getNavigationHelper().enterLoginCredentials("testuser","testuser");
        app.getDocumentHelper().searchForGroup(groupName);
        app.getDocumentHelper().openExistingDocument(document);


    }
    @Test
    public void searchForDocumentInCollectionByNumber(){
        String document = "2";
        app.getNavigationHelper().enterLoginCredentials("testuser","testuser");
        app.getDocumentHelper().searchForGroup(groupName);
        app.getDocumentHelper().openExistingDocument(document);


    }
    @Test
    public void searchForDocumentInCollectionBySingleChar(){
        String document = "d";
        app.getNavigationHelper().enterLoginCredentials("testuser","testuser");
        app.getDocumentHelper().searchForGroup(groupName);
        app.getDocumentHelper().openExistingDocument(document);


    }
    @Test
    public void searchForDocumentInCollectionByExtension(){
        groupName = "new_group_19";
        String document = "pdf";
        app.getNavigationHelper().enterLoginCredentials("testuser","testuser");
        app.getDocumentHelper().searchForGroup(groupName);
        app.getDocumentHelper().openExistingDocument(document);


    }

}
