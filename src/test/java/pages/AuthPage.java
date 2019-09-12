package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


/**
 * ����� ������ �����������
 */
public class AuthPage {
    private final SelenideElement userName = $(By.xpath("//input[@name='username']"));
    private final SelenideElement passWord = $(By.xpath("//input[@name='password']"));
    private final SelenideElement signInBtn = $(By.xpath("//button[i[@class='icon-signin']]"));

    /**
     * ����� ������ ���� ������
     * @param userName String ��������
     */
    public void setUserName(String userName) {
        this.userName.setValue(userName);
    }

    /**
     * ����� ������ ���� ������
     * @param passWord String ��������
     */
    public void setPassWord(String passWord) {
        this.passWord.setValue(passWord);
    }

    /**
     * ����� ������� �� ������ �����
     */
    public void clickSignIn() {
        signInBtn.click();
    }

    /**
     * ����� ������� ��������� ���� �����
     */
    public void waitUntilUserNameVisible() {
        userName.shouldBe(Condition.visible);
    }
}
