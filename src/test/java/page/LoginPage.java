package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private static final ElementsCollection loginMenuButtons = $$(".login_menu li");

    private static final SelenideElement appButtonHeader = loginMenuButtons.get(0);
    private static final SelenideElement subscribeButtonHeader = loginMenuButtons.get(1);
    private static final SelenideElement loginButtonHeader = loginMenuButtons.get(3);

    private static final SelenideElement loginButtonYellow = $("div .login_button_top");

    private static final ElementsCollection appIcons = $$("#login_download_section .app_icon");

    private static final SelenideElement appStoreButton = appIcons.get(0);
    private static final SelenideElement googlePlayButton = appIcons.get(1);
    private static final SelenideElement appGalleryButton = appIcons.get(2);
    private static final SelenideElement ruStoreButton = appIcons.get(3);

    private static final SelenideElement subscribeButtonYellow = $("center .login_button_bottom");

    private static final SelenideElement enterWithSmsCodeButton =
            $(".authTypeSelectArea .m_logIn_enterWithNumber_button");

//    private static final SelenideElement enterWithMobIdButton =
//            $(".authTypeSelectArea .authTypeSelectArea .m_logIn_enterWithMID_button");

    private static final SelenideElement loginPolicyLink = $(".m_logIn_panel .login_policy");
    private static final SelenideElement policyPanel = $(".m_policy_panel.m_policy_panel");

    private static final SelenideElement phoneNumberField = $("input#m_logIn_PhoneNumber_new");

    private static final SelenideElement insufficientPhoneNumberErrorMessage =
            $("Необходимо ввести корректный номер телефона");

    private static final SelenideElement notBeelinePhoneNumberErrorMessage =
            $("Сервис доступен только абонентам Билайн");

    private static final SelenideElement requestCodeButton = $(".enterWithNumberArea .m_login_getPin_button");

    private static final SelenideElement smsCodeField = $(".m_login_line2_smsPinCode input#m_logIn_SmsPin");

    private static final SelenideElement incorrectCodeErrorMessage = $("Введен неверный код");

    private static final SelenideElement verifyCodeButton =
            $(".enterWithNumberArea .m_login_checkPin_button");

    public static void performLogin(String phoneNumber, String code) {

        phoneNumberField.setValue(phoneNumber);
        requestCodeButton.click();
        smsCodeField.setValue(code);
        verifyCodeButton.click();
    }

    public MainPage performLoginViaYellowButton() {
        loginButtonYellow.click();
        enterWithSmsCodeButton.click();
        performLogin(System.getProperty("phoneNumber"), System.getProperty("code"));
        return new MainPage();
    }

    public static MainPage performLoginViaHeaderButton() {
        loginButtonHeader.click();
        enterWithSmsCodeButton.click();
        performLogin(System.getProperty("phoneNumber"), System.getProperty("code"));
        return new MainPage();
    }

    public static MainPage performSubscription() {
        subscribeButtonHeader.click();
        subscribeButtonYellow.click();
        performLogin(System.getProperty("phoneNumber"), System.getProperty("code"));
        return new MainPage();
    }

    public static void findInsufficientPhoneNumberError() {
        loginButtonYellow.click();
        enterWithSmsCodeButton.click();
        performLogin("999", null);
        insufficientPhoneNumberErrorMessage.shouldBe(visible, Duration.ofSeconds(10));
    }

    public static void findNotBeelinePhoneNumberError() {
        loginButtonYellow.click();
        enterWithSmsCodeButton.click();
        performLogin("9999999999", null);
        notBeelinePhoneNumberErrorMessage.shouldBe(visible, Duration.ofSeconds(10));
    }

    public static void findIncorrectCodeError() {
        loginButtonYellow.click();
        enterWithSmsCodeButton.click();
        performLogin(System.getProperty("phoneNumber"), "0000");
        incorrectCodeErrorMessage.shouldBe(visible, Duration.ofSeconds(10));
    }

    public static void checkLoginPolicy() {
        loginButtonYellow.click();
        loginPolicyLink.click();
        policyPanel.shouldBe(visible);
    }

    public static void pushAppStoreButton() {
        appButtonHeader.click();
        appStoreButton.click();
        switchTo().window(1);
        AppstorePage appstorePage = new AppstorePage();
    }
//    public static GoogleplayPage pushGooglePlayButton() {
//        appButtonHeader.click();
//        googlePlayButton.click();
//        switchTo().window(1);
//        GoogleplayPage googleplayPage = new GoogleplayPage();
//    }
    public static void pushAppGalleryButton() {
        appButtonHeader.click();
        appGalleryButton.click();
        switchTo().window(1);
        AppgalleryPage appgalleryPage = new AppgalleryPage();
    }
    public static RustorePage pushRuStoreButton() {
        appButtonHeader.click();
        ruStoreButton.click();
        switchTo().window(1);
        return new RustorePage();
    }
}
