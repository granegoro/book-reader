package test;

import org.junit.jupiter.api.Test;
import page.LoginPage;
import static com.codeborne.selenide.Selenide.*;

public class UITest {

    @Test
    public void shouldLoginWithTestCredentials() {
        var loginPage = open(System.getProperty("sut.url"), LoginPage.class);
        var mainPage = loginPage.performLogin();


    }
}
