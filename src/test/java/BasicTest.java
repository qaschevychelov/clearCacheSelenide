import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import steps.AuthSteps;
import steps.HomeSteps;

public class BasicTest {
    public AuthSteps authSteps;
    public HomeSteps homeSteps;

    private String url = "http://rtd-testy-app:38080/hazelcast-mancenter/admin/console";

    @BeforeClass
    public void before() {
        authSteps = new AuthSteps();
        homeSteps = new HomeSteps();

        System.setProperty("webdriver.chrome.driver", "./bin/chromedriver/chromedriver.exe");
        Configuration.timeout = 20000;
        Configuration.startMaximized = true;
        Selenide.open(url);
    }

    @AfterClass
    public void after() {
        Selenide.close();
    }
}
