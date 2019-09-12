package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Пейдж домашней страницы
 */
public class HomePage {
    private final SelenideElement sideBarMaps = $(By.xpath("//div[@id='sidebar-menu']//span[starts-with(.,'Maps [')]"));
    private final SelenideElement searchMapField = $(By.xpath("//div[@role='heading']//input"));
    private final List<SelenideElement> maps = $$(By.xpath("//a[i[@class='icon-external-link']]"));
    private final SelenideElement consoleMenu = $(By.xpath("//a[@data-test='menu-console']"));
    private final SelenideElement consoleTextArea = $(By.xpath("//textarea[@id='commandOutput']"));
    private final SelenideElement consoleInput = $(By.xpath("//input[@id='commandInput']"));
    private final SelenideElement logOutBtn = $(By.xpath("//a[@title='Logout']"));
    private final SelenideElement arrowRightBtn = $(By.xpath("//button[@class='rt-pagination-button' and .='\uF105']"));

    /**
     * Метод дожидается прогрузки сайдбара
     */
    public void waitUntilSideBarLoaded() {
        sideBarMaps.waitUntil(Condition.visible, 10000);
    }

    /**
     * Метод нажимает на сайдбар с Maps
     */
    public void clickMaps() {
        sideBarMaps.click();
    }

    /**
     * Метод возвращает видимость поля поиска мэп
     * @return Boolean
     */
    public boolean isSearchMapFieldVisible() {
        return searchMapField.is(Condition.visible);
    }

    /**
     * Метод дожидается отображения поля поиска мэп
     */
    public void waitUntilSearchMapFieldVisible() {
        searchMapField.shouldBe(Condition.visible);
    }

    /**
     * Метод очищает поле поиска мэп
     */
    public void clearSearchMap() {
        searchMapField.clear();
    }

    /**
     * Метод дожидается отображения первой мэпы
     */
    public void waitUntilFirstMapVisible() {
        maps.get(0).shouldBe(Condition.visible);
    }

    /**
     * Метод получает все мэпы из таблицы на странице
     * @return List
     */
    public List<String> getAllMaps() {
        return maps.stream().map(SelenideElement::getText).collect(Collectors.toList());
    }

    /**
     * Метод кликает на меню Консоль
     */
    public void clickConsole() {
        consoleMenu.click();
    }

    /**
     * Метод дожидается отображения самой консоли с вводом текста
     */
    public void waitUntilConsoleTextAreaVisible() {
        consoleTextArea.shouldBe(Condition.visible);
    }

    /**
     * Метод вводит в консоль команду
     * @param text String команда
     */
    public void typeConsole(String text) {
        consoleInput.setValue(text).pressEnter();
    }

    /**
     * Метод нажимает на кнопку выхода
     */
    public void clickLogOut() {
        logOutBtn.click();
    }

    /**
     * Метод возвращает видимость стрелки вправо в пейджере
     * @return Boolean
     */
    public boolean isArrowRightVisible() {
        return arrowRightBtn.is(Condition.visible);
    }

    /**
     * Метод нажимает на кнопку > в пейджере
     */
    public void clickArrowRightBtn() {
        arrowRightBtn.click();
    }

    /**
     * Метод возвращает доступность стрелки > для нажатия в пейджере
     * @return Boolean
     */
    public boolean isArrowRightBtnEnabled() {
        return arrowRightBtn.is(Condition.enabled);
    }

    /**
     * Метод дожидается смены неймСпейса
     * @param namespace String пространство имен
     */
    public void waitUntilNameSpaceChanged(String namespace) {
        for (int i = 0; i < 10; i++) {
            if (consoleTextArea.getAttribute("value").endsWith("namespace: " + namespace + "\n")) break;
            else {
                Selenide.sleep(300);
            }
        }
    }

    /**
     * Метод дожидается очистки пространства имен
     * @param namespace String пространство имен
     */
    public void waitUntilNameSpaceCleared(String namespace) {
        for (int i = 0; i < 10; i++) {
            if (consoleTextArea.getAttribute("value").endsWith(namespace + "> Cleared all.\n")) break;
            else {
                Selenide.sleep(300);
            }
        }
    }
}
