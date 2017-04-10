import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by suci on 4/5/17.
 */
@Features("Login Test")
public class ExampleTest extends AndroidSetup {
    ExamplePage page;

    @Stories("As a User I want to be able to login")
    @Title("User Login Success")
    @Test
    public void testLogin_CorrectCredential_Success(){
        page = new ExamplePage(driver);
        page.typeUsername("athena@olx.com");
        page.typePassword("123456");
        page.clickLoginButton();
        page.verifySuccessLogin();
    }

    @Stories("As a User I want to get error message while login using wrong credentials")
    @Title("Fail Login")
    @Test
    public void testLogin_inCorrectCredential_Fail(){
        page = new ExamplePage(driver);
        page.typeUsername("wrong email");
        page.typePassword("wrong password");
        page.clickLoginButton();
        page.verifyFailLogin();
    }
}
