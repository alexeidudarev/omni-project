package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/***
 * this class configured to run as suite
 * can be run one by one also
 *
 */
public class NegativeGroupTests extends TestBase {

    /***
     *testUploadingFileWithNotAllowedFormat func
     * checking not supported type of document uploading
     */
    @Test(priority = 2)
    public void testUploadingFileWithNotAllowedFormat(){
        String groupName = "new_group_19";
        String jpgFile = "/Users/mbp/Documents/omni_files/textfile.docx";
        app.getNavigationHelper().enterLoginCredentials("testuser","testuser");
        app.getDocumentHelper().searchForGroup(groupName);
        app.getDocumentHelper().fileUpload(jpgFile);
        Assert.assertTrue(app.getDocumentHelper().isFileUploadedDocumentNotSupported());

    }

    /***
     *testCreatingFileGroupWithExistingName func
     * checking validation of group creation with existing name
     *
     * @throws Exception
     */
    @Test(priority = 1)
    public void testCreatingFileGroupWithExistingName() throws Exception {
        String groupName = "new_group_19";
        app.getNavigationHelper().enterLoginCredentials("testuser","testuser");
        app.getDocumentHelper().createNewFileGroup(groupName);
        Assert.assertTrue(app.getDocumentHelper().isCreatingNewGroupFailed());
        app.getNavigationHelper().closeGroupCreationDialog();
    }

}
