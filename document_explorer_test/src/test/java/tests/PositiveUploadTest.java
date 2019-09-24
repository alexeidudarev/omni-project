package tests;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
/***
 * this class configured to run test one by one
 *
 */
public class PositiveUploadTest extends TestBase {
    String groupName = "new_group_17";
    private static final String BASEPATH = "/Users/mbp/Documents/omni_files/%s";



    @Test(enabled = true)
    public void testPDFFileUploading() throws Exception {
        String pdfFile = "/Users/mbp/Documents/omni_files/dummy.pdf";
        //login to the system
        app.getNavigationHelper().enterLoginCredentials("testuser","testuser");
        app.getDocumentHelper().uploadFile(groupName,pdfFile);

    }
    @Test(enabled = true)
    public void test20MegaBytePDFFileUploading() throws Exception {
        String pdfFile = "/Users/mbp/Documents/omni_files/huge.pdf";
        //login to the system
        app.getNavigationHelper().enterLoginCredentials("testuser","testuser");
        app.getDocumentHelper().uploadFile(groupName,pdfFile);

    }
    @Test(enabled = true)
    public void testTIFFFileUploading() throws Exception {
        String pdfFile = "/Users/mbp/Documents/omni_files/image.TIF";
        app.getNavigationHelper().enterLoginCredentials("testuser","testuser");
        app.getDocumentHelper().uploadFile(groupName,pdfFile);

    }
    @Test(enabled = true)
    public void testPNGFileUploading() throws Exception {
        String pdfFile = "/Users/mbp/Documents/omni_files/clouds.png";
        app.getNavigationHelper().enterLoginCredentials("testuser","testuser");
        app.getDocumentHelper().uploadFile(groupName,pdfFile);

    }
    @Test
    public void testJPGFileUploading() throws Exception {
        String jpgFile = "/Users/mbp/Documents/omni_files/cat.jpg";
        app.getNavigationHelper().enterLoginCredentials("testuser","testuser");
        app.getDocumentHelper().uploadFile(groupName,jpgFile);
    }


}
