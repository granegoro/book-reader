package test;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import page.LoginPage;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static page.LoginPage.performLogin;

public class UITest {


//    public static SelenideElement getSms = $(byText("ПОЛУЧИТЬ КОД В СМС"));
//    public static SelenideElement nextButton = $(byText("Next"));
//    public static SelenideElement passwordField = $("#password input");
//    public static SelenideElement phoneNumberField = $("input#m_logIn_PhoneNumber_new");
//    public static SelenideElement emailField = $("input#identifierId");
    @Test
    public void shouldLoginWithTestCredentials() {
        var loginPage = open(System.getProperty("sut.url"), LoginPage.class);
        performLogin();







    }
}
