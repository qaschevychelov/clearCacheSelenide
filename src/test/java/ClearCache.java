import org.testng.annotations.Test;

import java.util.List;

public class ClearCache extends BasicTest{
    // локальные переменные
    private String user = "admin";
    private String pass = "z2DE08LJMi3A";

    @Test(enabled = true, description = "Очистка кэша")
    public void clearCache() {
        authSteps.login(user, pass);

        homeSteps.clickMaps();
        homeSteps.clearSearchMap();

        List<String> maps = homeSteps.getAllMaps();
        homeSteps.clickConsole();

        maps.forEach(one -> {
            homeSteps.typeConsole("ns " + one);
            homeSteps.waitUntilNameSpaceChanged(one);
            homeSteps.typeConsole("m.clear");
            homeSteps.waitUntilNameSpaceCleared(one);
        });
        homeSteps.logOut();
    }
}
