package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationHelper extends HelperBase{
    private WebDriver driver;

    public NavigationHelper(WebDriver dr) {
        super(dr);
        this.driver = dr;
    }
    public void enterLoginCredentials(String user, String pass) {
        //add username
        elementSendKeys(By.id("username"),user);
        //add password
        elementSendKeys(By.id("password"),pass);
        //click on save button
        elementClick(By.id("kc-login"));
    }
    public void openMainPage(String url){
        driver.get(url);
    }

    public boolean isWrongCredential(){
        if (isJsElementPresented(By.xpath(".//span[contains(text(),'Invalid username or password.')]"))){
            return true;
        }
        return false;
    }
    public void closeGroupCreationDialog(){
        jsElementClick(By.xpath("//button[@class='picnicButton']"));
    }


}
