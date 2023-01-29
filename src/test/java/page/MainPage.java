package page;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    private final SelenideElement heading = $("#search-top-section");

    private static final SelenideElement sidebarButton = $("#header_userName");
    private static final SelenideElement logoutButton = $("#m_userSidebar .m_userSidebar_userInfo_data h4");

    public void verifyIsMainPage(){
        heading.shouldBe(visible);
    }

    public LoginPage logOut() {
        sidebarButton.click();
        logoutButton.click();
        return new LoginPage();
    }


//    public MainPage() {
//        heading.shouldBe(visible, Duration.ofSeconds(10));
//    }
}
