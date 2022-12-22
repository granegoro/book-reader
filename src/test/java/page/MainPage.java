package page;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    private static final SelenideElement heading = $$(".navbar-nav ").find(exactText("Главная"));

//    public MainPage() {
//        heading.shouldBe(visible, Duration.ofSeconds(10));
//    }
}
