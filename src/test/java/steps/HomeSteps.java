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
     * Метод кликает на сайдбар с Map
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
     * Метод очищает поле поиска мэп
     */
    public void clearSearchMap() {
        homePage.clearSearchMap();
        homePage.waitUntilFirstMapVisible();
    }

    /**
     * Метод пролистывает все страницы и получает все мэпы
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
     * Метод кликает на меню Консоль
     */
    public void clickConsole() {
        homePage.clickConsole();
        homePage.waitUntilConsoleTextAreaVisible();
    }

    /**
     * Метод вводит в консоль команду
     * @param text String команда
     */
    public void typeConsole(String text) {
        homePage.typeConsole(text);
    }

    /**
     * Метод делает разлогин
     */
    public void logOut() {
        homePage.clickLogOut();
        authPage.waitUntilUserNameVisible();
    }

    /**
     * Метод дожидается смены неймСпейса
     * @param namespace String пространство имен
     */
    public void waitUntilNameSpaceChanged(String namespace) {
        homePage.waitUntilNameSpaceChanged(namespace);
    }

    /**
     * Метод ожидает видимости поля логин
     */
    public void waitUntilNameSpaceCleared(String namespace) {
        homePage.waitUntilNameSpaceCleared(namespace);
    }
}
