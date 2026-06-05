package Testing.tests.DDT;

import Testing.pages.pageObjectModel.normal_POM.DashboardPage;
import Testing.pages.pageObjectModel.normal_POM.LoginPage;
import Testing.utils.EnvUtil;
import Testing.utils.YamlReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestVWOLogin_05_Normal_POM_YAML {

    @Test
    public void test_negative_vwo_login() {

        YamlReader yamlReader = new YamlReader("config.yaml");

        // Driver Manager Code - 1 - D
        WebDriver driver = new ChromeDriver();
        driver.get(yamlReader.getString("project1.url"));
        // Page Class Code (POM Code) - 2 - L
        LoginPage loginPage = new LoginPage(driver);
        String error_msg = loginPage.loginToVWOInvalidCreds(yamlReader.getString("project1.invalid_username"),yamlReader.getString("project1.invalid_password"));
        // Assertions - 3 - V
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg,yamlReader.getString("project1.invalid_error_message"));
        driver.quit();
    }
}
