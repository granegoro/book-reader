package page;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private static final SelenideElement heading = $(".navbar-brand");

    public MainPage() {
        heading.shouldBe(visible, Duration.ofSeconds(10));
    }
}
