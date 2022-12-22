package test;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.LoginPage;

import static com.codeborne.selenide.Selenide.*;

public class UITest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @AfterEach
    void refreshPage() {
        Selenide.refresh();
    }


    String sut = System.getProperty("sut.url");

    @Test
    public void shouldSuccessfullySubscribeWithTestCredentials() {
        var loginPage = open(sut, LoginPage.class);
        var mainPage = loginPage.performSubscription();
        mainPage.logOut();
    }

    @Test
    public void shouldSuccessfullyLoginViaYellowButtonWithTestCredentials() {
        var loginPage = open(sut, LoginPage.class);
        var mainPage = loginPage.performLoginViaYellowButton();
        mainPage.logOut();
    }

    @Test
    public void shouldFindInsufficientPhoneNumberError() {
        var loginPage = open(sut, LoginPage.class);
        loginPage.findInsufficientPhoneNumberError();
    }

    @Test
    public void shouldFindNotBeelinePhoneNumberError() {
        var loginPage = open(sut, LoginPage.class);
        loginPage.findNotBeelinePhoneNumberError();
    }

    @Test
    public void shouldFindIncorrectCodeError() {
        var loginPage = open(sut, LoginPage.class);
        loginPage.findIncorrectCodeError();
    }

    @Test
    public void shouldOpenPolicyPopup() {
        var loginPage = open(sut, LoginPage.class);
        loginPage.checkLoginPolicy();
    }

    @Test
    public void checkInAppGallery() {
        var loginPage = open(sut, LoginPage.class);
        loginPage.pushAppGalleryButton();
    }

//    @Test
//    public void checkInAppStore() {
//        var loginPage = open(sut, LoginPage.class);
//        loginPage.pushAppStoreButton();
//    }
//
//    @Test
//    public void checkInRuStore() {
//        var loginPage = open(sut, LoginPage.class);
//        loginPage.pushRuStoreButton();
//    }
//    @Test
//    public void shouldSuccessfullyLoginViaHeaderButtonWithTestCredentials() {
//        var loginPage = open(sut, LoginPage.class);
//        var mainPage = loginPage.performLoginViaHeaderButton();
//    }

}
