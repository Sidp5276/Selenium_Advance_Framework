package Testing.base;
import Testing.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Testing.driver.DriverManager.getDriver;

public class CommonToAllPage {

    //  Common to All Pages
    public void openVWOUrl() {
        getDriver().get(PropertiesReader.readKey("url"));
    }
    public void openOrangeHRMUrl(){
        getDriver().get(PropertiesReader.readKey("ohr_url"));
    }

    public void openKatalonUrl(){
        getDriver().get(PropertiesReader.readKey("katalon_url"));
    }

    public void clickElement(By by){
        getDriver().findElement(by).click();
    }
    public void clickElement(WebElement element){
        element.click();
    }

    public void enterInput(By by, String key) {
        getDriver().findElement(by).sendKeys(key);
    }

    public void enterInput(WebElement by, String key) {
        by.sendKeys(key);
    }

    public String getText(By by){
        return getDriver().findElement(by).getText();
    }

    public String getText(WebElement by){
        return by.getText();
    }
}