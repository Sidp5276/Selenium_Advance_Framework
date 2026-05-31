package Testing.pages.pageFactory;

import Testing.base.CommonToAllPage;
import Testing.utils.PropertiesReader;
import Testing.utils.WaitHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonToAllPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    // Page Locators

    @FindBy(id="login-username")
    private WebElement username;

    // private By username = By.id("login-username");

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(id = "js-login-btn")
    private WebElement signButton;

    @FindBy(css = "#js-notification-box-msg")
    private WebElement error_message;

    // Page Actions
    public String loginToVWOInvalidCreds() {
        try{
            openVWOUrl();
            enterInput(username, PropertiesReader.readKey("invalid_username"));
            enterInput(password, PropertiesReader.readKey("invalid_password"));
            clickElement(signButton);
            WaitHelpers.waitJVM(5000);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            // e.printStackTrace(); // it will print the error message with the lines number
        }
        return getText(error_message);
    }
}

