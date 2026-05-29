package Testing.tests.DDT;

import Testing.baseTest.CommonToAllTest;
import Testing.listeners.RetryAnalyzer;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Testing.driver.DriverManager.getDriver;

@Test(retryAnalyzer = RetryAnalyzer.class )
public class TestVWOLogin_06_Retry_Prop_Improved_POM extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_06_Retry_Prop_Improved_POM.class);

    @Test
    public void testFail() {
        getDriver().get("https://app.vwo.com");
        logger.info("Starting the Testcases Page Object Model");
        Assert.assertTrue(false);
    }

    @Test
    public void testPass() {
        getDriver().get("https://app.vwo.com");
        logger.info("Starting the Testcases Page Object Model");
        Assert.assertTrue(true);
    }
}
