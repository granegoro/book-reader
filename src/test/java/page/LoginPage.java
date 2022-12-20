package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import javax.lang.model.util.Elements;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

//    @FindBy(css = ".login_menu li")
    private static final ElementsCollection loginMenuButtons = $$(".login_menu li");

    private static final SelenideElement appButtonTop = loginMenuButtons.get(0);
    private static final SelenideElement subscribeButtonTop = loginMenuButtons.get(1);

//    @FindBy(css = ".login_menu .banner_subscribe_button")
    private static final SelenideElement loginButtonTop = $(".login_menu .banner_subscribe_button");

//    @FindBy(css = "div .login_button_top")
    private static final SelenideElement loginButtonYellow = $("div .login_button_top");

//    @FindBy(css = "#login_download_section  .app_icon")
    private static final ElementsCollection appIcons = $$("#login_download_section  .app_icon");

    private static final SelenideElement AppStoreButton = appIcons.get(0);
    private static final SelenideElement GooglePlayButton = appIcons.get(1);
    private static final SelenideElement AppAppGalleryButton = appIcons.get(2);
    private static final SelenideElement RuStoreButton = appIcons.get(3);

//    @FindBy(css = "center .login_button_bottom")
    private static final SelenideElement subscribeButtonYellow = $("center .login_button_bottom");

//    @FindBy(css = ".authTypeSelectArea .m_logIn_enterWithNumber_button")
    private static final SelenideElement enterWithSmsCodeButton = $(".authTypeSelectArea .m_logIn_enterWithNumber_button");

//    @FindBy(css = ".authTypeSelectArea .authTypeSelectArea .m_logIn_enterWithMID_button")
    private static final SelenideElement enterWithMidButton = $(".authTypeSelectArea .authTypeSelectArea .m_logIn_enterWithMID_button");

//    @FindBy(css = ".m_logIn_panel .login_policy")
    private static final SelenideElement loginPolicyLink = $(".m_logIn_panel .login_policy");

//    @FindBy(css = "input#m_logIn_PhoneNumber_new")
    private static final SelenideElement phoneNumberField = $("input#m_logIn_PhoneNumber_new");

//    @FindBy(linkText = "Необходимо ввести корректный номер телефона")
    private static final SelenideElement insufficientPhoneNumber = $("Необходимо ввести корректный номер телефона");

//    @FindBy(linkText = "Сервис доступен только абонентам Билайн")
    private static final SelenideElement notBeelinePhoneNumber = $("Сервис доступен только абонентам Билайн");

//    @FindBy(css = ".enterWithNumberArea .m_login_getPin_button")
    private static final SelenideElement requestCodeButton = $(".enterWithNumberArea .m_login_getPin_button");

//    @FindBy(css = ".m_login_line2_smsPinCode input#m_logIn_SmsPin")
    private static final SelenideElement smsCodeField = $(".m_login_line2_smsPinCode input#m_logIn_SmsPin");

//    @FindBy(linkText = "Введен неверный код")
    private static final SelenideElement incorrectCode = $("Введен неверный код");

//    @FindBy(css = ".enterWithNumberArea .m_login_checkPin_button")
    private static final SelenideElement verifyCodeButton = $(".enterWithNumberArea .m_login_checkPin_button");

    public MainPage performLogin() {
        loginButtonYellow.click();
        enterWithSmsCodeButton.click();
        phoneNumberField.setValue(System.getProperty("phoneNumber"));
        requestCodeButton.click();
        smsCodeField.setValue(System.getProperty("code"));
        verifyCodeButton.click();
        return new MainPage();
    }

    public static void pushAppStoreButton() {
        AppStoreButton.click();
    }
    public static void pushGooglePlayButton() {
        GooglePlayButton.click();
    }
    public static void pushAppGalleryButton() {
        AppAppGalleryButton.click();
    }
    public static void pushRuStoreButton() {
        RuStoreButton.click();
    }
}
