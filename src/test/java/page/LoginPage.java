package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private static final ElementsCollection loginMenuButtons = $$(".container .login_menu ul li");
//    private static final SelenideElement appButtonHeader = loginMenuButtons.findBy(text("Приложение"));
    private static final SelenideElement subscribeButtonHeader = loginMenuButtons.get(1);
//    private static final ElementsCollection header =
//        $$(byText("Вход"));
//    private static final SelenideElement loginHeader = header.get(4);

    private static final SelenideElement loginButtonYellow = $("div .login_button_top");

    private static final ElementsCollection appIcons = $$("#login_download_section .app_icon");

    private static final SelenideElement appStoreButton = appIcons.get(0);
    private static final SelenideElement googlePlayButton = appIcons.get(1);
    private static final SelenideElement appGalleryButton = appIcons.get(2);
    private static final SelenideElement ruStoreButton = appIcons.get(3);

    private static final SelenideElement subscribeButtonYellow =
            $(byText("ПОДПИСАТЬСЯ"));

    private static final SelenideElement enterWithSmsCodeButton =
            $(".authTypeSelectArea .m_logIn_enterWithNumber_button");

//    private static final SelenideElement enterWithMobIdButton =
//            $(".authTypeSelectArea .authTypeSelectArea .m_logIn_enterWithMID_button");

    private static final SelenideElement loginPolicyLink = $(".m_logIn_panel .login_policy");
    private static final SelenideElement policyPanel = $(".m_policy_panel.m_policy_panel");

    private static final SelenideElement phoneNumberField = $("input#m_logIn_PhoneNumber_new");

    private static final SelenideElement invalidPhoneNumberErrorMessage =
            $(".enterWithNumberArea_inner .m_login_line3_errorText");

    private static final SelenideElement invalidCodeError = $(".enterWithNumberArea_inner .addit_error_text");

    private static final SelenideElement requestCodeButton = $(".enterWithNumberArea .m_login_getPin_button");

    private static final SelenideElement smsCodeField = $(".enterWithNumberArea input#m_logIn_SmsPin");

    private static final SelenideElement verifyCodeButton =
            $(".enterWithNumberArea .m_login_checkPin_button");

    private static final SelenideElement successfulSubscriptionMessage  = $(byText("Поздравляем!"));
    private static final SelenideElement closeSubscriptionPanel  =
            $(".congratsArea_inner .m_login_line3_subscribeSuccess_button");
    public static void performLogin() {

        phoneNumberField.setValue(System.getProperty("phoneNumber"));
        requestCodeButton.click();
        smsCodeField.setValue(System.getProperty("code"));
        verifyCodeButton.click();
    }

    public MainPage performLoginViaYellowButton() {
        loginButtonYellow.click();
        enterWithSmsCodeButton.click();
        performLogin();
        return new MainPage();
    }

//    public static MainPage performLoginViaHeaderButton() {
//        loginHeader.click();
//        enterWithSmsCodeButton.click();
//        performLogin();
//        return new MainPage();
//    }

    public MainPage performSubscription() {
        subscribeButtonHeader.click();
        subscribeButtonYellow.click();
        performLogin();
        successfulSubscriptionMessage.shouldBe(visible);
        closeSubscriptionPanel.click();
        return new MainPage();
    }

    public void findInsufficientPhoneNumberError() {
        loginButtonYellow.click();
        enterWithSmsCodeButton.click();
        phoneNumberField.setValue("999");
        requestCodeButton.click();
        invalidPhoneNumberErrorMessage.shouldBe(visible);
    }

    public void findNotBeelinePhoneNumberError() {
        loginButtonYellow.click();
        enterWithSmsCodeButton.click();
        phoneNumberField.setValue("9999999999");
        requestCodeButton.click();
        invalidPhoneNumberErrorMessage.shouldBe(visible);
    }

    public void findIncorrectCodeError() {
        loginButtonYellow.click();
        enterWithSmsCodeButton.click();
        phoneNumberField.setValue(System.getProperty("phoneNumber"));
        requestCodeButton.click();
        smsCodeField.setValue("1234");
        verifyCodeButton.click();
        invalidCodeError.shouldBe(visible);
    }

    public void checkLoginPolicy() {
        loginButtonYellow.click();
        loginPolicyLink.click();
        policyPanel.shouldBe(visible);
        refresh();
    }

    public void pushAppGalleryButton() {
        appGalleryButton.click();
        AppgalleryPage appgalleryPage = new AppgalleryPage();
        switchTo().window(1);
        appgalleryPage.checkHeading();
    }

//    public static void pushAppStoreButton() {
//        appButtonHeader.click();
//        appStoreButton.click();
//        switchTo().window(1);
//        AppstorePage appstorePage = new AppstorePage();
//    }
//    public static GoogleplayPage pushGooglePlayButton() {
//        appButtonHeader.click();
//        googlePlayButton.click();
//        switchTo().window(1);
//        GoogleplayPage googleplayPage = new GoogleplayPage();
//    }
//    public static RustorePage pushRuStoreButton() {
//        appButtonHeader.click();
//        ruStoreButton.click();
//        switchTo().window(1);
//        return new RustorePage();
//    }
}
