package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import javax.lang.model.util.Elements;

public class LoginPage {

    @FindBy(css = ".login_menu li")
    private static ElementsCollection loginMenuButtons;

    private static final SelenideElement appButtonTop = loginMenuButtons.get(0);
    private static final SelenideElement subscribeButtonTop = loginMenuButtons.get(1);

    @FindBy(css = ".login_menu .banner_subscribe_button")
    private static SelenideElement loginButtonTop;

    @FindBy(css = "div .login_button_top")
    private static SelenideElement loginButtonYellow;

    @FindBy(css = "#login_download_section  .app_icon")
    private static ElementsCollection appIcons;

    private static final SelenideElement AppStoreButton = appIcons.get(0);
    private static final SelenideElement GooglePlayButton = appIcons.get(1);
    private static final SelenideElement AppAppGalleryButton = appIcons.get(2);
    private static final SelenideElement RuStoreButton = appIcons.get(3);

    @FindBy(css = "center .login_button_bottom")
    private static SelenideElement subscribeButtonYellow;

    @FindBy(css = ".authTypeSelectArea .m_logIn_enterWithNumber_button")
    private static SelenideElement enterWithNumberButton;

    @FindBy(css = ".authTypeSelectArea .authTypeSelectArea .m_logIn_enterWithMID_button")
    private static SelenideElement enterWithMidButton;

    @FindBy(css = ".m_logIn_panel .login_policy")
    private static SelenideElement loginPolicyLink;

    @FindBy(css = "input#m_logIn_PhoneNumber_new")
    private static SelenideElement phoneNumberField;

    @FindBy(linkText = "Необходимо ввести корректный номер телефона")
    private static SelenideElement insufficientPhoneNumber;

    @FindBy(linkText = "Сервис доступен только абонентам Билайн")
    private static SelenideElement notBeelinePhoneNumber;

    @FindBy(css = ".enterWithNumberArea .m_login_getPin_button")
    private static SelenideElement sendCodeButton;

    @FindBy(css = ".m_login_line2_smsPinCode input#m_logIn_SmsPin")
    private static SelenideElement smsCodeField;

    @FindBy(linkText = "Введен неверный код")
    private static SelenideElement incorrectCode;

    @FindBy(css = ".enterWithNumberArea .m_login_checkPin_button")
    private static SelenideElement verifyCodeButton;

    public static void pushLoginButton() {
        loginButtonYellow.click();
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
