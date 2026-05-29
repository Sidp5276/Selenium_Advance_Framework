package Testing.tests.DDT;

import Testing.pages.pageObjectModel.normal_POM.DashboardPage;
import Testing.pages.pageObjectModel.normal_POM.LoginPage;
import Testing.utils.EnvUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestVWOLogin_04_Normal_POM_ENV {

    // D
    // L
    // V
    @Test
    public void test_negative_vwo_login() {

        // Driver Manager Code - 1 - D
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");
        // Page Class Code (POM Code) - 2 - L
        LoginPage loginPage = new LoginPage(driver);
        String error_msg = loginPage.loginToVWOInvalidCreds("admin@gmail.com","1234");
        // Assertions - 3 - V
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg,"Your email, password, IP address or location did not match");
        driver.quit();
    }

    @Test
    public void test_positive_vwo_login() {

        // Driver Manager Code - 1 - D
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");
        // Page Class Code (POM Code) - 2 - L
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToVWOValidCreds(EnvUtil.getUsername(),EnvUtil.getPassword());
        // Assertions - 3 - V
        DashboardPage dashboardPage = new DashboardPage(driver);
        String userNameLoggedIn = dashboardPage.loggedInUserName();

        Assert.assertEquals(userNameLoggedIn,"Kishore J");
        driver.quit();
    }
}
