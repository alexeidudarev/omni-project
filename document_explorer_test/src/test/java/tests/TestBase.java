package tests;
import appmanager.AppManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.*;

public class TestBase {

    protected static AppManager app = new AppManager(BrowserType.FIREFOX);


    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }





}