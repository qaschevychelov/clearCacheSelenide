package steps;

import io.qameta.allure.Step;
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
    @Step
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
    @Step
    public void clearSearchMap() {
        homePage.clearSearchMap();
        homePage.waitUntilFirstMapVisible();
    }

    /**
     * ����� ������������ ��� �������� � �������� ��� ����
     * @return List
     */
    @Step
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
    @Step
    public void clickConsole() {
        homePage.clickConsole();
        homePage.waitUntilConsoleTextAreaVisible();
    }

    /**
     * ����� ������ � ������� �������
     * @param text String �������
     */
    @Step
    public void typeConsole(String text) {
        homePage.typeConsole(text);
    }

    /**
     * ����� ������ ��������
     */
    @Step
    public void logOut() {
        homePage.clickLogOut();
        authPage.waitUntilUserNameVisible();
    }

    /**
     * ����� ���������� ����� ����������
     * @param namespace String ������������ ����
     */
    @Step
    public void waitUntilNameSpaceChanged(String namespace) {
        homePage.waitUntilNameSpaceChanged(namespace);
    }

    /**
     * ����� ������� ��������� ���� �����
     */
    @Step
    public void waitUntilNameSpaceCleared(String namespace) {
        homePage.waitUntilNameSpaceCleared(namespace);
    }
}
