package steps;

import pages.AuthPage;
import pages.HomePage;

import java.util.List;

public class HomeSteps {
    private HomePage homePage;
    private AuthPage authPage;

    public HomeSteps() {
        homePage = new HomePage();
        authPage = new AuthPage();
    }

    /**
     * ����� ������� �� ������� � Map
     */
    public void clickMaps() {
        homePage.clickMaps();
        for (int i = 0; i < 10; i++) {
            if (homePage.isSearchMapFieldVisible()) break;
            homePage.clickMaps();
        }
        homePage.waitUntilSearchMapFieldVisible();
    }

    /**
     * ����� ������� ���� ������ ���
     */
    public void clearSearchMap() {
        homePage.clearSearchMap();
        homePage.waitUntilFirstMapVisible();
    }

    /**
     * ����� ������������ ��� �������� � �������� ��� ����
     * @return List
     */
    public List<String> getAllMaps() {
        List<String> maps = homePage.getAllMaps();
        if (homePage.isArrowRightVisible()) {
            int i = 0;
            while (homePage.isArrowRightBtnEnabled() && i != 20) {
                homePage.clickArrowRightBtn();
                homePage.waitUntilSearchMapFieldVisible();
                maps.addAll(homePage.getAllMaps());
                i++;
            }
        }
        return maps;
    }

    /**
     * ����� ������� �� ���� �������
     */
    public void clickConsole() {
        homePage.clickConsole();
        homePage.waitUntilConsoleTextAreaVisible();
    }

    /**
     * ����� ������ � ������� �������
     * @param text String �������
     */
    public void typeConsole(String text) {
        homePage.typeConsole(text);
    }

    /**
     * ����� ������ ��������
     */
    public void logOut() {
        homePage.clickLogOut();
        authPage.waitUntilUserNameVisible();
    }

    /**
     * ����� ���������� ����� ����������
     * @param namespace String ������������ ����
     */
    public void waitUntilNameSpaceChanged(String namespace) {
        homePage.waitUntilNameSpaceChanged(namespace);
    }

    /**
     * ����� ������� ��������� ���� �����
     */
    public void waitUntilNameSpaceCleared(String namespace) {
        homePage.waitUntilNameSpaceCleared(namespace);
    }
}
