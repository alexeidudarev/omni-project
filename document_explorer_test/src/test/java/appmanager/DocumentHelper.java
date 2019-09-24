package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DocumentHelper extends HelperBase {
    private WebDriver driver;
    public DocumentHelper(WebDriver dr) {
        super(dr);
        this.driver = dr;
    }
    public void searchForGroup(String groupName){
        jsElementSendKeys(By.xpath(".//input[contains(@class,'ng-pristine')]"),groupName);
        jsElementClick(By.xpath(String.format("//block[contains(text(),'%s')]",groupName)));
        Assert.assertTrue(isJsElementPresented(By.xpath(String.format("//block[contains(text(),'%s')]",groupName))));

    }
    public  void fileUpload(String path){
        //upload file
        driver.findElement(By.xpath(".//input[@type='file']")).sendKeys(path);
    }
    public void createNewFileGroup(String groupName){
        //click on add new group button
        jsElementClick(By.xpath(".//*[contains(@class,'picnicButton')]"));
        //creating new group
        elementSendKeys(By.xpath(".//input[@placeholder='Name']"),groupName);
        //click on create button
        jsElementClick(By.xpath("//*[contains(text(),'Create')]"));
    }
    public void openExistingDocument(String filename){
        jsElementSendKeys(By.xpath("//echo-table-standalone[@class='echoTableHeightFull picnicHeightLimiter echoTableSearchable']//input[@placeholder='Search...']"),filename);
        try{
            Assert.assertTrue(isJsElementInList(By.xpath(String.format(".//empty[contains(text(),'%s')]",filename))));
        }catch (Exception e){
            Assert.fail("element not found");
        }
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 3000);");

    }
    public boolean isCreatingNewGroupFailed(){
        try{
            driver.findElement(By.xpath(".//paragraph[@class='picnicMessenger picnicMessengerGapInnerNormal picnicMessengerColorWarning']"));

        }catch (Exception e){
            return false;
        }
        return true;
    }
    public boolean isFileUploadedDocumentNotSupported(){
        elementClick(By.xpath(".//chunk[contains(text(),'1 file(s) finished uploading')]"));
        try{
            driver.findElement(By.xpath(".//rejected[@class='becauseOfType']"));

        }catch (Exception e) {
            return false;
        }
        return true;
    }
    /****
     func   isFileUploadFailed
     return true in case green icon of last uploaded document
     presented after document uploading
     in case any other icon presented return false
     */

    public boolean isFileUploadSucceed(){
        ////table[@class='picnicTableReactiveRows']//img[contains(@src,'problem-full-red')]
        boolean uploadFailed ;
        try {
            //checking if the last element in table has failed sign after upload
            WebElement myDynamicElement = (new WebDriverWait(driver, 100))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class='picnicTableReactiveRows']//tr[last()]//img[contains(@src,'check-full-green')]")));
            uploadFailed = myDynamicElement.isDisplayed();
            if (uploadFailed){
                return true;
            }
        }catch (Exception e){
            //Log.debug(e);
        }
        return false;
    }
    public void uploadFile(String groupName, String file){

        searchForGroup(groupName);
        int before = getElementsCount(By.xpath(".//documents[@class='picnicGridColumn3']//tr"));
        int after;
        if(file.substring(32).equals("huge.pdf")){
            fileUpload(file);
            js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 90000);");
            openExistingDocument("huge");
        }else{
            fileUpload(file);
        }
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 20000)");
        after = getElementsCount(By.xpath(".//documents[@class='picnicGridColumn3']//tr"));
        Assert.assertEquals(before+1 , after);
        Assert.assertTrue(isFileUploadSucceed());
    }


}
