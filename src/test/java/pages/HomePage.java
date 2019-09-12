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
 * ����� �������� ��������
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
     * ����� ���������� ��������� ��������
     */
    public void waitUntilSideBarLoaded() {
        sideBarMaps.waitUntil(Condition.visible, 10000);
    }

    /**
     * ����� �������� �� ������� � Maps
     */
    public void clickMaps() {
        sideBarMaps.click();
    }

    /**
     * ����� ���������� ��������� ���� ������ ���
     * @return Boolean
     */
    public boolean isSearchMapFieldVisible() {
        return searchMapField.is(Condition.visible);
    }

    /**
     * ����� ���������� ����������� ���� ������ ���
     */
    public void waitUntilSearchMapFieldVisible() {
        searchMapField.shouldBe(Condition.visible);
    }

    /**
     * ����� ������� ���� ������ ���
     */
    public void clearSearchMap() {
        searchMapField.clear();
    }

    /**
     * ����� ���������� ����������� ������ ����
     */
    public void waitUntilFirstMapVisible() {
        maps.get(0).shouldBe(Condition.visible);
    }

    /**
     * ����� �������� ��� ���� �� ������� �� ��������
     * @return List
     */
    public List<String> getAllMaps() {
        return maps.stream().map(SelenideElement::getText).collect(Collectors.toList());
    }

    /**
     * ����� ������� �� ���� �������
     */
    public void clickConsole() {
        consoleMenu.click();
    }

    /**
     * ����� ���������� ����������� ����� ������� � ������ ������
     */
    public void waitUntilConsoleTextAreaVisible() {
        consoleTextArea.shouldBe(Condition.visible);
    }

    /**
     * ����� ������ � ������� �������
     * @param text String �������
     */
    public void typeConsole(String text) {
        consoleInput.setValue(text).pressEnter();
    }

    /**
     * ����� �������� �� ������ ������
     */
    public void clickLogOut() {
        logOutBtn.click();
    }

    /**
     * ����� ���������� ��������� ������� ������ � ��������
     * @return Boolean
     */
    public boolean isArrowRightVisible() {
        return arrowRightBtn.is(Condition.visible);
    }

    /**
     * ����� �������� �� ������ > � ��������
     */
    public void clickArrowRightBtn() {
        arrowRightBtn.click();
    }

    /**
     * ����� ���������� ����������� ������� > ��� ������� � ��������
     * @return Boolean
     */
    public boolean isArrowRightBtnEnabled() {
        return arrowRightBtn.is(Condition.enabled);
    }

    /**
     * ����� ���������� ����� ����������
     * @param namespace String ������������ ����
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
     * ����� ���������� ������� ������������ ����
     * @param namespace String ������������ ����
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
