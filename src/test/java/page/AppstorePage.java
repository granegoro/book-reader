package page;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static java.time.Duration.ofSeconds;

public class AppstorePage {

    private static final SelenideElement storeHeading = $("#ac-gn-firstfocus");
    private static final SelenideElement appHeading = $(byText("билайн книги и аудиокниги"));

    public AppstorePage() {
        storeHeading.shouldBe(visible, Duration.ofSeconds(10));
        appHeading.shouldBe(visible, Duration.ofSeconds(10));
    }


}
