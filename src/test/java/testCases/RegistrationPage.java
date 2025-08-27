package testCases;
import org.testng.annotations.Test;
import pageFactory.Registration;
import testComponents.BaseTest;


public class RegistrationPage extends BaseTest {

	Registration reg = new Registration(driver);

    @Test
    public void RegisterToThePage() throws InterruptedException {
    	
        reg = new Registration(driver);
        reg.enterName();
        reg.enterLastName();
        reg.addText();
        reg.enterEmail();
        reg.enterPhoneNumber();
        reg.selectGender();
        reg.selectHobbies();
        //reg.selectLanguage();
        reg.selectSkills();
       // reg.countrySelect();
        //reg.enterDateOfBirth();
        //reg.selectMonth();
        //reg.selectDay();
        reg.enterPassword();
        reg.enterConfirmedPassword();
        reg.clickSubmit();
        reg.takeScreenShot();

    }
}
