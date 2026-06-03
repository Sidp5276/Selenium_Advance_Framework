package Testing.tests.DDT;

import Testing.baseTest.CommonToAllTest;
import Testing.driver.DriverManager;
import Testing.pages.pageFactory.LoginPage;
import Testing.utils.PropertiesReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVWOLogin_03_PF extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_03_PF.class);

    @Test
    public void testLoginNegativeVWO_PF() {
        logger.info("Starting the Page factory testcases!!");
        LoginPage loginPage_pf = new LoginPage(DriverManager.getDriver());
        String error_msg = loginPage_pf.loginToVWOInvalidCreds();

        logger.info("Finished the Testcases Page Factory");
        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message"));

    }
}

