package tests;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;

import java.util.Random;
/***
 * this class configured to run as suite and
 * can be run one by one
 *
 */
public class PositiveLoginTest extends TestBase {

    String groupName = "new_group_19";
    private static final String BASEPATH = "/Users/mbp/Documents/omni_files/%s";


    @Test(priority = 1)
    public void testLogin() throws Exception {
        String groupName = "new_group_19";
        app.getNavigationHelper().enterLoginCredentials("testuser","testuser");
        app.getDocumentHelper().searchForGroup(groupName);

    }
    /**
     * before run this test
     * group name should be changed to not existing group manually
     */
    @Test(priority = 2)
    public void testCreatingFileGroup() throws Exception {
        Random random = new Random();
        String groupName = String.format("new_group_%s",random.nextInt(5000));
        app.getNavigationHelper().enterLoginCredentials("testuser","testuser");
        app.getDocumentHelper().createNewFileGroup(groupName);
        app.getDocumentHelper().searchForGroup(groupName);

    }
    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();

    }

}
