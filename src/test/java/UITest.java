import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class UITest {

    public void newTab() {
        Robot r = null;
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_T);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_T);
    }

    public static String baseUri = "https://books.beeline.ru/promo/NY23/books/";
    public static String gmail = "https://mail.google.com/";
    public static String phone1 = "9060328283";
    public static String phone2 = "9032568421";
    public static String login = "bbookssmsforwarder@gmail.com";
    public static String password = "beelinesms1488";

    public static SelenideElement getSms = $(byText("ПОЛУЧИТЬ КОД В СМС"));
    public static SelenideElement nextButton = $(byText("Next"));
    public static SelenideElement passwordField = $("#password input");
    public static SelenideElement phoneNumberField = $("input#m_logIn_PhoneNumber_new");
    public static SelenideElement emailField = $("input#identifierId");
    @Test
    public void shouldActivatePromo() {

        

        open(baseUri);
        newTab();
        switchTo().window(1);
        open("https://mail.ru/");
        $("[data-testid=enter-mail-primary]").click();
        $("input[name='username']").setValue("login");
        $("[data-test-id=next-button]");
        $("input[placeholder='Password']").setValue("pass");
        $("[data-test-id=submit-button]").click();
//        nextButton.click();
//        passwordField.shouldBe(visible, Duration.ofSeconds(15)).setValue(password);





//        phoneNumberField.setValue(phone2);
//        getSms.click();
//        switchTo().window(gmail);





    }
}
