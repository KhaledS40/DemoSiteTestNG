package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageFactory.LandingPage;
import testComponents.BaseTest;


public class LandingHomePage extends BaseTest {

    LandingPage landing = new LandingPage(driver);

    @Test
    public void clickLandingPageLinks() throws IOException {

        landing = new LandingPage(driver);
        landing.clickHomeLink();
        landing.clickRegisterLink();
        landing.clickWebTableLink();
    }
}
