package page;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    private static final SelenideElement heading = $$(".navbar-nav ").find(exactText("Главная"));

    private static final SelenideElement sidebarButton = $("#header_userName");
    private static final SelenideElement logoutButton = $("#m_userSidebar .m_userSidebar_userInfo_data h4");

    public void logOut() {
        sidebarButton.click();
        logoutButton.click();
    }


//    public MainPage() {
//        heading.shouldBe(visible, Duration.ofSeconds(10));
//    }
}
