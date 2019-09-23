import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import steps.AuthSteps;
import steps.HomeSteps;

public class BasicTest {
    public AuthSteps authSteps;
    public HomeSteps homeSteps;

    @BeforeClass
    public void before() {
        authSteps = new AuthSteps();
        homeSteps = new HomeSteps();

        /*Configuration.browser = "firefox";
        if (System.getProperty("os.name").toLowerCase().contains("windows"))
            System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        else
            System.setProperty("webdriver.gecko.driver", "geckodriver");*/
        Configuration.browser = ConfigureProperties.getConfigureProperty("Configuration.browser");
        WebDriverManager.chromedriver().version(ConfigureProperties.getConfigureProperty("Configuration.version"))
                .setup();
        Configuration.timeout = Long.parseLong(ConfigureProperties.getConfigureProperty("Configuration.timeout"));
        Configuration.startMaximized =
                Boolean.parseBoolean(ConfigureProperties.getConfigureProperty("Configuration.startMaximized"));
        Selenide.open(ConfigureProperties.getConfigureProperty("URL"));
    }

    @AfterClass
    public void after() {
        Selenide.close();
    }
}
