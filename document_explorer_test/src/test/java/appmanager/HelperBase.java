package appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class HelperBase {
    public WebDriver driver;
    private boolean acceptNextAlert = true;
    JavascriptExecutor js ;
    public HelperBase(WebDriver dr) {
        this.driver = dr;
        js = (JavascriptExecutor)dr;
    }

    public void elementSendKeys(By by,String keys){
        WebElement element =driver.findElement(by);
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", element);
        element.clear();
        element.click();
        element.sendKeys(keys);
    }
    public WebElement elementClick(By by){
        WebElement element =driver.findElement(by);
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 3000);");
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", element);
        element.click();
        return element;
    }
    public int getElementsCount(By by){
        WebElement[]  elements;
        elements = driver.findElements(by).toArray(new WebElement[0]);
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");
        return elements.length;
    }
    public WebElement jsElementClick(By by){
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 3000);");
        WebElement element =driver.findElement(by);
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", element);
        js.executeScript("arguments[0].click();", element);
        return  element;
    }
    public WebElement jsElementSendKeys(By by, String keys){
        WebElement element =driver.findElement(by);
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", element);
        element.clear();
        js.executeScript("arguments[0].click();", element);
        element.sendKeys(keys);
        return  element;
    }
    public boolean isJsElementPresented(By by){
        WebElement element =driver.findElement(by);
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 3000);");
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", element);
        if (element.isDisplayed()){
            return true;
        }
        return  false;
    }
    public boolean isJsElementInList(By by){
        WebElement element = driver.findElement(by);
        waitTill(driver,by);
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 3000);");
        if (element != null){
            return true;
        }
        return  false;
    }

    private void waitTill(WebDriver driver,By by){

        WebDriverWait wait5 = new WebDriverWait(driver, 20000);
        driver.findElement(by).click();
        wait5.until(ExpectedConditions.visibilityOfElementLocated(by));
    }


    public void click(By locator) {
        driver.findElement(locator).click();
    }
    public void clear(By locator) {
        driver.findElement(locator).clear();
    }
    public void type(By locator, String text) {
        click(locator);
        if(text!= null){
            String existText = driver.findElement(locator).getAttribute("value");
            if(!text.equals(existText)){
                clear(locator);
                driver.findElement(locator).sendKeys(text);
            }
        }

    }
    public void sendKeys(By locator , String text) {
        driver.findElement(locator).sendKeys(text );
    }

    public void attach(By locator, File file){
        if(file!=null){
            driver.findElement(locator).sendKeys(file.getAbsolutePath());
        }
    }

    public boolean isElementPresented(By locator) {
        try{
            driver.findElement(locator);
            return true;
        }catch (NoSuchElementException e){
            System.out.println("no such element exeption");
            return false;
        }

    }
    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
