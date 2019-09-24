package appmanager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class AppManager {

    private NavigationHelper navigationHelper;
    private DocumentHelper documentHelper;
    private WebDriver driver;
    private String browser;
    public Properties properties;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    public AppManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {

        String target = System.getProperty("target","local");
        properties.load(new FileReader(String.format
                ("src/test/resources/%s.properties",target)));


        if(browser.equals(BrowserType.FIREFOX)){
            driver = new FirefoxDriver();
        }else if(browser.equals(BrowserType.CHROME)){
            driver = new ChromeDriver();
        }else if(browser.equals(BrowserType.SAFARI)){
            driver = new SafariDriver();
        }

        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        navigationHelper = new NavigationHelper(driver);
        documentHelper = new DocumentHelper(driver);

        navigationHelper.openMainPage(properties.getProperty("web.baseUrl"));
        /*
        navigationHelper.enterLoginCredentials(
                properties.getProperty("web.adminLogin"),
                properties.getProperty("web.adminPass"));
        */
    }

    public void stop() {
        //sessionHelper.logout();
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public DocumentHelper getDocumentHelper() {
        return documentHelper;
    }

    public NavigationHelper getNavigationHelper() { return navigationHelper; }

}
