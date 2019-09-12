package steps;

import pages.AuthPage;
import pages.HomePage;

public class AuthSteps {
    private AuthPage authPage;
    private HomePage homePage;

    public AuthSteps() {
        authPage = new AuthPage();
        homePage = new HomePage();
    }

    /**
     * ����� �������� �����������
     * @param userName String �����
     * @param password String ������
     */
    public void login(String userName, String password) {
        authPage.setUserName(userName);
        authPage.setPassWord(password);
        authPage.clickSignIn();
        homePage.waitUntilSideBarLoaded();
    }
}
