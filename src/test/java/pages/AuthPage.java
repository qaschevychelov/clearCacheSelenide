package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


/**
 * Пейдж экрана авторизации
 */
public class AuthPage {
    private final SelenideElement userName = $(By.xpath("//input[@name='username']"));
    private final SelenideElement passWord = $(By.xpath("//input[@name='password']"));
    private final SelenideElement signInBtn = $(By.xpath("//button[i[@class='icon-signin']]"));

    /**
     * Метод задает поле логина
     * @param userName String значение
     */
    public void setUserName(String userName) {
        this.userName.setValue(userName);
    }

    /**
     * Метод задает поле пароль
     * @param passWord String значение
     */
    public void setPassWord(String passWord) {
        this.passWord.setValue(passWord);
    }

    /**
     * Метод кликает по кнопке Войти
     */
    public void clickSignIn() {
        signInBtn.click();
    }

    /**
     * Метод ожидает видимости поля логин
     */
    public void waitUntilUserNameVisible() {
        userName.shouldBe(Condition.visible);
    }
}
