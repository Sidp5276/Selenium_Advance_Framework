package Testing.tests.DDT;


import Testing.baseTest.CommonToAllTest;
import Testing.driver.DriverManager;
import Testing.pages.pageObjectModel.Improved_POM.LoginPage;
import Testing.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.assertj.core.api.Assertions.assertThat;


public class TestVWOLogin_02_Prop_Improved_POM extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_02_Prop_Improved_POM.class);
    @Test
    public void test_negative_vwo_login() {
        logger.info("Browser is started....");
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        logger.info("Verifying the Invalid credentials....");
        String error_msg = loginPage.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));

        logger.info("Final Assert Verifications....");
        // System.out.println(error_msg); No now!!
        logger.info(error_msg.toString());

        logger.error("Failed to verify");
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message"));
    }
}

