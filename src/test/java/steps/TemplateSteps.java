package steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import page.LoginPage;
import page.MainPage;


public class TemplateSteps {
    private static LoginPage loginPage;
    private static MainPage mainPage;

    @Пусть("открыт лендинг {string}")
    public void openLoginPage(String url) {
        loginPage = Selenide.open(url, LoginPage.class);
    }

    @Когда("пользователь пытается авторизоваться с телефоном {string}")
    public void loginWithNameAndPassword(String phoneNumber) {
        loginPage.enterPhoneNumberForGherkin(phoneNumber);
    }

    @И("пользователь вводит проверочный код 'из смс' {string}")
    public void setValidCode(String verificationCode) {
        mainPage = loginPage.enterCodeForGherkin(verificationCode);
    }

    @Тогда("происходит успешная авторизация и пользователь попадает на страницу 'Главная страница'")
    public void verifyMainPage() {
        mainPage.verifyIsMainPage();
    }

//    @Тогда("появляется ошибка о неверном коде проверки")
//    public void verifyCodeIsInvalid() {
//        verificationPage.verifyCodeIsInvalid();
//    }
}
