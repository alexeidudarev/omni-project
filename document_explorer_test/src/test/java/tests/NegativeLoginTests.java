package tests;

import org.testng.Assert;
import org.testng.annotations.*;
/***
 * this class configured to run as suite and
 * can be run one by one
 *
 */
public class NegativeLoginTests extends TestBase {


    @Test(enabled = true)
    public void testLoginWrongUsername() throws Exception {
        app.getNavigationHelper().enterLoginCredentials("user","testuser");
        app.getNavigationHelper().isWrongCredential();
    }
    @Test(enabled = true)
    public void testLoginWrongPass() throws Exception {
        app.getNavigationHelper().enterLoginCredentials("testuser","user");
        app.getNavigationHelper().isWrongCredential();

    }
    @Test(enabled = true)
    public void testLoginEmptyPass() throws Exception {
        app.getNavigationHelper().enterLoginCredentials("testuser"," ");
        app.getNavigationHelper().isWrongCredential();

    }


}
