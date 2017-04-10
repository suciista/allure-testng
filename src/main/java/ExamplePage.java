import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by suci on 4/5/17.
 */
public class ExamplePage extends BasePage {

    private String userNameField = "com.naspers_classifieds.loginsample:id/username";
    private String passwordField = "com.naspers_classifieds.loginsample:id/password";
    private String loginButton = "com.naspers_classifieds.loginsample:id/login";
    private String messageText = "com.naspers_classifieds.loginsample:id/message";

    public ExamplePage(WebDriver driver) {
        super(driver);
    }

    @Step("I type username")
    public void typeUsername(String username){
        typeElement("Id",userNameField,username);
    }

    @Step("I type password")
    public void typePassword(String password){
        typeElement("Id",passwordField, password);
    }

    @Step("I click login button")
    public void clickLoginButton(){
        clickElement("ID", loginButton);
    }

    @Step("I verify login is success")
    public void verifySuccessLogin(){
        Assert.assertEquals(getTextString("ID",messageText),"Success!","Can not find Success!");
    }

    @Step("I verify login is fail")
    public void verifyFailLogin(){
        Assert.assertEquals(getTextString("ID",messageText),"Failure!","Can not fing Failure!");
    }
}
