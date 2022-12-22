package page;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AppgalleryPage {

//    private static final SelenideElement storeHeading = $(byText("AppGallery"));
    private static final SelenideElement appHeading = $(byText("билайн книги и аудиокниги"));

    public void checkHeading() {
//        storeHeading.shouldBe(visible, Duration.ofSeconds(10));
        appHeading.shouldBe(visible, Duration.ofSeconds(10));
    }
}
